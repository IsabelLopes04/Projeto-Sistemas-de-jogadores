
package projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JogadorService implements Crud<Jogador>{
    ArrayList<Jogador> jogadores;

    
    public JogadorService(){
        this.jogadores = new ArrayList<>();
        carregarArquivo();
        
    }
    
    
    public void salvarArquivo() throws IOException {

    BufferedWriter bw =
        new BufferedWriter(
            new FileWriter(
                "jogadores.txt",
                StandardCharsets.UTF_8,
                false
            )
        );

    bw.write(listarJogadores());

    bw.close();
}
    
    @Override
    public void cadastrar(Jogador j) {
        jogadores.add(j);
        
        try {
        salvarArquivo();
    } catch(IOException e) {
        e.printStackTrace();
    }
    }
    
    public String listarJogadores(){
        String texto = "";
        for (int i = 0; i < jogadores.size(); i++){
           texto += jogadores.get(i).salvarTXT()+"\n";
        }
        
        return texto;
    }

    @Override
    public ArrayList<Jogador> listar() {
        return jogadores;
    }

    @Override
    public Jogador buscar(int id) {
        for(int i = 0; i < jogadores.size(); i++){
            if (jogadores.get(i).id == id){
                return jogadores.get(i);
            }
        }
        
           System.out.println("Jogador não encontrado!");
           return null;
    }

    public void editar(int id, String nome, String nacionalidade, Selecao selecao, int idade, double altura, double peso, int numeroCamisa, String posicao) {
        for (int i = 0; i < jogadores.size(); i++){
            if (id == jogadores.get(i).id){
               jogadores.get(i).nome = nome;
               jogadores.get(i).nacionalidade = nacionalidade;
               jogadores.get(i).selecao = selecao;
               jogadores.get(i).idade = idade;
               jogadores.get(i).altura = altura;
               jogadores.get(i).peso = peso;
               jogadores.get(i).numeroCamisa = numeroCamisa;
               jogadores.get(i).posicao = posicao;
               
               break;
            }
            
        }
         try {
        salvarArquivo();
    } catch(IOException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void excluir(int id) {
        for (int i = 0; i < jogadores.size(); i++){
            if (jogadores.get(i).id == id){
                jogadores.remove(i);
                 try {
                salvarArquivo();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return;
            }
        }
        System.out.println("Jogador não encontrado!");
    }
    
    public void carregarArquivo(){
    try {

        BufferedReader br = new BufferedReader(new FileReader("jogadores.txt"));

        String linha;

        while ((linha = br.readLine()) != null) {
            
            if (linha.trim().isEmpty()) {
                continue;
                }

            String[] dados = linha.split(";");
            
            if (dados.length < 9) {
        continue;
    }

            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            String nacionalidade = dados[2];
            int idade = Integer.parseInt(dados[3]);
            int camisa = Integer.parseInt(dados[4]);
            String posicao = dados[5];

            String nomeSelecao = dados[6];

            double altura = Double.parseDouble(dados[7]);
            double peso = Double.parseDouble(dados[8]);

            Selecao selecao =
                    new Selecao(
                            0,
                            0,
                            0,
                            nomeSelecao,
                            "",
                            new ArrayList<>(),
                            null
                    );

            Jogador j = new Jogador(
                    id,
                    camisa,
                    posicao,
                    selecao,
                    altura,
                    peso,
                    nome,
                    nacionalidade,
                    idade
            );

            jogadores.add(j);
        }

        br.close();

    } catch (Exception e) {
        System.out.println("Arquivo ainda não existe.");
    }
}
    
}
