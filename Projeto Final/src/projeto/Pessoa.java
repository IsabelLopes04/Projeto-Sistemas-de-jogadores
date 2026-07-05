package projeto;

public abstract class Pessoa {

    String nome, nacionalidade;
    int idade;

    public Pessoa(String nome, String nacionalidade, int idade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public void exibirInfo() {
        System.out.println(
                "Nome: " + nome + 
                "\nNacionalidade: " + nacionalidade +
                "\nIdade: " + idade);
    }
}
