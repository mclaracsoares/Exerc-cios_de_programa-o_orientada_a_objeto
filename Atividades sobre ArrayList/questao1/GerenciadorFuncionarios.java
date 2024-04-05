import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFuncionarios {
    private ArrayList<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado");
        } else {
            System.out.println("Funcionarios cadastrados:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome() + ", Salario Anual: R$" + funcionario.getSalarioAnual() + ", Idade: " + funcionario.getIdade() + " anos");
            }
        }
    }


    public void identificarFuncionariosEspecificacao() {
        System.out.println("Funcionarios que tem mais de 30 anos e ganham mais de R$50 mil por ano:");
        boolean encontrou = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalarioAnual() > 50000 && funcionario.getIdade() > 30) {
                encontrou = true;
                System.out.println(funcionario.getNome());
            }
        }
        if (!encontrou) {
            System.out.println("Não há funcionários que atendam aos critérios ");
        }
    }
}
