/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.Proficiencia;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.ProficienciaManagement;
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

public class ProficienciaSocketProxy implements ProficienciaManagement {
    
    Cliente Cliente;
    
    public ProficienciaSocketProxy() {
        try {
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(ProficienciaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ProficienciaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Proficiencia> listAll() throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        pacoteEnviado = new Pacote(TipOperacao.LISTA_PROFICI, null);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
        List<Proficiencia> Prof = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<List<Proficiencia>>() {
                }.getType());
        
        return Prof;
    }

    @Override
    public Proficiencia getProficienciaCod(int Cod_Proficiencia) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(Cod_Proficiencia));
        pacoteEnviado = new Pacote(TipOperacao.GET_PROFICI_BY_COD, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        Proficiencia Prof = gson.fromJson(pacoteRecebido.getDados().get(0), Proficiencia.class);
        return Prof;
    }
    
}
