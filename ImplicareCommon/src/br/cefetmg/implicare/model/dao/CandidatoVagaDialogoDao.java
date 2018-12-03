package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.CandidatoVagaDialogo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface CandidatoVagaDialogoDao extends Remote {

    public void insert(CandidatoVagaDialogo CandidatoVagaDialogo) throws PersistenceException, RemoteException;

    public List<CandidatoVagaDialogo> getCandidatoVagaDialogo(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao) throws PersistenceException, RemoteException;

    public CandidatoVagaDialogo getCandidatoVagaDialogoCod(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao, Timestamp Dat_Dialogo) throws PersistenceException, RemoteException;
}
