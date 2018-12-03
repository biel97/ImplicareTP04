package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.RemoteException;

/**
 *
 * @author Gabriel
 */
public interface UsuarioDao {

    public void insert(Usuario Usuario) throws PersistenceException, RemoteException;

    public boolean update(Long CPF_CNPJ, Usuario Usuario) throws PersistenceException, RemoteException;

    public Usuario getUsuarioCod(Long CPF_CNPJ) throws PersistenceException, RemoteException;

    public Usuario getLogin(Long CPF_CNPJ, String Senha) throws PersistenceException, RemoteException;
}
