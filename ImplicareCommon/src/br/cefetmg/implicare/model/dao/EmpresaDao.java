package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.RemoteException;

/**
 *
 * @author Gabriel
 */
public interface EmpresaDao {

    public void insert(Empresa Empresa) throws PersistenceException, RemoteException;

    public boolean update(Long CNPJ, Empresa Empresa) throws PersistenceException, RemoteException;

    public Empresa getEmpresaCod(Long CNPJ) throws PersistenceException, RemoteException;
}
