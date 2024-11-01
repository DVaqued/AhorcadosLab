/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcadopro;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Omar Romero
 */
public class SeleccionarPalabra extends JPanel {

    private CardLayout cardlayout;
    private JPanel cardpanel;

    public SeleccionarPalabra(CardLayout cardlayout, JPanel cardpanel) {
        this.cardlayout = cardlayout;
        this.cardpanel = cardpanel;

        setSize(600, 600);
        setLayout(new GridBagLayout());

        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = GridBagConstraints.RELATIVE;

        JLabel text = new JLabel();
        text.setPreferredSize(new Dimension(300, 30));
        text.setText("Seleccionar una palabra");

        JComboBox letras = new JComboBox();
        //JCOMBOBOX NO SE COMO SE USA
        letras.setPreferredSize(new Dimension(300, 30));

        JButton jugar = new JButton("Jugar");
        jugar.setPreferredSize(new Dimension(200, 30));

        JButton volver = new JButton("Volver");
        volver.setPreferredSize(new Dimension(200, 30));

        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(cardpanel, "menu");
            }
        });

        jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //agregar las palabras al jcombobox
                String temp="PALABRA DEL JCOMBO";
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
}
