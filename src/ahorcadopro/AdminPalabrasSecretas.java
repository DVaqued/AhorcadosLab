package ahorcadopro;

import java.util.ArrayList;
import java.util.Random;

public class AdminPalabrasSecretas {

    private Random r = new Random();
    public static ArrayList<String> palabras; 
    
    public AdminPalabrasSecretas() {
        palabras = new ArrayList<>();
    }

    public void agregarPalabra(String p) {
        if (p != null && !p.trim().isEmpty()) {
            palabras.add(p);
        } else {
            System.out.println("La palabra no puede estar vacía.");
        }
    }

    public String seleccionarPalabraAleatoria() {
        if (!palabras.isEmpty()) {
            return palabras.get(r.nextInt(palabras.size()));
        } else {
            System.out.println("No hay palabras disponibles.");
            return null;
        }
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }
}
