package projeto;

import java.util.ArrayList;

public class Selecao {

    int id, rankingFifa, qtdTitulos;
    String nome, continente;
    Tecnico tecnico;

    public Selecao(int id, int rankingFifa, int qtdTitulos, String nome, String continente, ArrayList<Jogador> jogadores, Tecnico tecnico) {
        this.id = id;
        this.rankingFifa = rankingFifa;
        this.qtdTitulos = qtdTitulos;
        this.nome = nome;
        this.continente = continente;
        this.tecnico = tecnico;
    }
    
    public String getNome() {
    return nome;
}


    public void exibirInfo() {
        System.out.println(
                "Selecao: " + this.nome +
                "\nid: " + id +
                "\nranking Fifa: " + rankingFifa +
                "\nqtd Titulos: " + qtdTitulos +
                "\ncontinente: " + continente +
                "\ntecnico: " + tecnico.id);
    }
    
    public String salvarTXT() {
    return id +
            ";" + nome +
            ";" + continente +
            ";" + tecnico.id +
            ";" + rankingFifa +
            ";" + qtdTitulos;
}
    
    @Override
public String toString() {
    return nome;
}

}
