import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1- Cadastrar novo funcionário");
            System.out.println("2- Ver todos os funcionários cadastrados");
            System.out.println("3- Identificar funcionários da especificação");
            System.out.println("4- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // se não tiver isso, ele nao faz o print abaixo
                    System.out.print("Digite o nome do funcionário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o salario anual do funcionário: R$");
                    double salarioAnual = scanner.nextDouble();
                    System.out.print("Digite a idade do funcionário: ");
                    int idade = scanner.nextInt();
                    gerenciador.adicionarFuncionario(new Funcionario(nome, salarioAnual, idade));
                    System.out.println("Funcionario cadastrado com sucesso");
                    break;
                case 2:
                    gerenciador.listarFuncionarios();
                    break;
                case 3:
                    gerenciador.identificarFuncionariosEspecificacao();
                    break;
                case 4:
                    System.out.println("Encerrando programa");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha uma opção valida.");
            }
        } while (opcao != 4);
        
        scanner.close();
    }
}
