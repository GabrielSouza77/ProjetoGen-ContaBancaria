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
	public void sacar(int numero, float valor) {}

	@Override
	public void depositar(int numero, float valor) {}
	
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