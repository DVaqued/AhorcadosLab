/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcadopro;

/**
 *
 * @author angel
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado {
    
    public String palabraSecreta, palabraActual;
    protected int intentos;
    
    public abstract void actualizarPalabraActual(char letra);
    
    public abstract boolean verificarLetra(char letra);
    
    public abstract boolean hasGanado();
}