package projeto;

public class Jogador extends Pessoa {

    int id, numeroCamisa;
    String posicao;
    double altura, peso;
    Selecao selecao;

    public Jogador(int id, int numeroCamisa, String posicao, Selecao selecao, double altura, double peso, String nome, String nacionalidade, int idade) {
        super(nome, nacionalidade, idade);
        this.id = id;
        this.numeroCamisa = numeroCamisa;
        this.posicao = posicao;
        this.selecao = selecao;
        this.altura = altura;
        this.peso = peso;
    }

    @Override
    public void exibirInfo() {
        System.out.println(
                "\nID: " + this.id + 
                "\nNome: " + nome + 
                "\nNacionalidade: " + nacionalidade +
                "\nIdade: " + idade + 
                "\nNumero da Camisa: " + this.numeroCamisa + 
                "\nPosicao: " + this.posicao + 
                "\nSelecao: " + selecao.nome + 
                "\nAltura: " + this.altura + 
                "\nPeso: " + this.peso);
    }

    @Override
public String toString() {
    return nome;
}

public String salvarTXT() {
    return id +
           ";" + nome +
           ";" + nacionalidade +
           ";" + idade +
           ";" + numeroCamisa +
           ";" + posicao +
           ";" + selecao.nome +
           ";" + altura +
           ";" + peso;
}

}
