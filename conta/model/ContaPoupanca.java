package conta.model;

public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(int numero, String titular, double taxaJuros) {
        super(numero, titular);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void aplicarRendimento() {
        setSaldo(getSaldo() + getSaldo() * (taxaJuros / 100));
    }

    protected void setSaldo(double saldo) {
        super.setSaldo(saldo);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", taxaJuros=%.2f%%}", taxaJuros);
    }
}
