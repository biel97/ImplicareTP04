/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
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

public class CandidatoVagaSocketProxy implements CandidatoVagaManagement {
    
    Cliente Cliente;
    
    public CandidatoVagaSocketProxy() {
        try {
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(CandidatoVagaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(CandidatoVagaSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CandidatoVaga));
        pacoteEnviado = new Pacote(TipOperacao.INSERT_CAND_VAGA, dados);

        Cliente.requisicao(pacoteEnviado);
    }

    @Override
    public boolean update(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao, CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;
        
        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Cod_Cargo));
        dados.add(gson.toJson(Dat_Publicacao));
        dados.add(gson.toJson(CandidatoVaga));
        pacoteEnviado = new Pacote(TipOperacao.ATUALIZAR_CAND_VAGA, dados);

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
    public List<CandidatoVaga> getCandidatosVaga(int Cod_Cargo, long CNPJ, Date Dat_Publicacao) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(Cod_Cargo));
        dados.add(gson.toJson(CNPJ));
        dados.add(gson.toJson(Dat_Publicacao));
        pacoteEnviado = new Pacote(TipOperacao.GET_CAND_VAGA, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        
        List<CandidatoVaga> CandVaga = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<List<CandidatoVaga>>() {
                }.getType());
        
        return CandVaga;
    }

    @Override
    public CandidatoVaga getCandidatoVagaCod(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(CPF));
        dados.add(gson.toJson(Cod_Cargo));
        dados.add(gson.toJson(CNPJ));
        dados.add(gson.toJson(Dat_Publicacao));
        pacoteEnviado = new Pacote(TipOperacao.GET_CAND_VAGA_COD, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        CandidatoVaga CandVaga = gson.fromJson(pacoteRecebido.getDados().get(0), CandidatoVaga.class);
        return CandVaga;
    }
  
}
