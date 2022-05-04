package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author erick
 */
public class Cliente {
    
    private int idCliente;
    private String nomeCliente;
    private String CPF;
    private String dataNascimento;
    private String estadoCivil;
    private String sexo;
    private String CEP;
    private String rua;
    private String numero;
    private String celular;
    private String email;
    
   
    public Cliente() {
    }

   
     
    public Cliente(int id, String nomeCliente, String CPF, String dataNascimento, String estadoCivil, String sexo, String CEP, String logradouro, String numero, String telefone, String celular, String email) {
        this.idCliente = id;
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.CEP = CEP;
        this.numero = numero;
        this.celular = celular;
        this.email = email;
    }
    
    
    public Cliente(String nomeCliente, String CPF, String dataNascimento, String estadoCivil, String sexo, String CEP, String logradouro, String numero, String telefone, String celular, String email) {
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.CEP = CEP;
        this.numero = numero;       
        this.celular = celular;
        this.email = email;
    }
  
    
  
    public int getId() {
        return idCliente;
    }
    
    
    public void setId(int id) {
        this.idCliente = id;
    }

    
    public String getNomeCliente() {
        return nomeCliente;
    }

   
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

   
    public String getCPF() {
        return CPF;
    }

  
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
     
   
    public String getDataNascimento() {
        return dataNascimento;
    }

   
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

   
    public String getEstadoCivil() {
        return estadoCivil;
    }

    
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

   
    public String getSexo() {
        return sexo;
    }

   
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   
     
    public String getCEP() {
        return CEP;
    }

   
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
    public String getNumero() {
        return numero;
    }

    
     
    public void setNumero(String numero) {
        this.numero = numero;
    }
   
    public String getCelular() {
        return celular;
    }

    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }
    
      public String getRua() {
        return rua;
    }
    
    
    public void setRua(String rua) {
        this.rua = rua;
    }
}

 


