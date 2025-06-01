package conta;

import java.util.Optional;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK_BG = "\u001B[40m";
    public static final String WHITE_TEXT = "\u001B[37m";

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        ContaController contas = new ContaController();

        String[] ascii = {
            "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢻⣧⣀⣼⠇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄",
            "⠄⣠⣾⣿⣷⡀⠄⠄⠄⠄⠄⣤⣶⣿⣿⣿⣦⣄⠄⠄⠄⠄⠄⣠⣾⣿⣷⣄⠄",
            "⠺⣿⣿⣿⣿⣿⣦⡀⠄⠄⠄⠿⢿⣿⣿⣿⡿⠟⠄⠄⠄⢀⣼⣾⣿⣿⣿⡿⠇",
            "⠄⠈⠻⢿⣿⣿⢛⡇⠄⠄⢀⣠⡤⣖⣗⣷⠤⣄⣀⠄⠄⣸⠛⣿⣿⡿⠋⠄⠄",
            "⠄⠄⠄⠄⠙⠛⠛⢗⡴⣛⠭⣖⢂⠏⡟⢹⠖⢖⠭⡓⢤⡛⠛⠛⠉⠄⠄⠄⠄",
            "⠄⠄⠄⠄⠄⠄⡴⣫⢞⢈⡳⠛⠈⠉⠉⠉⠙⠺⢦⡿⠢⡙⣆⠄⠄⠄⠄⠄⠄",
            "⠄⠄⠄⠄⠄⡾⣱⠉⡲⣏⢀⡠⠴⢶⣟⣓⡤⠔⣚⠑⣖⢛⡌⣧⠄⠄⠄⠄⠄",
            "⠄⠄⠄⠄⢸⢧⣇⢬⠃⠐⢵⣏⣛⠸⢷⣶⣚⡭⠾⠄⠘⣑⣺⢸⡄⠄⠄⠄⠄",
            "⠄⠄⠄⠨⣯⣿⣙⣨⠄⠄⠣⠩⢖⣫⠭⠭⡵⣚⣭⢅⠄⡷⢶⣿⣽⠄⠄⠄⠄",
            "⠄⠄⠄⠈⠹⡝⣿⡿⡀⠄⠈⣋⡭⢖⣫⡭⣞⡽⢖⣫⢤⣉⣹⢹⠏⠄⠄⠄⠄",
            "⠄⣦⡀⠄⠄⢳⡱⣥⡶⢄⠄⠸⡚⠁⢰⣛⡭⠖⠉⡠⠳⣭⢇⡟⠄⠄⢀⣴⠄",
            "⢰⣿⢷⣤⡀⠈⠳⣝⢤⣾⠶⣤⣕⣀⠄⣀⣀⣤⠚⣷⡶⣣⠞⠄⢀⣴⢿⣿⠄",
            "⠄⣿⢞⣷⡀⠄⢀⠜⠲⣍⡲⠿⣢⣰⣩⣠⡃⠿⣛⡡⠞⠥⡀⠄⣠⣟⡶⡿⠄",
            "⠄⠄⠈⢫⡻⣶⡟⠁⠄⠄⠉⠑⠒⣗⣟⡗⠒⠛⠉⠄⠄⠄⢨⣶⣯⠞⠄⠁⠄",
            "⠄⠄⠄⡠⠻⢮⡻⣦⣄⡀⠄⠄⣀⣥⣥⣥⡀⠄⠄⣀⣠⡶⣿⡿⠛⢆⠄⠄⠄",
            "⠄⠄⠾⠉⠄⠄⠙⠿⣽⣟⣿⣿⡿⠟⢹⣿⣿⣿⣟⣿⣽⠞⠋⠄⠄⠄⠑⠄⠄"
        };

        String[] menu = {
            "*****************************************************",
            "*                                                   *",
            "*                BANCO DO TIMÃO              *",
            "*                                                   *",
            "*****************************************************",
            "*            1 - Criar Conta                        *",
            "*            2 - Listar todas as Contas             *",
            "*            3 - Buscar Conta por Numero            *",
            "*            4 - Atualizar Dados da Conta           *",
            "*            5 - Apagar Conta                       *",
            "*            6 - Sacar                              *",
            "*            7 - Depositar                          *",
            "*            8 - Transferir valores entre Contas    *",
            "*            9 - Sair                               *",
            "*****************************************************",
            "* Entre com a opção desejada:                       *"
        };

        while (true) {
            System.out.print(BLACK_BG + WHITE_TEXT);
            for (int i = 0; i < ascii.length; i++) {
                String menuLine = (i < menu.length) ? menu[i] : "                                                     ";
                System.out.printf("%-55s %s%n", menuLine, ascii[i]);
            }
            System.out.print(RESET);

            int opcao = leia.nextInt();

            if (opcao == 9) {
                System.out.println("\nBanco do Timão - O maior do Brasil!");
                sobre();
                leia.close();
                System.exit(0);
            }

	            switch (opcao) {
	            case 1:
	                System.out.println("Criar Conta\n");

	                System.out.println("Digite o nome do Titular:");
	                leia.skip("\\R");
	                String titular = leia.nextLine();

	                System.out.println("Digite o tipo da conta (1 - CC | 2 - CP):");
	                int tipo = leia.nextInt();

	                System.out.println("Digite o Saldo inicial da conta:");
	                float saldo = leia.nextFloat();

	                if (tipo == 1) {
	                    System.out.println("Digite o limite da conta:");
	                    float limite = leia.nextFloat();
	                    contas.cadastrar(new ContaCorrente(
	                        contas.gerarNumero(), 
	                        titular, 
	                        saldo, 
	                        tipo, 
	                        limite
	                    ));
	                } else if (tipo == 2) {
	                    System.out.println("Digite a taxa de juros (%):");
	                    float taxaJuros = leia.nextFloat();
	                    contas.cadastrar(new ContaPoupanca(
	                        contas.gerarNumero(), 
	                        titular, 
	                        saldo, 
	                        tipo, 
	                        taxaJuros
	                    ));
	                }
	                break;
	            case 2:
	                System.out.println("Listar todas as Contas\n");
	                contas.listarTodas();
	                break;
	
	            case 3:
	                System.out.println("Consultar dados da Conta - por número\n");
	                System.out.println("Digite o número da conta: ");
	                int numeroConsulta = leia.nextInt();
	                contas.procurarPorNumero(numeroConsulta);
	                break;
	            case 4:
	                System.out.println("Atualizar dados da Conta\n");
	                System.out.println("Digite o número da conta: ");
	                int numeroAtualizar = leia.nextInt();

	                Optional<Conta> conta = contas.buscarNasContas(numeroAtualizar);

	                if (conta.isPresent()) {
	                    System.out.println("Digite o nome do Titular:");
	                    leia.skip("\\R");
	                    String titularAtualizar = leia.nextLine();

	                    int tipoAtualizar = conta.get().getTipo();

	                    System.out.println("Digite o novo Saldo da conta:");
	                    float saldoAtualizar = leia.nextFloat();

	                    if (tipoAtualizar == 1) {
	                        System.out.println("Digite o novo limite da conta:");
	                        float limiteAtualizar = leia.nextFloat();
	                        contas.atualizar(new ContaCorrente(
	                            numeroAtualizar,
	                            titularAtualizar,
	                            saldoAtualizar,
	                            tipoAtualizar,
	                            limiteAtualizar
	                        ));
	                    } else if (tipoAtualizar == 2) {
	                        System.out.println("Digite a nova taxa de juros (%):");
	                        float taxaJurosAtualizar = leia.nextFloat();
	                        contas.atualizar(new ContaPoupanca(
	                            numeroAtualizar,
	                            titularAtualizar,
	                            saldoAtualizar,
	                            tipoAtualizar,
	                            taxaJurosAtualizar
	                        ));
	                    }
	                } else {
	                    System.out.printf("\nA conta número %d não existe!\n", numeroAtualizar);
	                }
	                break;
	            case 5:
	                System.out.println("Apagar a Conta\n");
	                System.out.println("Digite o número da conta: ");
	                int numeroDeletar = leia.nextInt();
	                contas.deletar(numeroDeletar);
	                break;
	            case 6:
	                System.out.println("Saque\n");
	                System.out.print("Digite o número da conta: ");
	                int numeroSaque = leia.nextInt();
	                System.out.print("Digite o valor do saque: ");
	                float valorSaque = leia.nextFloat();
	                contas.sacar(numeroSaque, valorSaque);
	                break;
	            case 7:
	                System.out.println("Depósito\n");
	                System.out.print("Digite o número da conta: ");
	                int numeroDeposito = leia.nextInt();
	                System.out.print("Digite o valor do depósito: ");
	                float valorDeposito = leia.nextFloat();
	                contas.depositar(numeroDeposito, valorDeposito);
	                break;
	            case 8:
	                System.out.println("Transferência entre Contas\n");
	                System.out.print("Digite o número da conta de origem: ");
	                int numOrigem = leia.nextInt();
	                System.out.print("Digite o número da conta de destino: ");
	                int numDestino = leia.nextInt();
	                System.out.print("Digite o valor da transferência: ");
	                float valorTransferencia = leia.nextFloat();
	                contas.transferir(numOrigem, numDestino, valorTransferencia);
	                break;
	            default:
	                System.out.println("\nOpção Inválida!\n");
	                break;
	        }

        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Gabriel Souza");
        System.out.println("Generation Brasil - generation@generation.org");
        System.out.println("github.com/https://github.com/GabrielSouza77/ProjetoGen-ContaBancaria");
        System.out.println("*********************************************************");
    }
}