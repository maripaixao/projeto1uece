package entidades;
abstract class Sistema {
    private Integer numConta;
    Double saldo;
    Double saque;
    Double deposito;
    private Boolean contaFisica = true;
    Double dolar = 5.0;
    Double euro = 5.92;
    Double libra = 6.9;
    
    public Sistema(){
    }

    public Sistema(Integer numConta, Double saldo, Double saque, Double deposito, Boolean contaFisica) {
        this.numConta = numConta;
        this.saldo = saldo;
        this.saque = saque;
        this.deposito = deposito;
        this.contaFisica = contaFisica;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaque() {
        return saque;
    }

    public void setSaque(Double saque) {
        this.saque = saque;
    }

    public Double getDeposito() {
        return deposito;
    }

    public void setDeposito(Double deposito) {
        this.deposito = deposito;
    }

    public Boolean getContaFisica() {
        return contaFisica;
    }

    public void setContaFisica(Boolean contaFisica) {
        this.contaFisica = contaFisica;
    }

    public Double getDolar() {
        return dolar;
    }

    public void setDolar(Double dolar) {
        this.dolar = dolar;
    }

    public Double getEuro() {
        return euro;
    }

    public void setEuro(Double euro) {
        this.euro = euro;
    }

    public Double getLibra() {
        return libra;
    }

    public void setLibra(Double libra) {
        this.libra = libra;
    }
    
    public abstract double sacar();
    
    public abstract double depositar();
    
    public abstract double transferir();
    
    public abstract double converterMoeda();
    
}
