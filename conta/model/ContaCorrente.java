package conta.model;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numero, String titular, double limite) {
        super(numero, titular);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= (getSaldo() + limite)) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    protected void setSaldo(double saldo) {
        super.setSaldo(saldo);
    }

    @Override
    public String toString() {
        return super.toString() + ", limite=" + limite + "}";
    }
}