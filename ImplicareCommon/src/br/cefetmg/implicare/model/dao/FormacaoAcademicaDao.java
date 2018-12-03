package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface FormacaoAcademicaDao extends Remote {

    public void insert(FormacaoAcademica FormacaoAcademica) throws PersistenceException, RemoteException;

    public boolean update(long CPF, int Seq_Formacao, int Cod_Area_Estudo, FormacaoAcademica FormacaoAcademica) throws PersistenceException, RemoteException;

    public boolean delete(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException, RemoteException;

    public List<FormacaoAcademica> getFormacaoAcademica(long CPF) throws PersistenceException, RemoteException;

    public FormacaoAcademica getFormacaoAcademicaCod(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException, RemoteException;
}
