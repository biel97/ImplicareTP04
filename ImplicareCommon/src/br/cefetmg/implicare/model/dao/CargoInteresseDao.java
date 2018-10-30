package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface CargoInteresseDao {

    public void insert(CargoInteresse CargoInteresse) throws PersistenceException;

    public boolean delete(long CPF, int Cod_Cargo) throws PersistenceException;

    public List<CargoInteresse> getCargosInteresse(long CPF) throws PersistenceException;

    public CargoInteresse getCargoInteresseCod(long CPF, int Cod_Cargo) throws PersistenceException;
}
