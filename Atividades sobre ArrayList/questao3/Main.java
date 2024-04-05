import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    private String nome;
    private int matricula;
    private ArrayList<Float> notas;

    public Aluno(String nome, int matricula, ArrayList<Float> notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public double calcularMedia() {
        double soma = 0;
        for (Float nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }
}
