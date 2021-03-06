/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.dao.TelefoneDao;
import br.cefetmg.implicare.model.daoImpl.TelefoneDaoImpl;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class TelefoneManagementImpl extends UnicastRemoteObject implements TelefoneManagement {
    private final TelefoneDao TelefoneDao;
    
    public TelefoneManagementImpl() throws RemoteException {
        TelefoneDao = new TelefoneDaoImpl();
    }
    
    @Override
    public void insert(Telefone Telefone) throws BusinessException, PersistenceException, RemoteException {
        TelefoneDao.insert(Telefone);
    }

    @Override
    public boolean update(long CPF_CNPJ, String Num_Telefone, Telefone Telefone) throws BusinessException, PersistenceException, RemoteException {
        boolean result = TelefoneDao.update(CPF_CNPJ, Num_Telefone, Telefone);
        return result;
    }

    @Override
    public boolean delete(long CPF_CNPJ, String Num_Telefone) throws PersistenceException, RemoteException {
        boolean result = TelefoneDao.delete(CPF_CNPJ, Num_Telefone);
        return result;
    }

    @Override
    public List<Telefone> getTelefones(long CPF_CNPJ) throws PersistenceException, RemoteException {
        List<Telefone> result = TelefoneDao.getTelefones(CPF_CNPJ);
        return result;
    }

    @Override
    public Telefone getTelefoneCod(long CPF_CNPJ, String Num_Telefone) throws PersistenceException, RemoteException {
        Telefone result = TelefoneDao.getTelefoneCod(CPF_CNPJ, Num_Telefone);
        return result;
    }
    
}
