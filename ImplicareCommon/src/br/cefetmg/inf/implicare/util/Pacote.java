package br.cefetmg.inf.implicare.util;

import java.util.ArrayList;

public class Pacote {

    TipOperacao tipOperacao;
    ArrayList<String> dados;

    public Pacote(TipOperacao tipOperacao, ArrayList<String> dados) {
        this.tipOperacao = tipOperacao;
        this.dados = dados;
    }

    public TipOperacao getTipoOperacao() {
        return tipOperacao;
    }

    public void setTipoOperacao(TipOperacao tipOperacao) {
        this.tipOperacao = tipOperacao;
    }

    public ArrayList<String> getDados() {
        return dados;
    }

    public void setDados(ArrayList<String> dados) {
        this.dados = dados;
    }
    
}
