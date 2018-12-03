package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.PessoaFisica;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Gabriel
 */
public interface PessoaFisicaDao extends Remote {

    public void insert(PessoaFisica PessoaFisica) throws PersistenceException, RemoteException;

    public boolean update(Long CPF, PessoaFisica PessoaFisica) throws PersistenceException, RemoteException;

    public PessoaFisica getPessoaFisicaCod(Long CPF) throws PersistenceException, RemoteException;
}
