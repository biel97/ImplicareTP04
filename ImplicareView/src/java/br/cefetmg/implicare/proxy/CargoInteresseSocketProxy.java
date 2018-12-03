/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoInteresseManagement;
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

public class CargoInteresseSocketProxy implements CargoInteresseManagement {
    
    Cliente Cliente;
    
    public CargoInteresseSocketProxy() {
        try {        
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(CargoInteresseSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(CargoInteresseSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(CargoInteresse CargoInteresse) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CargoInteresse));
        pacoteEnviado = new Pacote(TipOperacao.INSERT_CARGO_INTERESSE, dados);

        Cliente.requisicao(pacoteEnviado);
    }

    @Override
    public boolean delete(long CPF, int Cod_Cargo) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Cod_Cargo));
        pacoteEnviado = new Pacote(TipOperacao.DELETE_CARGO_INTERESSE, dados);

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
    public List<CargoInteresse> getCargosInteresse(long CPF) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_CARGO_INTERESSE, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
        List<CargoInteresse> CarInteresse = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<List<CargoInteresse>>() {
                }.getType());
        
        return CarInteresse;
    }

    @Override
    public CargoInteresse getCargoInteresseCod(long CPF, int Cod_Cargo) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Cod_Cargo));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_CARGO_INTERESSE_COD, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        CargoInteresse CarInteresse = gson.fromJson(pacoteRecebido.getDados().get(0), CargoInteresse.class);
        return CarInteresse;
    }
    
}
