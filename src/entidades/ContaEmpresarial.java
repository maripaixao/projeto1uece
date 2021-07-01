package entidades;

import java.util.Scanner;

public class ContaEmpresarial extends Sistema{
    Scanner sc = new Scanner(System.in);
    private String empresa;
    private String cnpj;
    private Double emprestimo;
    private Double juros;
    private Double valorConversao;
    
    public ContaEmpresarial(){}

    public ContaEmpresarial(String empresa, String cnpj, Double emprestimo, Double juros) {
        this.empresa = empresa;
        this.cnpj = cnpj;
        this.emprestimo = emprestimo;
        this.juros = juros;
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

    public Double getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Double emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
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
    
    public double solicitarEmprestimo(){
        
    }
}
