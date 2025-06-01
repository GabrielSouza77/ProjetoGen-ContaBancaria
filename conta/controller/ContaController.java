package conta.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{

	private ArrayList<Conta> contas = new ArrayList<>();
	
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		Optional<Conta> conta = buscarNasContas(numero);

		if (conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nA Conta número %d não foi encontrada", numero);

	}

	@Override
	public void listarTodas() {
		for (var conta : contas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		contas.add(conta);
		System.out.println("A Conta foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNasContas(conta.getNumero());

		if (buscaConta.isPresent()) {
			contas.set(contas.indexOf(buscaConta.get()), conta);
			System.out.println("Dados Anteriores");
			buscaConta.get().visualizar();
			System.out.println("Dados Atualizados");
			procurarPorNumero(buscaConta.get().getNumero());
			System.out.printf("\nA Conta número %d foi atualizada com sucesso!", conta.getNumero());
		}else
			System.out.printf("\nA Conta número %d não foi encontrada", conta.getNumero());

	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNasContas(numero);

		if (conta.isPresent()) {
			if(contas.remove(conta.get()) == true)
				System.out.printf("\nA Conta número %d foi excluída com sucesso!", numero);
		} else
			System.out.printf("\nA Conta número %d não foi encontrada", numero);

	}
	
	@Override
	public void sacar(int numero, float valor) {
	    Optional<Conta> conta = buscarNasContas(numero);
	    
	    if (conta.isPresent()) {
	        boolean sucesso = conta.get().sacar(valor);
	        
	        if (sucesso) {
	            System.out.printf("\nSaque de R$ %.2f realizado com sucesso na conta %d!", valor, numero);
	        } else {
	            System.out.println("\nSaldo insuficiente ou valor inválido para saque!");
	        }
	    } else {
	        System.out.printf("\nConta %d não encontrada!", numero);
	    }
	}

	@Override
	public void depositar(int numero, float valor) {
	    Optional<Conta> conta = buscarNasContas(numero);
	    
	    if (conta.isPresent()) {
	        boolean sucesso = conta.get().depositar(valor);
	        
	        if (sucesso) {
	            System.out.printf("\nDepósito de R$ %.2f realizado com sucesso na conta %d!", valor, numero);
	        } else {
	            System.out.println("\nValor de depósito inválido (deve ser positivo)!");
	        }
	    } else {
	        System.out.printf("\nConta %d não encontrada!", numero);
	    }
	}

	public void transferir(int numOrigem, int numDestino, float valor) {
	    Optional<Conta> origem = buscarNasContas(numOrigem);
	    Optional<Conta> destino = buscarNasContas(numDestino);

	    if (origem.isEmpty() || destino.isEmpty()) {
	        System.out.println("\nUma das contas não existe!");
	        return;
	    }

	    if (origem.get().sacar(valor)) {
	        if (destino.get().depositar(valor)) {
	            System.out.printf(
	                "\nTransferência de R$ %.2f da conta %d para %d realizada com sucesso!",
	                valor, numOrigem, numDestino
	            );
	        } else {
	            origem.get().depositar(valor);
	            System.out.println("\nFalha na transferência: valor inválido para depósito!");
	        }
	    } else {
	        System.out.println("\nSaldo insuficiente ou valor inválido para transferência!");
	    }
	}
	
	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNasContas(int numero) {
		for (var conta : contas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}

		return Optional.empty();
	}

}