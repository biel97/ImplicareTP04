/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.dao.CompetenciaPessoaFisicaDao;
import br.cefetmg.implicare.model.daoImpl.CompetenciaPessoaFisicaDaoImpl;
import br.cefetmg.implicare.model.domain.CompetenciaPessoaFisica;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CompetenciaPessoaFisicaManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class CompetenciaPessoaFisicaManagementImpl extends UnicastRemoteObject implements CompetenciaPessoaFisicaManagement {
    private final CompetenciaPessoaFisicaDao CompetenciaPessoaFisicaDao;
    
    public CompetenciaPessoaFisicaManagementImpl() throws RemoteException {
        CompetenciaPessoaFisicaDao = new CompetenciaPessoaFisicaDaoImpl();
    }

    @Override
    public void insert(CompetenciaPessoaFisica CompetenciaPessoaFisica) throws BusinessException, PersistenceException, RemoteException {
        CompetenciaPessoaFisicaDao.insert(CompetenciaPessoaFisica);
    }

    @Override
    public boolean delete(long CPF, int Cod_Competencia) throws PersistenceException, RemoteException {
        boolean result = CompetenciaPessoaFisicaDao.delete(CPF, Cod_Competencia);
        return result;
    }

    @Override
    public List<CompetenciaPessoaFisica> getCompetenciasPessoaFisica(long CPF) throws PersistenceException, RemoteException {
        List<CompetenciaPessoaFisica> result = CompetenciaPessoaFisicaDao.getCompetenciasPessoaFisica(CPF);
        return result;
    }

    @Override
    public CompetenciaPessoaFisica getCompetenciaPessoaFisicaCod(long CPF, int Cod_Competencia) throws PersistenceException, RemoteException {
        CompetenciaPessoaFisica result = CompetenciaPessoaFisicaDao.getCompetenciaPessoaFisicaCod(CPF, Cod_Competencia);
        return result;
    }
    
}
