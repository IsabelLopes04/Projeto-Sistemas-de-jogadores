
package projeto;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        
         System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
       
        java.awt.EventQueue.invokeLater(() -> {
            new Tela_Jogadores().setVisible(true);
        });
}
}

