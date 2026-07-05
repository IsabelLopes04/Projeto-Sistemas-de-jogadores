
package projeto;

import java.util.ArrayList;

public interface Crud<T> {
    void cadastrar(T obj);
    ArrayList<T> listar();
    T buscar(int id);
    void excluir(int id);
}
