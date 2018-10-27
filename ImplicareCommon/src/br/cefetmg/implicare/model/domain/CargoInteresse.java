package br.cefetmg.implicare.model.domain;

/**
 *
 * @author Gabriel
 */
public class CargoInteresse {

    private long CPF;
    private int Cod_Cargo;

    public CargoInteresse() {
    }

    public CargoInteresse(long CPF, int Cod_Cargo) {
        this.CPF = CPF;
        this.Cod_Cargo = Cod_Cargo;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }

}
