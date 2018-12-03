package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface VagaDao {

    public void insert(Vaga Vaga) throws PersistenceException, RemoteException;

    public boolean update(long CNPJ, int Cod_Cargo, Date Dat_Publicacao, Vaga Vaga) throws PersistenceException, RemoteException;

    public boolean delete(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException, RemoteException;

    public List<Vaga> getVagaCNPJ(long CNPJ) throws PersistenceException, RemoteException;

    public List<Vaga> getVagaCod_Cargo(List<CargoInteresse> CarInteresse) throws PersistenceException, RemoteException;

    public Vaga getVagaCod(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException, RemoteException;
}
