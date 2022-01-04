package br.com.alura.modelo;

import java.io.Serializable;

public abstract class Conta extends Object implements Comparable<Conta>, Serializable {

    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;

    
    public Conta(int agencia, int numero){
        Conta.total++;
       // System.out.println("O total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        //this.saldo = 100;
        //System.out.println("Estou criando uma conta " + this.numero);
    }

    public abstract void deposita(double valor);

    public void saca(double valor) {	//throws SaldoInsuficienteException
        if(this.saldo < valor) {
        	throw new SaldoInsuficienteException("O Saldo: " + this.saldo + ", Valor: " + valor + "... Insuficiente." );
        } 
        this.saldo -= valor;
    }

    public void transfere(double valor, Conta destino) { // throws SaldoInsuficienteException
    	this.saca(valor);
    	destino.deposita(valor);
    }

    public double getSaldo(){
        return this.saldo;
    }
    
    public void setSaldo(double valor){
        this.saldo += valor;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
    
    @Override
    public boolean equals(Object ref) {

    	Conta outraConta = (Conta) ref;
    	
    	if(this.agencia != outraConta.getAgencia()) {
    		return false;
    	}
    	if(this.numero != outraConta.getNumero()) {
    		return false;
    	}
    	
    	return true;
    }
    
    @Override
    public int compareTo(Conta outraConta) {
    	
    	return Double.compare(this.saldo, outraConta.saldo);
    }
    
	@Override
	public String toString() {
		return "Numero " + this.numero + ", Agencia: " + this.agencia;
	}
	

}