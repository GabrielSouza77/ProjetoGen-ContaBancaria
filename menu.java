package conta;

import java.util.Scanner;

public class menu {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK_BG = "\u001B[40m";
    public static final String WHITE_TEXT = "\u001B[37m";

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

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
                    System.out.println("Criar Conta\n\n");
                    break;
                case 2:
                    System.out.println("Listar todas as Contas\n\n");
                    break;
                case 3:
                    System.out.println("Consultar dados da Conta - por número\n\n");
                    break;
                case 4:
                    System.out.println("Atualizar dados da Conta\n\n");
                    break;
                case 5:
                    System.out.println("Apagar a Conta\n\n");
                    break;
                case 6:
                    System.out.println("Saque\n\n");
                    break;
                case 7:
                    System.out.println("Depósito\n\n");
                    break;
                case 8:
                    System.out.println("Transferência entre Contas\n\n");
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