package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public interface AreaEstudoDao {

    public ArrayList<AreaEstudo> listAll() throws PersistenceException;

    public AreaEstudo getAreaEstudoCod(int Cod_Area_Estudo) throws PersistenceException;
}
