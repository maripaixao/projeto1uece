package entidades;

import java.util.Scanner;

public class ContaPessoaFisica extends Sistema{
    Scanner sc = new Scanner(System.in);
    private String titular = sc.nextLine();
    private String cpf = sc.nextLine();
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
    public double sacar() {
        return this.saldo -= this.saque;
    }

    @Override
    public double depositar() {
        return this.saldo += this.deposito;
    }

    @Override
    public double transferir() {
        this.saldo -= this.saque;
        return this.saldo += this.deposito;
    }

    @Override
    public double converterMoeda() {
        Double convertido = null;
        System.out.println("Informe a Moeda para Conversão\n1- Dólar\n2- Euro\n3- Libra");
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
        return convertido;
        }
    
    public void criarConta(){
        
    }
    
    public void entrarConta(){
        
    }
    
    public void sairConta(){
        
    }
    
    public void deletarConta(){
        
    }
    }

