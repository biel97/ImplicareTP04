/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.RemoteException;

/**
 *
 * @author Andre Matheus
 */
public interface UsuarioManagement {
    public void insert(Usuario Usuario) throws BusinessException, PersistenceException, RemoteException;
    public boolean update(Long CPF_CNPJ, Usuario Usuario) throws BusinessException, PersistenceException, RemoteException;
    public Usuario getUsuarioCod(Long CPF_CNPJ) throws PersistenceException, RemoteException;
    public Usuario getLogin(Long CPF_CNPJ, String Senha) throws PersistenceException, RemoteException;
}
