package com.example;
public class Conta_corrente {
    

    private int balanço;


    private String nome;

    public Conta_corrente(int balanço, String nome){

        this.balanço=balanço;
        this.nome=nome;
        


    }

    public void deposito(int valor){


       
        System.out.println("Saldo" +this.balanço);

        if (valor > 0) {
            this.balanço += valor;

        }

    }

    public boolean saque(int valor){
        
        if (valor > 0 && valor <= balanço) {
            this.balanço -= valor;
            return true;
        }else{

            return false;


        }


    }

    public int getBalanço() {
        return balanço;
    }

    public void setBalanço(int balanço) {
        this.balanço = balanço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


  
}
