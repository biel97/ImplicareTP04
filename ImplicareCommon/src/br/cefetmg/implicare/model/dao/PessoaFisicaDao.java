package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.PessoaFisica;
import br.cefetmg.implicare.model.exception.PersistenceException;

/**
 *
 * @author Gabriel
 */
public interface PessoaFisicaDao {

    public void insert(PessoaFisica PessoaFisica) throws PersistenceException;

    public boolean update(Long CPF, PessoaFisica PessoaFisica) throws PersistenceException;

    public PessoaFisica getPessoaFisicaCod(Long CPF) throws PersistenceException;
}
