/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Proficiencia;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Andre Matheus
 */
public interface ProficienciaManagement extends Remote {
    public List<Proficiencia> listAll() throws PersistenceException, RemoteException;
    public Proficiencia getProficienciaCod(int Cod_Proficiencia) throws PersistenceException, RemoteException;
}
