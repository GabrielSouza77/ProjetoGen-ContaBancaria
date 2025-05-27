package conta.model;

public class ContaPoupanca extends Conta {
    private float taxaJuros;

    public ContaPoupanca(int numero, String titular, float saldo, int tipo, float taxaJuros) {
        super(numero, titular, saldo, tipo);
        this.taxaJuros = taxaJuros;
    }

    public float getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(float taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void aplicarRendimento() {
        setSaldo(getSaldo() + getSaldo() * (taxaJuros / 100f));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", taxaJuros=%.2f%%", taxaJuros);
    }
}
