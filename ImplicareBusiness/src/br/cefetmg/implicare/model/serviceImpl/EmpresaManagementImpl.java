/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.dao.EmpresaDao;
import br.cefetmg.implicare.model.daoImpl.EmpresaDaoImpl;
import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import java.rmi.RemoteException;

/**
 *
 * @author Gabriel
 */
public class EmpresaManagementImpl implements EmpresaManagement {
    private final EmpresaDao EmpresaDao;
    
    public EmpresaManagementImpl(){
        EmpresaDao = new EmpresaDaoImpl(); 
    }
    
    @Override
    public void insert(Empresa Empresa) throws BusinessException, PersistenceException, RemoteException {
        EmpresaDao.insert(Empresa);
    }

    @Override
    public boolean update(Long CNPJ, Empresa Empresa) throws BusinessException, PersistenceException, RemoteException {
        boolean result = EmpresaDao.update(CNPJ, Empresa);
        return result;
    }

    @Override
    public Empresa getEmpresaCod(Long CNPJ) throws PersistenceException, RemoteException {
        Empresa result = EmpresaDao.getEmpresaCod(CNPJ);
        return result;
    }
    
}
