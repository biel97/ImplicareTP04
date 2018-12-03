/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.dao.FormacaoAcademicaDao;
import br.cefetmg.implicare.model.daoImpl.FormacaoAcademicaDaoImpl;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class FormacaoAcademicaManagementImpl extends UnicastRemoteObject implements FormacaoAcademicaManagement {
    private final FormacaoAcademicaDao FormacaoAcademicaDao;
    
    public FormacaoAcademicaManagementImpl() throws RemoteException {
        FormacaoAcademicaDao = new FormacaoAcademicaDaoImpl();
    }

    @Override
    public void insert(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        FormacaoAcademicaDao.insert(FormacaoAcademica);
    }

    @Override
    public boolean update(long CPF, int Seq_Formacao, int Cod_Area_Estudo, FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        boolean result = FormacaoAcademicaDao.update(CPF, Seq_Formacao, Cod_Area_Estudo, FormacaoAcademica);
        return result;
    }

    @Override
    public boolean delete(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException, RemoteException {
        boolean result = FormacaoAcademicaDao.delete(CPF, Seq_Formacao, Cod_Area_Estudo);
        return result;
    }

    @Override
    public List<FormacaoAcademica> getFormacaoAcademica(long CPF) throws PersistenceException, RemoteException {
        List<FormacaoAcademica> result = FormacaoAcademicaDao.getFormacaoAcademica(CPF);
        return result;
    }

    @Override
    public FormacaoAcademica getFormacaoAcademicaCod(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException, RemoteException {
        FormacaoAcademica result = FormacaoAcademicaDao.getFormacaoAcademicaCod(CPF, Seq_Formacao, Cod_Area_Estudo);
        return result;
    }
    
}
