/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Andre Matheus
 * @author Gabriel
 * 
 */
public interface CargoInteresseManagement extends Remote {
    public void insert(CargoInteresse CargoInteresse) throws BusinessException, PersistenceException, RemoteException;
    public boolean delete(long CPF, int Cod_Cargo) throws PersistenceException, RemoteException;
    public List<CargoInteresse> getCargosInteresse(long CPF) throws PersistenceException, RemoteException;
    public CargoInteresse getCargoInteresseCod(long CPF, int Cod_Cargo) throws PersistenceException, RemoteException;
}
