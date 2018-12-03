/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CompetenciaPessoaFisica;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Andre Matheus
 * @author Gabriel
 * 
 */
public interface CompetenciaPessoaFisicaManagement extends Remote {
    public void insert(CompetenciaPessoaFisica CompetenciaPessoaFisica) throws BusinessException, PersistenceException, RemoteException;
    public boolean delete(long CPF, int Cod_Competencia) throws PersistenceException, RemoteException;
    public List<CompetenciaPessoaFisica> getCompetenciasPessoaFisica(long CPF) throws PersistenceException, RemoteException;  
    public CompetenciaPessoaFisica getCompetenciaPessoaFisicaCod(long CPF, int Cod_Competencia) throws PersistenceException, RemoteException;
}
