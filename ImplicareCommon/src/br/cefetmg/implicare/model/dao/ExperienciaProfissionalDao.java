package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface ExperienciaProfissionalDao {

    public void insert(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException, RemoteException;

    public boolean update(Long CPF, int Seq_Experiencia, int Cod_Cargo, ExperienciaProfissional ExperienciaProfssional) throws PersistenceException, RemoteException;

    public boolean delete(Long CPF, int Seq_Experiencia, int Cod_Cargo) throws PersistenceException, RemoteException;

    public List<ExperienciaProfissional> getExperienciasProfissionais(Long CPF) throws PersistenceException, RemoteException;

    public ExperienciaProfissional getExperienciaProfissionalCod(Long CPF, int Seq_Experiencia, int Cod_Cargo) throws PersistenceException, RemoteException;
}
