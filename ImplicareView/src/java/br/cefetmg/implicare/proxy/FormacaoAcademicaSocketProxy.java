/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import br.cefetmg.inf.implicare.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.RemoteException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */

public class FormacaoAcademicaSocketProxy implements FormacaoAcademicaManagement {
    
    Cliente Cliente;
    
    public FormacaoAcademicaSocketProxy() {
        try {
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(FormacaoAcademicaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(FormacaoAcademicaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(FormacaoAcademica));
        pacoteEnviado = new Pacote(TipOperacao.INSERT_FORM_ACAD, dados);

        Cliente.requisicao(pacoteEnviado);
    }

    @Override
    public boolean update(long CPF, int Seq_Formacao, int Cod_Area_Estudo, FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;
        
        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Seq_Formacao));
        dados.add(gson.toJson(Cod_Area_Estudo));
        dados.add(gson.toJson(FormacaoAcademica));
        pacoteEnviado = new Pacote(TipOperacao.ATUALIZA_FORM_ACAD, dados);

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
    public boolean delete(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;
        
        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Seq_Formacao));
        dados.add(gson.toJson(Cod_Area_Estudo));
        pacoteEnviado = new Pacote(TipOperacao.DELETE_FORM_ACAD, dados);

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
    public List<FormacaoAcademica> getFormacaoAcademica(long CPF) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_FORM_ACAD_CPF, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
        List<FormacaoAcademica> FormAcad = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<List<FormacaoAcademica>>() {
                }.getType());
        
        return FormAcad;
    }

    @Override
    public FormacaoAcademica getFormacaoAcademicaCod(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Seq_Formacao));
        dados.add(gson.toJson(Cod_Area_Estudo));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_FORM_ACAD_COD, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        FormacaoAcademica FormAcad = gson.fromJson(pacoteRecebido.getDados().get(0), FormacaoAcademica.class);
        return FormAcad;
    }
    
}
