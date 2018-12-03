package br.cefetmg.implicare.adapter;

import br.cefetmg.implicare.model.serviceImpl.*;
import br.cefetmg.implicare.model.domain.*;
import br.cefetmg.implicare.model.service.*;
import br.cefetmg.implicare.model.exception.*;
import br.cefetmg.implicare.inf.servidor.Servidor;
import br.cefetmg.inf.implicare.util.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdapterCore implements Runnable{

    private final InetAddress enderecoIP;
    private final int portaCliente;
    private final Pacote pacote;
    private final Gson gson;
    
    public AdapterCore(InetAddress enderecoIP, int portaCliente, Pacote pacote){
        this.enderecoIP = enderecoIP;
        this.portaCliente = portaCliente;
        this.pacote = pacote;
        gson = new Gson();
    }
    
    
    @Override
    public void run() {
        try {
            analisaTipoOperacao();
        } catch (PersistenceException ex) {
            Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviaPacoteResposta(Pacote pctResposta) throws IOException, RemoteException {
        Servidor.enviaDados(enderecoIP, portaCliente, pctResposta);
    }
    
    public void analisaTipoOperacao() throws PersistenceException, RemoteException{
        TipOperacao tipOperacao = pacote.getTipoOperacao();
        Pacote pctResposta;
        
        
        AreaEstudoManagement areaEstudo = new AreaEstudoManagementImpl();
        
        CandidatoVagaDialogoManagement candVagaDialog = new CandidatoVagaDialogoManagementImpl();
        CandidatoVagaManagement candVaga = new CandidatoVagaManagementImpl();
        CargoAreaEstudoManagement cargoAreaEstudo = new CargoAreaEstudoMangementImpl();
        CargoInteresseManagement cargoInteresse = new CargoInteresseManagementImpl();
        CargoManagement cargo = new CargoManagementImpl();
        CidadeManagement cidade = new CidadeManagementImpl();
        CompetenciaManagement competencia = new CompetenciaManagementImpl();
        CompetenciaPessoaFisicaManagement competenciaPessoaFisica = new CompetenciaPessoaFisicaManagementImpl();
        EmpresaManagement empresa = new EmpresaManagementImpl();
        EstadoManagement estado = new EstadoManagementImpl();
        ExperienciaProfissionalManagement experienciaProfissional = new ExperienciaProfissionalManagementImpl();
        FormacaoAcademicaManagement formacaoAcademica = new FormacaoAcademicaManagementImpl();
        PessoaFisicaManagement pessoaFisica = new PessoaFisicaManagementImpl();
        ProficienciaManagement proficiencia = new ProficienciaManagementImpl();
        TelefoneManagement telefone = new TelefoneManagementImpl();
        UsuarioManagement usuario = new UsuarioManagementImpl();
        VagaManagement vaga = new VagaManagementImpl();
        
        switch(tipOperacao){
            case LISTA_AREA_ESTUDO: {
                
                ArrayList<AreaEstudo> listAreaEstudo = new ArrayList<>();
                try {
                    listAreaEstudo = areaEstudo.listAll();
                } catch (PersistenceException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(listAreaEstudo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case PESQ_AREA_ESTUDO_COD: {
                
                AreaEstudo listAreaEstudo;
                listAreaEstudo = areaEstudo.getAreaEstudoCod(gson.fromJson(pacote.getDados().get(0), int.class));
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(listAreaEstudo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case INSERT_CAND_VAGA_DIALOG: {
                

            try {
                candVagaDialog.insert(gson.fromJson(pacote.getDados().get(0), CandidatoVagaDialogo.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case LISTA_CAND_VAGA_DIALOG: {
                
                List<CandidatoVagaDialogo> candidatoVagaDialogo;
                candidatoVagaDialogo = candVagaDialog.getCandidatoVagaDialogo(gson.fromJson(pacote.getDados().get(0), long.class),
                            gson.fromJson(pacote.getDados().get(1), int.class),
                            gson.fromJson(pacote.getDados().get(2), long.class),
                            gson.fromJson(pacote.getDados().get(3),(java.lang.reflect.Type) Date.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(candidatoVagaDialogo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
                break;
            }
            case GET_CAND_VAGA_DIALOG_WITHTIMESTAMP: {
                
                CandidatoVagaDialogo candidatoVagaDialogo;
                candidatoVagaDialogo = candVagaDialog.getCandidatoVagaDialogoCod(gson.fromJson(pacote.getDados().get(0), long.class),
                            gson.fromJson(pacote.getDados().get(1), int.class),
                            gson.fromJson(pacote.getDados().get(2), long.class),
                            gson.fromJson(pacote.getDados().get(3),(java.lang.reflect.Type) Date.class),
                            gson.fromJson(pacote.getDados().get(4), Timestamp.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(candidatoVagaDialogo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case INSERT_CAND_VAGA: {
                
            try {
                candVaga.insert(gson.fromJson(pacote.getDados().get(0), CandidatoVaga.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case ATUALIZAR_CAND_VAGA: {
                
            try {
                candVaga.update(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), int.class),
                        gson.fromJson(pacote.getDados().get(2), long.class),
                        gson.fromJson(pacote.getDados().get(3),(java.lang.reflect.Type) Date.class),
                        gson.fromJson(pacote.getDados().get(4), CandidatoVaga.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case GET_CAND_VAGA: {
                
                List<CandidatoVaga> candidatoVaga;
                candidatoVaga = candVaga.getCandidatosVaga(gson.fromJson(pacote.getDados().get(0), int.class),
                            gson.fromJson(pacote.getDados().get(1), long.class),
                            gson.fromJson(pacote.getDados().get(2),(java.lang.reflect.Type) Date.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(candidatoVaga));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case GET_CAND_VAGA_COD: {
                
                CandidatoVaga candidatoVagaDialogo;
                candidatoVagaDialogo = candVaga.getCandidatoVagaCod(gson.fromJson(pacote.getDados().get(0), long.class),
                            gson.fromJson(pacote.getDados().get(1), int.class),
                            gson.fromJson(pacote.getDados().get(2), long.class),
                            gson.fromJson(pacote.getDados().get(3),(java.lang.reflect.Type) Date.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(candidatoVagaDialogo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case GET_CARGO_AREA_ESTUDO: {
                
                Set<CargoAreaEstudo> candidatoVagaDialogo = new HashSet();
            try {
                candidatoVagaDialogo = cargoAreaEstudo.CargoAreaEstudo(gson.fromJson(pacote.getDados().get(0), List.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(candidatoVagaDialogo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case INSERT_CARGO_INTERESSE: {
                
            try {
                cargoInteresse.insert(gson.fromJson(pacote.getDados().get(0), CargoInteresse.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case DELETE_CARGO_INTERESSE: {
                
                cargoInteresse.delete(gson.fromJson(pacote.getDados().get(0), long.class),
                                        gson.fromJson(pacote.getDados().get(1), int.class));



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case LISTA_CARGO_INTERESSE: {
                
                List<CargoInteresse> cargoInt;
                cargoInt = cargoInteresse.getCargosInteresse(gson.fromJson(pacote.getDados().get(0), long.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(cargoInt));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_CARGO_INTERESSE_COD: {
                
                CargoInteresse cargoInt;
                cargoInt = cargoInteresse.getCargoInteresseCod(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(cargoInt));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case LISTA_CARGO: {
                
                List<Cargo> lstCargo;
                lstCargo = cargo.listAll();
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstCargo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_CARGO_AREA: {
                
                List<Cargo> lstCargo;
                lstCargo = cargo.getCargos(gson.fromJson(pacote.getDados().get(0), HashSet.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstCargo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_CARGO_COD: {
                
                Cargo lstCargo;
                lstCargo = cargo.getCargoCod(gson.fromJson(pacote.getDados().get(0), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstCargo));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case LISTA_CIDADE_POR_ESTADO: {
                
                List<Cidade> lstCid;
                lstCid = cidade.getCidades(gson.fromJson(pacote.getDados().get(0), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstCid));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_CIDADE_COD: {
                
                Cidade lstCid;
                lstCid = cidade.getCidadeCod(gson.fromJson(pacote.getDados().get(0), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstCid));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_COMPETENCIA: {
                
                List<Competencia> lstComp;
                lstComp = competencia.listAll();
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstComp));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_COMPETENCIA_COD: {
                Competencia lstComp;
                lstComp = competencia.getCompetenciaCod(gson.fromJson(pacote.getDados().get(0), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstComp));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case INSERT_COMPETENCIA_PESSOA_FISICA: {
                
            try {
                competenciaPessoaFisica.insert(gson.fromJson(pacote.getDados().get(0), CompetenciaPessoaFisica.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                break;
            }
            case DELETE_COMPETENCIA_PESSOA_FISICA: {
                
                competenciaPessoaFisica.delete(gson.fromJson(pacote.getDados().get(0), long.class),
                                        gson.fromJson(pacote.getDados().get(1), int.class));



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                break;
            }
            case LISTA_COMPETENCIA_PESSOA_FISICA_CPF: {
                
                List<CompetenciaPessoaFisica> lstCompPF;
                lstCompPF = competenciaPessoaFisica.getCompetenciasPessoaFisica(gson.fromJson(pacote.getDados().get(0), long.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstCompPF));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_COMPETENCIA_PESSSOA_FIS_COD: {
                
                CompetenciaPessoaFisica lstCompPF;
                lstCompPF = competenciaPessoaFisica.getCompetenciaPessoaFisicaCod(gson.fromJson(pacote.getDados().get(0), long.class),
                       gson.fromJson(pacote.getDados().get(1), int.class) );
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstCompPF));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case INSERT_EMPRESA: {
                
            try {
                empresa.insert(gson.fromJson(pacote.getDados().get(0), Empresa.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case ATUALIZA_EMPRESA: {
                
            try {
                empresa.update(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), Empresa.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_EMPRESA_COD: {
                
                
                Empresa lstCompPF;
                lstCompPF = empresa.getEmpresaCod(gson.fromJson(pacote.getDados().get(0), long.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstCompPF));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_ESTADO: {
                
                List<Estado> lstEst;
                lstEst = estado.listAll();
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstEst));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_ESTADO_COD: {
                
                Estado lstEst;
                lstEst = estado.getEstadoCod(gson.fromJson(pacote.getDados().get(0), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstEst));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case INSERT_EXP_PROFSS: {
                
            try {
                experienciaProfissional.insert(gson.fromJson(pacote.getDados().get(0), ExperienciaProfissional.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case ATUALIZA_EXP_PROFSS: {
                
            try {
                experienciaProfissional.update(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), int.class),
                        gson.fromJson(pacote.getDados().get(2), int.class),
                        gson.fromJson(pacote.getDados().get(3), ExperienciaProfissional.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case DELETE_EXP_PROFSS: {
                
                experienciaProfissional.delete(gson.fromJson(pacote.getDados().get(0), long.class),
                                        gson.fromJson(pacote.getDados().get(1), int.class),
                                        gson.fromJson(pacote.getDados().get(2), int.class));



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case LISTA_EXP_PROFSS_CPF: {
                
                List<ExperienciaProfissional> lstExpPro;
                lstExpPro = experienciaProfissional.getExperienciasProfissionais(gson.fromJson(pacote.getDados().get(0), long.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstExpPro));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_EXP_PROFSS_COD: {
                
                
                ExperienciaProfissional lstExpPro;
                lstExpPro = experienciaProfissional.getExperienciaProfissionalCod(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), int.class),
                        gson.fromJson(pacote.getDados().get(2), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstExpPro));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case INSERT_FORM_ACAD: {
                
            try {
                formacaoAcademica.insert(gson.fromJson(pacote.getDados().get(0), FormacaoAcademica.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case ATUALIZA_FORM_ACAD: {
                
            try {
                formacaoAcademica.update(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), int.class),
                        gson.fromJson(pacote.getDados().get(2), int.class),
                        gson.fromJson(pacote.getDados().get(3), FormacaoAcademica.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case DELETE_FORM_ACAD: {
                
                formacaoAcademica.delete(gson.fromJson(pacote.getDados().get(0), long.class),
                                        gson.fromJson(pacote.getDados().get(1), int.class),
                                        gson.fromJson(pacote.getDados().get(2), int.class));



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_FORM_ACAD_CPF: {
                
                List<FormacaoAcademica> lstFormAcad;
                lstFormAcad = formacaoAcademica.getFormacaoAcademica(gson.fromJson(pacote.getDados().get(0), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstFormAcad));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_FORM_ACAD_COD: {
                
                FormacaoAcademica lstFormAcad;
                lstFormAcad = formacaoAcademica.getFormacaoAcademicaCod(gson.fromJson(pacote.getDados().get(0), long.class),
                                        gson.fromJson(pacote.getDados().get(1), int.class),
                                        gson.fromJson(pacote.getDados().get(2), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstFormAcad));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case INSERT_PESSOA_FISICA: {
                
            try {
                pessoaFisica.insert(gson.fromJson(pacote.getDados().get(0), PessoaFisica.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case ATUALIZA_PESSOA_FISICA: {
                
            try {
                pessoaFisica.update(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), PessoaFisica.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case GET_PESSOA_FISICA_CPF: {
                
                
                PessoaFisica lstFormAcad;
                lstFormAcad = pessoaFisica.getPessoaFisicaCod(gson.fromJson(pacote.getDados().get(0), long.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstFormAcad));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case LISTA_PROFICI: {
                
                List<Proficiencia> lstPro;
                lstPro = proficiencia.listAll();
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstPro));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case GET_PROFICI_BY_COD: {
                
                
                Proficiencia lstPro;
                lstPro = proficiencia.getProficienciaCod(gson.fromJson(pacote.getDados().get(0), int.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstPro));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case INSERT_TEL: {
                
            try {
                telefone.insert(gson.fromJson(pacote.getDados().get(0), Telefone.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case ATUALIZA_TEL: {
                
            try {
                telefone.update(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), String.class),
                        gson.fromJson(pacote.getDados().get(2), Telefone.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case DELETE_TEL: {
                
                telefone.delete(gson.fromJson(pacote.getDados().get(0), long.class),
                                        gson.fromJson(pacote.getDados().get(1), String.class));



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_TEL_CPFNPJ: {
                
                List<Telefone> lstTel;
                lstTel = telefone.getTelefones(gson.fromJson(pacote.getDados().get(0), long.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstTel));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_TEL_COD: {
                
                
                Telefone lstTel;
                lstTel = telefone.getTelefoneCod(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), String.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstTel));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case INSERT_USUARIO: {
                
            try {
                usuario.insert(gson.fromJson(pacote.getDados().get(0), Usuario.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case ATUALIZA_USUARIO: {
                
            try {
                usuario.update(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), Usuario.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_USUARIO_CPFNPJ: {
                
                
                Usuario lstTel;
                lstTel = usuario.getUsuarioCod(gson.fromJson(pacote.getDados().get(0), long.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstTel));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case LOGIN_USUARIO: {
                
                
                Usuario lstTel;
                lstTel = usuario.getLogin(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), String.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstTel));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case INSERT_VAGA: {
                
                
            try {
                vaga.insert(gson.fromJson(pacote.getDados().get(0), Vaga.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
            case ATUALIZA_VAGA: {
                
            try {
                vaga.update(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), int.class),
                        gson.fromJson(pacote.getDados().get(2),(java.lang.reflect.Type) Date.class),
                        gson.fromJson(pacote.getDados().get(3), Vaga.class));
            } catch (BusinessException ex) {
                Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
            }



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case DELETE_VAGA: {
                
                
                vaga.delete(gson.fromJson(pacote.getDados().get(0), long.class),
                                        gson.fromJson(pacote.getDados().get(1), int.class),
                                        gson.fromJson(pacote.getDados().get(2),(java.lang.reflect.Type) Date.class));



                pctResposta = new Pacote(TipOperacao.RESPOSTA, new ArrayList<>());

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_VAGA_CNPJ: {
                
                List<Vaga> lstVag;
                lstVag = vaga.getVagaCNPJ(gson.fromJson(pacote.getDados().get(0), long.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstVag));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_VAGA_POR_COD: {
                
                List<Vaga> lstVag;
                lstVag = vaga.getVagaCod_Cargo(gson.fromJson(pacote.getDados().get(0), List.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstVag));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case LISTA_VAGA_INFO: {
                
                
                Vaga lstVag;
                lstVag = vaga.getVagaCod(gson.fromJson(pacote.getDados().get(0), long.class),
                        gson.fromJson(pacote.getDados().get(1), int.class),
                gson.fromJson(pacote.getDados().get(2),(java.lang.reflect.Type) Date.class));
                
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(lstVag));

                pctResposta = new Pacote(TipOperacao.RESPOSTA, dados);

                try {
                    enviaPacoteResposta(pctResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterCore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            }
        }
        
    }
    
}