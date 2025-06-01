package conta.model;

import java.text.NumberFormat;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numero, String titular, float saldo, int tipo, double limite) {
        super(numero, titular, saldo, tipo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(float valor) {
        if (valor > 0 && valor <= (getSaldo() + limite)) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    public void setSaldo(float saldo) {
        super.setSaldo(saldo);
    }

    @Override
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		super.visualizar();
		System.out.println("Limite da conta: " + nfMoeda.format(this.limite));
	}
}