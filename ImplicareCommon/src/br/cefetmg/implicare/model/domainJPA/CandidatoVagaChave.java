/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.domainJPA;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gabriel
 * 
 */

@Embeddable
public class CandidatoVagaChave implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "CPF")
    private PessoaFisicaJPA PessoaFisicaJPA;
    private VagaChave VagaChave;

    public CandidatoVagaChave() {}

    public CandidatoVagaChave(PessoaFisicaJPA PessoaFisicaJPA, VagaChave VagaChave) {
        this.PessoaFisicaJPA = PessoaFisicaJPA;
        this.VagaChave = VagaChave;
    }

    public PessoaFisicaJPA getPessoaFisicaJPA() {
        return PessoaFisicaJPA;
    }

    public void setPessoaFisicaJPA(PessoaFisicaJPA PessoaFisicaJPA) {
        this.PessoaFisicaJPA = PessoaFisicaJPA;
    }

    public VagaChave getVagaChave() {
        return VagaChave;
    }

    public void setExercicio(VagaChave VagaChave) {
        this.VagaChave = VagaChave;
    }

}
