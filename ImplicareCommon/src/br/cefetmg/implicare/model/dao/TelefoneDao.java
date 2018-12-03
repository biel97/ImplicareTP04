package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface TelefoneDao extends Remote {

    public void insert(Telefone Telefone) throws PersistenceException, RemoteException;

    public boolean update(long CPF_CNPJ, String Num_Telefone, Telefone Telefone) throws PersistenceException, RemoteException;

    public boolean delete(long CPF_CNPJ, String Num_Telefone) throws PersistenceException, RemoteException;

    public List<Telefone> getTelefones(long CPF_CNPJ) throws PersistenceException, RemoteException;

    public Telefone getTelefoneCod(long CPF_CNPJ, String Num_Telefone) throws PersistenceException, RemoteException;
}
