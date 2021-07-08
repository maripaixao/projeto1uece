package entidades;
abstract class Sistema {
    public Integer numConta;
    Double saldo, valor;
    String status;
    protected String tipo;
    Double dolar = 5.0;
    Double euro = 5.92;
    Double libra = 6.9;
    
    public Sistema(){
    }

    public Sistema(Integer numConta, Double saldo, Double valor, String status, String tipo) {
        this.numConta = numConta;
        this.saldo = saldo;
        this.valor = valor;
        this.status = status;
        this.tipo = tipo;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getDolar() {
        return dolar;
    }

    public void setDolar(Double dolar) {
        this.dolar = 5.0;
    }

    public Double getEuro() {
        return euro;
    }

    public void setEuro(Double euro) {
        this.euro = 5.92;
    }

    public Double getLibra() {
        return libra;
    }

    public void setLibra(Double libra) {
        this.libra = 6.9;
    }

    public abstract void sacar(double valor);
    
    public abstract void depositar(double valor);
    
    public abstract void converterMoeda(double convertido);
    
    public abstract void criarConta(String status);
    
    public abstract void deletarConta(String status);
    
    public abstract void estadoAtual();
    
}
