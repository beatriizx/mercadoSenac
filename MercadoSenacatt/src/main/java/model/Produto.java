/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author erick
 */
public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String marca;
    private String categoria;
    private String modelo;
    private int quantidade;
    private double valor;
    private int codigo;
    
    
    public Produto(){
        
    }
    
    public Produto(int id, String nomeProduto,String marca,String categoria, String modelo, int quantidade, double valor, int codigo ){
        this.idProduto = id;
        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.categoria = categoria;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigo = codigo;           
    }
    public Produto(String nomeProduto,String marca,String categoria, String modelo, int quantidade, double valor, int codigo ){
        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.categoria = categoria;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigo = codigo;           
    }
    
    public int getId(){
        return idProduto;
    }
    
    public void setId (int id){
        this.idProduto = id;
    }
    
    public String getNomeProduto(){
        return nomeProduto;
    }
    
    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public double getValor(){
        return valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    
    
}
