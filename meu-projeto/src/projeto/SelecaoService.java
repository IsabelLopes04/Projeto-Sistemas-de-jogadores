
package projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SelecaoService implements Crud<Selecao>{
    ArrayList<Selecao> selecoes;
    
    public SelecaoService(){
        this.selecoes = new ArrayList<>();
        carregarArquivo();
    }
    
    public String listarSelecoes(){
        String texto = "";
        for (int i = 0; i < selecoes.size(); i++){
           texto += selecoes.get(i).salvarTXT()+"\n";
        }
        
        return texto;
    }
    
    public void salvarArquivo() throws IOException {

    BufferedWriter bw =
        new BufferedWriter(
            new FileWriter(
                "selecoes.txt",
                StandardCharsets.UTF_8,
                false
            )
        );

    bw.write(listarSelecoes());

    bw.close();
}

    @Override
public void cadastrar(Selecao s) {

    selecoes.add(s);

    try {
        salvarArquivo();
    } catch(IOException e) {
        e.printStackTrace();
    }
}

    @Override
    public ArrayList<Selecao> listar() {
        return selecoes;
    }

    @Override
    public Selecao buscar(int id) {
        for(int i = 0; i < selecoes.size(); i++){
            if (id == selecoes.get(i).id){
                return selecoes.get(i);
            }
        }
        return null;
    }

    public void editar(int id, String nome, String continente, Tecnico tecnico, int qtdTitulos, int rankingFifa) {
        for (int i = 0; i < selecoes.size(); i++){
            if (selecoes.get(i).id == id){
               selecoes.get(i).nome = nome;
               selecoes.get(i).continente = continente;
               selecoes.get(i).tecnico = tecnico;
               selecoes.get(i).qtdTitulos = qtdTitulos;
               selecoes.get(i).rankingFifa = rankingFifa;
               
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
        for (int i = 0; i < selecoes.size(); i++){
            if (selecoes.get(i).id == id){
                selecoes.remove(i);
                 try {
                salvarArquivo();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return;
            }
        }
    }
    
    public void carregarArquivo() {
    try {

        BufferedReader br =
            new BufferedReader(
                new FileReader("selecoes.txt"));

        String linha;

        while ((linha = br.readLine()) != null) {
            
            if (linha.trim().isEmpty()) {
                continue;
                }

            String[] dados = linha.split(";");
            
            if (dados.length < 6) {
        continue;
    }

            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            String continente = dados[2];

            TecnicoService tecnicoService = new TecnicoService();
            int idTecnico = Integer.parseInt(dados[3]);
            Tecnico tecnico = tecnicoService.buscar(idTecnico);

            int ranking = Integer.parseInt(dados[4]);
            int titulos = Integer.parseInt(dados[5]);

            Selecao s =
                new Selecao(
                    id,
                    ranking,
                    titulos,
                    nome,
                    continente,
                    new ArrayList<>(),
                    tecnico
                );

            selecoes.add(s);
        }

        br.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    
    
    
    
}
