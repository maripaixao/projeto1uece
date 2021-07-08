package entidades;

import java.util.Scanner;
import java.util.Random;

public class ContaPessoaFisica extends Sistema{
    Random random = new Random();
    Scanner scn = new Scanner(System.in);
    private String titular, cpf;
    private Double valorConversao;
    
    public ContaPessoaFisica(){
    }

    public ContaPessoaFisica(String titular, String cpf, Double valorConversao) {
        this.titular = titular;
        this.cpf = cpf;
        this.valorConversao = valorConversao;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Double getValorConversao() {
        return valorConversao;
    }
    
    public void setValorConversao(Double valorConversao) {
        this.valorConversao = valorConversao;
    }
    
    @Override
    public void sacar(double valor) {
        if(this.getStatus().equals("Ativa")){
            if (this.getSaldo() >= valor){
                System.out.println("Valor a ser sacado R$" + valor);
                this.saldo -= valor;
                System.out.println("Saldo atualizado R$" + this.saldo);
            } else{
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Não foi possivel realizar a transação.");
        }
    }

    @Override
    public void depositar(double valor) {
        if(this.getStatus().equals("Ativa")){
            System.out.println("Depósito de R$" + valor + " efetuado com sucesso!");
            this.saldo += valor;
            System.out.println("Saldo atualizado R$ " + this.saldo);
        } else {
            System.out.println("Não foi possivel realizar a transação.");
        }
    }

    @Override
    public void converterMoeda(double convertido) {
        System.out.println("Informe a Moeda 1- Dólar | 2- Euro | 3- Libra");
        int moeda = scn.nextInt();
        this.valorConversao = this.getSaldo();
        if(this.valorConversao < this.saldo){
            switch(moeda){  
                case 1:
                    convertido = this.valorConversao / dolar;
                    System.out.println("Compra de U$" + convertido + " efetuada com sucesso!");
                    break;
                case 2:
                    convertido = this.valorConversao / euro;
                    System.out.println("Compra de €" + convertido + " efetuada com sucesso!");
                    break;
                case 3:
                    convertido = this.valorConversao / libra;
                    System.out.println("Compra de £" + convertido + " efetuada com sucesso!");
                    break;
                default:
                    System.out.println("Não foi possível realizar a transação.");
            }
        } else{
            System.out.println("Você não possui saldo suficiente.");
        }
        }
    
    @Override
    public void deletarConta(String status){
        if (this.getSaldo() > 0){
            System.out.println("Não foi possível realizar essa operação. Ainda há dinheiro na conta.");
        }else if(this.getSaldo() < 0){
            System.out.println("Há débitos em sua conta, portanto não foi possível encerrá-la.");
        } else{
            this.setStatus("Inativa");
            System.out.println("Conta fechada com sucesso!");
            this.estadoAtual();
        }
        
    }
    
    @Override
    public void criarConta(String status){
        this.setStatus("Ativa");
    }

    @Override
    public void estadoAtual() {
        System.out.println("");
        System.out.println("=========================================");
        System.out.println("Nº Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Status: " + this.getStatus());
        System.out.println("Titular: " + this.getTitular());
        System.out.println("Saldo: " + this.saldo);
}
}
    

