import java.util.ArrayList;
import java.util.InputMismatchException; // para lidar com entradas incorretas
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList<>();

        boolean sair = false;
        while (!sair) {
            System.out.println("Menu:");
            System.out.println("1. Criar pedido");
            System.out.println("2. Visualizar pedidos");
            System.out.println("3. Identificar pedidos com valor total superior a R$500");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = getIntInput(scanner);

            switch (opcao) {
                case 1:
                    Pedido novoPedido = criarPedido(scanner);
                    if (verificarNumeroPedido(pedidos, novoPedido.numero)) {
                        System.out.println("Já existe um pedido com o número informado. Por favor, escolha outro número.");
                    } else {
                        pedidos.add(novoPedido);
                    }
                    break;
                case 2:
                    visualizarPedidos(pedidos);
                    break;
                case 3:
                    identificarPedidosSuperiores(pedidos);
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static Pedido criarPedido(Scanner scanner) {
        System.out.print("Digite o número do pedido: ");
        int numero = getIntInput(scanner);

        ArrayList<ItemPedido> itens = new ArrayList<>();
        System.out.print("Quantos itens no pedido? ");
        int numItens = getIntInput(scanner);

        for (int i = 0; i < numItens; i++) {
            System.out.print("Digite o nome do item " + (i + 1) + ": ");
            String nome = scanner.next();
            System.out.print("Digite o preço do item " + (i + 1) + ": ");
            double preco = getDoubleInput(scanner);
            itens.add(new ItemPedido(nome, preco));
        }

        return new Pedido(numero, itens);
    }

    private static void visualizarPedidos(ArrayList<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para visualizar.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("Pedido #" + pedido.numero + " - Total: R$" + pedido.total);
            }
        }
    }

    private static boolean verificarNumeroPedido(ArrayList<Pedido> pedidos, int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.numero == numero) {
                return true;
            }
        }
        return false;
    }

    private static void identificarPedidosSuperiores(ArrayList<Pedido> pedidos) {
        boolean found = false;
        for (Pedido pedido : pedidos) {
            if (pedido.total > 500) {
                found = true;
                System.out.println("Pedido " + pedido.numero + " - Valor: R$" + pedido.total);
            }
        }

        if (!found) {
            System.out.println("Nenhum pedido possui valor total superior a R$500.");
        }
    }

    private static int getIntInput(Scanner scanner) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                input = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("invalido. Digite um numero.");
                scanner.next();
            }
        }
        return input;
    }

    private static double getDoubleInput(Scanner scanner) {
        double input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                input = scanner.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("invalido. Digite um numero.");
                scanner.next();
            }
        }
        return input;
    }
}
