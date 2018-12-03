/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.inf.implicare.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */

public class ExperienciaProfissionalSocketProxy implements ExperienciaProfissionalManagement {
    
    Cliente Cliente;
    
    public ExperienciaProfissionalSocketProxy() {
        try {
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(ExperienciaProfissionalSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ExperienciaProfissionalSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(ExperienciaProfissional));
        pacoteEnviado = new Pacote(TipOperacao.INSERT_EXP_PROFSS, dados);

        Cliente.requisicao(pacoteEnviado);
    }

    @Override
    public boolean update(long CPF, int Seq_Experiencia, int Cod_Cargo, ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;
        
        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Seq_Experiencia));
        dados.add(gson.toJson(Cod_Cargo));
        dados.add(gson.toJson(ExperienciaProfissional));
        pacoteEnviado = new Pacote(TipOperacao.ATUALIZA_EXP_PROFSS, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
         if(pacoteRecebido != null){
            pacote = true;
        }
        else{
            pacote = false;
        }
        
        return pacote;
    }

    @Override
    public boolean delete(long CPF, int Seq_Experiencia, int Cod_Cargo) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;
        
        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Seq_Experiencia));
        dados.add(gson.toJson(Cod_Cargo));
        pacoteEnviado = new Pacote(TipOperacao.DELETE_EXP_PROFSS, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
         if(pacoteRecebido != null){
            pacote = true;
        }
        else{
            pacote = false;
        }
        
        return pacote;
    }

    @Override
    public List<ExperienciaProfissional> getExperienciasProfissionais(long CPF) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_EXP_PROFSS_CPF, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
        List<ExperienciaProfissional> ExpProfissional = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<List<ExperienciaProfissional>>() {
                }.getType());
        
        return ExpProfissional;
    }

    @Override
    public ExperienciaProfissional getExperienciaProfissionalCod(long CPF, int Seq_Experiencia, int Cod_Cargo) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Seq_Experiencia));
        dados.add(gson.toJson(Cod_Cargo));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_EXP_PROFSS_COD, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        ExperienciaProfissional ExpProfissional = gson.fromJson(pacoteRecebido.getDados().get(0), ExperienciaProfissional.class);
        return ExpProfissional;
    }

}
