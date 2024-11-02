package ahorcadopro;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JPanel {

    private CardLayout cardlayout;
    private JPanel cardpanel;
    private AdminPalabrasSecretas admin;

    public Menu(CardLayout cardlayout, JPanel cardpanel) {
        this.cardlayout = cardlayout;
        this.cardpanel = cardpanel;
        this.admin = new AdminPalabrasSecretas();

        setSize(600, 600);
        setBackground(Color.gray);
        setLayout(new GridBagLayout());

        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = GridBagConstraints.RELATIVE;

        JButton playSet = new JButton("Jugar Ahorcados Fijo");
        JButton playRand = new JButton("Jugar Ahorcados Azar");
        JButton Admin = new JButton("Administrar Palabras");

        playRand.addActionListener(e -> {
            if (admin.getPalabras().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay palabras disponibles. Por favor, agrega palabras antes de jugar.");
            } else {
                String palabra = admin.seleccionarPalabraAleatoria();
                if (palabra != null) {
                    JuegoAhorcadosAzar juego = new JuegoAhorcadosAzar(palabra);
                    Ahorcadis game = new Ahorcadis(cardlayout, cardpanel, palabra);
                    cardpanel.add(game, "game");
                    cardlayout.show(cardpanel, "game");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo seleccionar una palabra.");
                }
            }
        });

        playSet.addActionListener(e -> cardlayout.show(cardpanel, "selec"));
        Admin.addActionListener(e -> cardlayout.show(cardpanel, "admin"));

        add(playSet, con);
        add(playRand, con);
        add(Admin, con);
    }
}
