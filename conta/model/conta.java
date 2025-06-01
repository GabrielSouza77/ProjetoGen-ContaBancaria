package conta.model;

import java.text.NumberFormat;

public class Conta {
    private int numero;
    private String titular;
    public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	private float saldo;
    private int tipo;

    public Conta(int numero, String titular, float saldo, int tipo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

    public boolean depositar(float valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean sacar(float valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void visualizar() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		default -> tipo = "Inválido";
		}

		System.out.println("***************************************");
		System.out.println("DADOS DA CONTA                         ");
		System.out.println("***************************************");
		System.out.println("Número da Conta: " + this.numero);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular da Conta: " + this.titular);
		System.out.println("Saldo da Conta: " + nfMoeda.format(this.saldo));
	}
}
