package ahorcadopro;

public class JuegoAhorcadosAzar extends JuegoAhorcadoBase {

    public JuegoAhorcadosAzar(String palabra) {
        this.palabraSecreta = palabra;
        this.palabraActual = "_".repeat(palabra.length());
        this.intentos = 6;
    }

    public void inicializarPalabraSecreta() {
        System.out.println(palabraSecreta);
    }

    public void actualizarPalabraActual(char letra) {
        StringBuilder nuevaPalabraActual = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                nuevaPalabraActual.append(letra);
            } else {
                nuevaPalabraActual.append(palabraActual.charAt(i));
            }
        }
        palabraActual = nuevaPalabraActual.toString();
    }

    public boolean verificarLetra(char letra) {
        if (palabraSecreta.indexOf(letra) >= 0) {
            actualizarPalabraActual(letra);
            return true;
        } else {
            intentos--;
            return false;
        }
    }

    public boolean hasGanado() {
        return palabraActual.equals(palabraSecreta);
    }

    public boolean hasPerdido() {
        return intentos <= 0;
    }
}
