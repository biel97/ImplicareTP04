/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.domainJPA;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Morato
 */
public class UsuarioJPA {
    
    @Id
    @Column(name="CPF_CNPJ", nullable = false) 
    private long CPF_CNPJ;
    
    @Column(name="Email", nullable = false)
    private String Email;
    
    @Column(name="Senha", nullable = false)
    private String Senha;
    
    @Column(name="Foto", nullable = false)
    private String Foto;
    
    @Column(name="Cod_CEP", nullable = false)
    private long Cod_CEP;
    
    @Column(name="Endereco", nullable = false)
    private String Endereco;
    
    @Column(name="Desc_Usuario", nullable = false)
    private String Desc_Usuario;
    
    public UsuarioJPA(){}
    
    public UsuarioJPA(long CPF_CNPJ, String Email, String Senha, String Foto, long Cod_Cep, String Endereco, String Desc_Usuario){
        this.CPF_CNPJ = CPF_CNPJ;
        this.Email = Email;
        this.Senha = Senha;
        this.Foto = Foto;
        this.Cod_CEP = Cod_Cep;
        this.Endereco = Endereco;
        this.Desc_Usuario = Desc_Usuario;
    }
    
    public void setCPF_CNPJ(Long CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }
    
     public Long getCPF_CNPJ() {
        return CPF_CNPJ;
    }
     
    public void setEmail(String Email){
        this.Email = Email;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setSenha(String Senha){
        this.Senha = Senha;
    }
    
    public String getSenha(){
        return Senha;
    }
    
    public void setFoto(String Foto){
        this.Foto = Foto;
    }
    
    public String getFoto(){
        return Foto;
    }
    
    public void setCod_CEP(Long Cod_CEP){
        this.Cod_CEP = Cod_CEP;
    }
    
    public Long getCod_CEP(){
        return Cod_CEP;
    }
    
    public void setEndereco(String Endereco){
        this.Endereco = Endereco;
    }
    
    public String getEndereco(){
        return Endereco;
    }
    
    public void setDesc_Usuario(String Desc_Usuario){
        this.Desc_Usuario = Desc_Usuario;
    }   
    
    public String getDesc_Usuario(){
        return Desc_Usuario;
    }
}
