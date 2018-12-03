/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.inf.implicare.util.*;
import com.google.gson.Gson;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */

public class EmpresaSocketProxy implements EmpresaManagement {
    
    Cliente Cliente;
    
    public EmpresaSocketProxy() {
        try {
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(EmpresaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(EmpresaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Empresa Empresa) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(Empresa));
        pacoteEnviado = new Pacote(TipOperacao.INSERT_EMPRESA, dados);

        Cliente.requisicao(pacoteEnviado);
    }

    @Override
    public boolean update(Long CNPJ, Empresa Empresa) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CNPJ));
        dados.add(gson.toJson(Empresa));
        pacoteEnviado = new Pacote(TipOperacao.ATUALIZA_EMPRESA, dados);

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
    public Empresa getEmpresaCod(Long CNPJ) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(CNPJ));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_EMPRESA_COD, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        Empresa Empr = gson.fromJson(pacoteRecebido.getDados().get(0), Empresa.class);
        return Empr;
    }
    
}
