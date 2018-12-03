/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
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

public class AreaEstudoSocketProxy implements AreaEstudoManagement {
    
    Cliente Cliente;
    
    public AreaEstudoSocketProxy(){
        try {
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(AreaEstudoSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(AreaEstudoSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<AreaEstudo> listAll() throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipOperacao.LISTA_AREA_ESTUDO, null);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
        ArrayList<AreaEstudo> AreaEst = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<List<AreaEstudo>>() {
                }.getType());
        
        return AreaEst;
    }

    @Override
    public AreaEstudo getAreaEstudoCod(int Cod_Area_Estudo) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(Cod_Area_Estudo));
        pacoteEnviado = new Pacote(TipOperacao.PESQ_AREA_ESTUDO_COD, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        AreaEstudo AreaEst = gson.fromJson(pacoteRecebido.getDados().get(0), AreaEstudo.class);
        return AreaEst;
    }
    
}
