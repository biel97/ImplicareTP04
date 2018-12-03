/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Andre Matheus
 */
public interface AreaEstudoManagement extends Remote {
    public ArrayList<AreaEstudo> listAll() throws PersistenceException, RemoteException;
    public AreaEstudo getAreaEstudoCod(int Cod_Area_Estudo) throws PersistenceException, RemoteException;
}
