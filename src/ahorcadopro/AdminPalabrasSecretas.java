package ahorcadopro;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class AdminPalabrasSecretas {

    private Random r = new Random();
    private ArrayList<String> palabras;

    public AdminPalabrasSecretas() {
        palabras = new ArrayList<>();
    }

    public void agregarPalabra(String p) {
        if (p != null && !p.trim().isEmpty()) {
            palabras.add(p);
        } else {
            JOptionPane.showMessageDialog(null, "La palabra no puede estar vacía.");
        }
    }

    public String seleccionarPalabraAleatoria() {
        if (!palabras.isEmpty()) {
            String pS = palabras.get(r.nextInt(palabras.size()));
            System.out.println(pS);
            return pS;
        } else {
            JOptionPane.showMessageDialog(null, "No hay palabras disponibles.");
            return null;
        }
    }

    public ArrayList<String> getPalabras() {
        return new ArrayList<>(palabras); 
    }
}
