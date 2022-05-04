/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author erick
 */
public class RelatorioAnalitico {
    
    private int idProduto;
    private int idCliente;
    private String Cliente;
    private String Produtos;
    private int QtdVendida;
    private String data;
    private double valor;
    private double valorTotal;

    public RelatorioAnalitico(){
        
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getProdutos() {
        return Produtos;
    }

    public void setProdutos(String Produtos) {
        this.Produtos = Produtos;
    }

    public int getQtdVendida() {
        return QtdVendida;
    }

    public void setQtdVendida(int QtdVendida) {
        this.QtdVendida = QtdVendida;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
