package projeto;

public class Tecnico extends Pessoa {

    String estiloTatico;
    int id;

    public Tecnico(int id, String estiloTatico, String nome, String nacionalidade, int idade) {
        super(nome, nacionalidade, idade);
        this.id = id;
        this.estiloTatico = estiloTatico;
}

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println(
                "Id: " + id +
                "\nNome: " + nome +
                "\nNacionalidade: " + nacionalidade +
                "\nEstilo Tatico: " + estiloTatico +
                "\nIdade: " + idade);
    }
    
    public String salvarTXT() {
    return id +
           ";" + nome +
           ";" + nacionalidade +
           ";" + estiloTatico +
           ";" + idade;
}

    @Override
    public String toString() {
    return nome;
}

}
