/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.dao.UsuarioDao;
import br.cefetmg.implicare.model.daoImpl.UsuarioDaoImpl;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import java.rmi.RemoteException;

/**
 *
 * @author Gabriel
 */
public class UsuarioManagementImpl implements UsuarioManagement {
    private final UsuarioDao UsuarioDao;
    
    public UsuarioManagementImpl(){
        UsuarioDao = new UsuarioDaoImpl();
    }
    
    @Override
    public void insert(Usuario Usuario) throws BusinessException, PersistenceException, RemoteException {
        UsuarioDao.insert(Usuario);
    }

    @Override
    public boolean update(Long CPF_CNPJ, Usuario Usuario) throws BusinessException, PersistenceException, RemoteException {
        boolean result = UsuarioDao.update(CPF_CNPJ, Usuario);
        return result;
    }

    @Override
    public Usuario getUsuarioCod(Long CPF_CNPJ) throws PersistenceException, RemoteException {
        Usuario result = UsuarioDao.getUsuarioCod(CPF_CNPJ);
        return result;
    }
    
    @Override
    public Usuario getLogin(Long CPF_CNPJ, String Senha) throws PersistenceException, RemoteException{
        Usuario result = UsuarioDao.getLogin(CPF_CNPJ, Senha);
        return result;
    }
}
