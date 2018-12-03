/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.dao.EstadoDao;
import br.cefetmg.implicare.model.daoImpl.EstadoDaoImpl;
import br.cefetmg.implicare.model.domain.Estado;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EstadoManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class EstadoManagementImpl extends UnicastRemoteObject implements EstadoManagement {
    private final EstadoDao EstadoDao;
    
    public EstadoManagementImpl() throws RemoteException {
        EstadoDao = new EstadoDaoImpl();
    }
    
    @Override
    public List<Estado> listAll() throws PersistenceException, RemoteException {
        List<Estado> result = EstadoDao.listAll();
        return result;
    }

    @Override
    public Estado getEstadoCod(int Cod_Estado) throws PersistenceException, RemoteException {
        Estado result = EstadoDao.getEstadoCod(Cod_Estado);
        return result;
    }
    
}
