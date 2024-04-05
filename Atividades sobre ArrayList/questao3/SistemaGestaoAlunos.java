import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestaoAlunos {
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1- Cadastrar aluno");
            System.out.println("2- Ver todos os alunos cadastrados");
            System.out.println("3- Média do aluno");
            System.out.println("4- Lista dos alunos aprovados");
            System.out.println("5- Lista dos alunos reprovados");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    verAlunos();
                    break;
                case 3:
                    mediaAluno();
                    break;
                case 4:
                    listarAprovados();
                    break;
                case 5:
                    listarReprovados();
                    break;
                case 6:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }
    
    private static void cadastrarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine().toLowerCase(); 
        int matricula = 0; 
        boolean matriculaValida = false;
        do {
            System.out.print("Digite a matrícula do aluno: ");
            if (scanner.hasNextInt()) {
                matricula = scanner.nextInt();
                scanner.nextLine();  
                matriculaValida = true;
                for (Aluno aluno : alunos) {
                    if (aluno.getMatricula() == matricula) {
                        System.out.println("Já existe um aluno com essa matrícula. Digite outra.");
                        matriculaValida = false;
                        break;
                    }
                }
            } else {
                System.out.println("Matrícula inválida! Digite um número para a matricula.");
                scanner.nextLine(); 
            }
        } while (!matriculaValida);
        
        System.out.print("Digite a quantidade de notas do aluno: ");
        int quantidadeNotas = scanner.nextInt();
        ArrayList<Float> notas = new ArrayList<>();
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.printf("Digite a nota %d: ", i + 1);
            notas.add(scanner.nextFloat());
        }
        Aluno aluno = new Aluno(nome, matricula, notas);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso");
    }

    private static void verAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Alunos cadastrados:");
            for (Aluno aluno : alunos) {
                System.out.printf("Nome: %s, Matrícula: %d\n", aluno.getNome(), aluno.getMatricula());
            }
        }
    }

    private static void mediaAluno() {
        System.out.print("Digite a matrícula do aluno: ");
        int matricula = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            if (scanner.hasNextInt()) {
                matricula = scanner.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida! Digite um número para a matrícula.");
                scanner.nextLine();
            }
        }
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                System.out.printf("Média do aluno %s: %.2f\n", aluno.getNome(), aluno.calcularMedia());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void listarAprovados() {
        boolean algumAprovado = false;
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() >= 7) {
                System.out.println("Lista de alunos aprovados: ");
                System.out.printf("Nome: %s, Matrícula: %d\n", aluno.getNome(), aluno.getMatricula());
                algumAprovado = true;
            }
        }
        if (!algumAprovado) {
            System.out.println("Nenhum aluno aprovado.");
        }
    }

    private static void listarReprovados() {
        boolean algumReprovado = false;
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() < 7) {
                System.out.println("Lista de alunos reprovados: ");
                System.out.printf("Nome: %s, Matrícula: %d\n", aluno.getNome(), aluno.getMatricula());
                algumReprovado = true;
            }
        }
        if (!algumReprovado) {
            System.out.println("Nenhum aluno reprovado.");
        }
    }
}

