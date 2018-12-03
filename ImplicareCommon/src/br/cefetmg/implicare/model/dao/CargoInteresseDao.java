package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface CargoInteresseDao {

    public void insert(CargoInteresse CargoInteresse) throws PersistenceException, RemoteException;

    public boolean delete(long CPF, int Cod_Cargo) throws PersistenceException, RemoteException;

    public List<CargoInteresse> getCargosInteresse(long CPF) throws PersistenceException, RemoteException;

    public CargoInteresse getCargoInteresseCod(long CPF, int Cod_Cargo) throws PersistenceException, RemoteException;
}
