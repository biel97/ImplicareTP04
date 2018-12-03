/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.UsuarioManagement;
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

public class UsuarioSocketProxy implements UsuarioManagement{
    
    Cliente Cliente;
    
    public UsuarioSocketProxy() {
        try {
            this.Cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(UsuarioSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Usuario Usuario) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(Usuario));
        pacoteEnviado = new Pacote(TipOperacao.INSERT_USUARIO, dados);

        Cliente.requisicao(pacoteEnviado);
    }

    @Override
    public boolean update(Long CPF_CNPJ, Usuario Usuario) throws BusinessException, PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        boolean pacote;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(CPF_CNPJ));
        dados.add(gson.toJson(Usuario));
        pacoteEnviado = new Pacote(TipOperacao.ATUALIZA_USUARIO, dados);

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
    public Usuario getUsuarioCod(Long CPF_CNPJ) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(CPF_CNPJ));
        pacoteEnviado = new Pacote(TipOperacao.LISTA_USUARIO_CPFNPJ, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        Usuario Usu = gson.fromJson(pacoteRecebido.getDados().get(0), Usuario.class);
        return Usu;
    }

    @Override
    public Usuario getLogin(Long CPF_CNPJ, String Senha) throws PersistenceException, RemoteException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(CPF_CNPJ));
        dados.add(gson.toJson(Senha));
        pacoteEnviado = new Pacote(TipOperacao.LOGIN_USUARIO, dados);

        pacoteRecebido = Cliente.requisicao(pacoteEnviado);
        Usuario Usu = gson.fromJson(pacoteRecebido.getDados().get(0), Usuario.class);
        return Usu;
    }
    
}
