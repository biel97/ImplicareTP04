/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.dao.AreaEstudoDao;
import br.cefetmg.implicare.model.daoImpl.AreaEstudoDaoImpl;
import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class AreaEstudoManagementImpl implements AreaEstudoManagement {
    private final AreaEstudoDao AreaEstudoDao;
    
    public AreaEstudoManagementImpl(){
        AreaEstudoDao = new AreaEstudoDaoImpl();
    }
    
    @Override
    public ArrayList<AreaEstudo> listAll() throws PersistenceException, RemoteException {
        
        ArrayList<AreaEstudo> result = AreaEstudoDao.listAll();
        return result;
    }

    @Override
    public AreaEstudo getAreaEstudoCod(int Cod_Area_Estudo) throws PersistenceException, RemoteException {
        AreaEstudo result = AreaEstudoDao.getAreaEstudoCod(Cod_Area_Estudo);
        return result;
    }
    
}
