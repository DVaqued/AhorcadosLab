/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcadopro;

/**
 *
 * @author ernes
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {

    public JuegoAhorcadoFijo() {
        this.palabraActual = "_".repeat(palabraSecreta.length());
        this.intentos = 5;
    }

    public void inicializarPalabraSecreta(String palabra) {
        this.palabraSecreta = palabra;
        System.out.println("La palabra secreta es: " + palabraSecreta);
    }

    @Override
    public void actualizarPalabraActual(char letra) {
        String nuevaactual = "";

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                nuevaactual += letra;
            } else {
                nuevaactual += palabraActual.charAt(i);
            }
        }

        palabraActual = nuevaactual;
    }

    @Override
    public boolean verificarLetra(char letra) {
        boolean verificar = palabraSecreta.indexOf(letra) >= 0;

        if (verificar) {
            actualizarPalabraActual(letra);
        } else {
            intentos--;
        }

        return verificar;
    }

    @Override
    public boolean hasGanado() {
        return palabraActual.equals(palabraSecreta);
    }

    @Override
    public void inicializarPalabraSecreta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}