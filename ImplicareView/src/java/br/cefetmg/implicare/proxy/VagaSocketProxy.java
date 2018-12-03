/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.inf.implicare.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */

public class VagaSocketProxy implements  VagaManagement {
    
    Cliente Cliente;
    
    public VagaSocketProxy() {
        try {
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(VagaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(VagaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Vaga Vaga) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(Vaga));
        pacoteEnviado = new Pacote(TipOperacao.INSERT_VAGA, dados);

        Cliente.requisicao(pacoteEnviado);
    }

    @Override
    public boolean update(long CNPJ, int Cod_Cargo, Date Dat_Publicacao, Vaga Vaga) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CNPJ));
        dados.add(gson.toJson(Cod_Cargo));
        dados.add(gson.toJson(Dat_Publicacao));
        dados.add(gson.toJson(Vaga));
        pacoteEnviado = new Pacote(TipOperacao.ATUALIZA_VAGA, dados);

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
    public boolean delete(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CNPJ));
        dados.add(gson.toJson(Cod_Cargo));
        dados.add(gson.toJson(Dat_Publicacao));
        pacoteEnviado = new Pacote(TipOperacao.DELETE_VAGA, dados);

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
    public List<Vaga> getVagaCNPJ(long CNPJ) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CNPJ));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_VAGA_CNPJ, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
        List<Vaga> Vag = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<List<Vaga>>() {
                }.getType());
        
        return Vag;   
    }

    @Override
    public List<Vaga> getVagaCod_Cargo(List<CargoInteresse> CarInteresse) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CarInteresse));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_VAGA_POR_COD, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
        List<Vaga> Vag = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<List<Vaga>>() {
                }.getType());
        
        return Vag;  
    }

    @Override
    public Vaga getVagaCod(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(CNPJ));
        dados.add(gson.toJson(Cod_Cargo));
        dados.add(gson.toJson(Dat_Publicacao));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_VAGA_INFO, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        Vaga Vag = gson.fromJson(pacoteRecebido.getDados().get(0), Vaga.class);
        return Vag;
    }
    
}
