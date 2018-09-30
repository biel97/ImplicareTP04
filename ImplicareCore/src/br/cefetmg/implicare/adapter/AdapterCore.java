package br.cefetmg.implicare.adapter;


import br.cefetmg.implicare.model.dao.*;
import br.cefetmg.implicare.model.serviceImpl.*;
import br.cefetmg.implicare.model.daoImpl.*;
import br.cefetmg.implicare.model.domain.*;
import br.cefetmg.implicare.model.service.*;
import br.cefetmg.implicare.model.exception.*;
import br.cefetmg.inf.implicare.util.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
        analisaTipoOperacao();
    }
    
    public void enviaPacoteResposta(Pacote pctResposta) throws IOException {
        //Servidor.enviaDados(enderecoIP, portaCliente, pacoteResposta);
    }
    
    public void analisaTipoOperacao(){
        TipOperacao tipOperacao = pacote.getTipoOperacao();
        Pacote pctResposta;
        
        
        AreaEstudoManagement areaEstudo = new AreaEstudoManagementImpl();
        
        CandidatoVagaDialogoManagement candVagaDialog = new CandidatoVagaDialogoManagementImpl();
        CandidatoVagaManagement candVaga = new CandidatoVagaManagementImpl();
        CargoAreaEstudoManagement cargoAreaEstudo = new CargoAreaEstudoMangementImpl();
        CargoInteresseManagement cargoInteresse = new CargoInteresseManagementImpl();
        CargoManagement cargo = new CargoManagementImpl();
        CepManagement cep = new CepManagementImpl();
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
                break;
            }
            case PESQ_AREA_ESTUDO_COD: {
                break;
            }
            case INSERT_CAND_VAGA_DIALOG: {
                break;
            }
            case LISTA_CAND_VAGA_DIALOG: {
                break;
            }
            case GET_CAND_VAGA_DIALOG_WITHTIMESTAMP: {
                break;
            }
            case INSERT_CAND_VAGA: {
                break;
            }
            case ATUALIZAR_CAND_VAGA: {
                break;
            }
            case GET_CAND_VAGA: {
                break;
            }
            case GET_CAND_VAGA_COD: {
                break;
            }
            case GET_CARGO_AREA_ESTUDO: {
                break;
            }
            case INSERT_CARGO_INTERESSE: {
                break;
            }
            case DELETE_CARGO_INTERESSE: {
                break;
            }
            case LISTA_CARGO_INTERESSE: {
                break;
            }
            case LISTA_CARGO_INTERESSE_COD: {
                break;
            }
            case LISTA_CARGO: {
                break;
            }
            case LISTA_CARGO_AREA: {
                break;
            }
            case LISTA_CARGO_COD: {
                break;
            }
            case LISTA_CIDADE_POR_ESTADO: {
                break;
            }
            case LISTA_CIDADE_COD: {
                break;
            }
            case LISTA_COMPETENCIA: {
                break;
            }
            case LISTA_COMPETENCIA_COD: {
                break;
            }
            case INSERT_COMPETENCIA_PESSOA_FISICA: {
                break;
            }
            case DELETE_COMPETENCIA_PESSOA_FISICA: {
                break;
            }
            case LISTA_COMPETENCIA_PESSOA_FISICA_CPF: {
                break;
            }
            case LISTA_COMPETENCIA_PESSSOA_FIS_COD: {
                break;
            }
            case INSERT_EMPRESA: {
                break;
            }
            case ATUALIZA_EMPRESA: {
                break;
            }
            case LISTA_EMPRESA_COD: {
                break;
            }
            case LISTA_ESTADO: {
                break;
            }
            case LISTA_ESTADO_COD: {
                break;
            }
            case INSERT_EXP_PROFSS: {
                break;
            }
            case ATUALIZA_EXP_PROFSS: {
                break;
            }
            case DELETE_EXP_PROFSS: {
                break;
            }
            case LISTA_EXP_PROFSS_CPF: {
                break;
            }
            case LISTA_EXP_PROFSS_COD: {
                break;
            }
            case INSERT_FORM_ACAD: {
                break;
            }
            case ATUALIZA_FORM_ACAD: {
                break;
            }
            case DELETE_FORM_ACAD: {
                break;
            }
            case LISTA_FORM_ACAD_CPF: {
                break;
            }
            case LISTA_FORM_ACAD_COD: {
                break;
            }
            case INSERT_PESSOA_FISICA: {
                break;
            }
            case ATUALIZA_PESSOA_FISICA: {
                break;
            }
            case GET_PESSOA_FISICA_CPF: {
                break;
            }
            case LISTA_PROFICI: {
                break;
            }
            case GET_PROFICI_BY_COD: {
                break;
            }
            case INSERT_TEL: {
                break;
            }
            case ATUALIZA_TEL: {
                break;
            }
            case DELETE_TEL: {
                break;
            }
            case LISTA_TEL_CPFNPJ: {
                break;
            }
            case LISTA_TEL_COD: {
                break;
            }
            case INSERT_USUARIO: {
                break;
            }
            case ATUALIZA_USUARIO: {
                break;
            }
            case LISTA_USUARIO_CPFNPJ: {
                break;
            }
            case LOGIN_USUARIO: {
                break;
            }
            case INSERT_VAGA: {
                break;
            }
            case ATUALIZA_VAGA: {
                break;
            }
            case DELETE_VAGA: {
                break;
            }
            case LISTA_VAGA_CNPJ: {
                break;
            }
            case LISTA_VAGA_POR_COD: {
                break;
            }
            case LISTA_VAGA_INFO: {
                break;
            }
        }
        
    }
    
}
