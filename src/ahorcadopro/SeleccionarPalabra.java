package ahorcadopro;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeleccionarPalabra extends JPanel {
    private CardLayout cardlayout;
    private JPanel cardpanel;
    private JComboBox<String> letras;

    public SeleccionarPalabra(CardLayout cardlayout, JPanel cardpanel) {
        this.cardlayout = cardlayout;
        this.cardpanel = cardpanel;

        setSize(600, 600);
        setLayout(new GridBagLayout());

        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = GridBagConstraints.RELATIVE;

        JLabel text = new JLabel("Seleccionar una palabra");
        text.setPreferredSize(new Dimension(300, 30));

        letras = new JComboBox<>();
        letras.setPreferredSize(new Dimension(300, 30));

        JButton jugar = new JButton("Jugar");
        jugar.setPreferredSize(new Dimension(200, 30));

        JButton volver = new JButton("Volver");
        volver.setPreferredSize(new Dimension(200, 30));

        volver.addActionListener(e -> cardlayout.show(cardpanel, "menu"));

        jugar.addActionListener(e -> {
            String temp = (String) letras.getSelectedItem();
            if (temp != null) {
                Ahorcadis game = new Ahorcadis(cardlayout, cardpanel, temp);
                cardpanel.add(game, "game");
                cardlayout.show(cardpanel, "game");
            }
        });

        add(text, con);
        add(letras, con);
        add(jugar, con);
        add(volver, con);
    }

    public void cargarPalabras(AdminPalabrasSecretas admin) {
        letras.removeAllItems();
        for (String palabra : admin.getPalabras()) { 
            letras.addItem(palabra);
        }
    }
}
