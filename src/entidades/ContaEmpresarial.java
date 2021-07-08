package entidades;

import java.util.Scanner;
import java.util.Random;

public class ContaEmpresarial extends Sistema{
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    private String empresa, cnpj;
    private Double valorConversao;
    
    public ContaEmpresarial(){}

    public ContaEmpresarial(String empresa, String cnpj) {
        this.empresa = empresa;
        this.cnpj = cnpj;
        
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    @Override
    public void sacar(double valor) {
        if(this.getStatus().equals("Ativa")){
            if (this.getSaldo() >= valor){
                System.out.println("Valor a ser sacado R$" + valor);
                this.saldo -= valor;
                System.out.println(this.saldo);
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
            System.out.println(this.saldo);
        } else {
            System.out.println("Não foi possivel realizar a transação.");
        }
    }

    @Override
    public void converterMoeda(double convertido) {
        System.out.println("Informe a Moeda para Conversão 1- Dólar | 2- Euro | 3- Libra");
        int moeda = sc.nextInt();
        System.out.println("Quanto em R$ você deseja converter?");
        this.valorConversao = sc.nextDouble();
        if(this.valorConversao < saldo){
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
    public void criarConta(String status){
    
    }
    
    @Override
    public void deletarConta(String status){
        if (this.getSaldo() > 0){
            System.out.println("Não foi possível realizar essa operação. Ainda há dinheiro na conta.");
        }else if(this.getSaldo() < 0){
            System.out.println("Conta não pode ser fechada, pois  há debitos pendentes.");
        } else{
            this.setStatus("Inativa");
            System.out.println("Conta fechada com sucesso!");
        }
    }

    @Override
    public void estadoAtual() {
        System.out.println("Nº Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Status: " + this.getStatus());
        System.out.println("Empresa: " + this.getEmpresa());
        System.out.println("Saldo: " + this.getSaldo());
    }
}
