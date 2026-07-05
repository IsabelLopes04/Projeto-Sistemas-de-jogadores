package projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TecnicoService implements Crud<Tecnico> {

    ArrayList<Tecnico> tecnicos;

    public TecnicoService() {
        this.tecnicos = new ArrayList<>();
        carregarArquivo();
    }

    public String listarTecnicos() {
        String texto = "";
        for (int i = 0; i < tecnicos.size(); i++) {
            texto += tecnicos.get(i).salvarTXT() + "\n";
        }

        return texto;
    }

    public void salvarArquivo() throws IOException {

        BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(
                                "tecnicos.txt",
                                StandardCharsets.UTF_8,
                                false
                        )
                );

        bw.write(listarTecnicos());

        bw.close();
    }

    @Override
    public void cadastrar(Tecnico t) {

        tecnicos.add(t);

        try {
            salvarArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Tecnico> listar() {
        return tecnicos;
    }

    @Override
    public Tecnico buscar(int id) {
        for (int i = 0; i < tecnicos.size(); i++) {
            if (id == tecnicos.get(i).id) {
                return tecnicos.get(i);
            }
        }
        return null;
    }

    public void editar(int id, String nome, String nacionalidade, int idade, String estiloTatico) {
        for (int i = 0; i < tecnicos.size(); i++) {
            if (tecnicos.get(i).id == id) {
                tecnicos.get(i).nome = nome;
                tecnicos.get(i).nacionalidade = nacionalidade;
                tecnicos.get(i).idade = idade;
                tecnicos.get(i).estiloTatico = estiloTatico;
            }
        }
    }

    @Override
    public void excluir(int id) {
        for (int i = 0; i < tecnicos.size(); i++) {
            if (tecnicos.get(i).id == id) {
                tecnicos.remove(i);
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

            BufferedReader br = new BufferedReader(new FileReader("tecnicos.txt"));

            String linha;

            while ((linha = br.readLine()) != null) {
                
                
                if (linha.trim().isEmpty()) {
                continue;
                }

                String[] dados = linha.split(";");
                
                if (dados.length < 5) {
        continue;
    }

                int id = Integer.parseInt(dados[0]);

                String nome = dados[1];

                String nacionalidade = dados[2];

                String estiloTatico = dados[3];

                int idade = Integer.parseInt(dados[4]);

                Tecnico t = new Tecnico(
                        id,
                        estiloTatico,
                        nome,
                        nacionalidade,
                        idade
                );

                tecnicos.add(t);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("ERRO AO CARREGAR TÉCNICOS:");
            e.printStackTrace();
        }
    }

}
