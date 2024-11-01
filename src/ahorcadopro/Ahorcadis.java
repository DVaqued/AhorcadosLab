package ahorcadopro;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ahorcadis extends JPanel {
    
    private CardLayout cardlayout;
    private JPanel cardpanel;
    private String palabra;

    public Ahorcadis(CardLayout cardlayout, JPanel cardpanel, String palabra) {
        this.cardlayout = cardlayout;
        this.cardpanel = cardpanel;
        this.palabra = palabra;

        setBackground(Color.gray);
        setSize(600, 600);
        setLayout(new GridBagLayout());

        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = GridBagConstraints.RELATIVE;

        JLabel personita = new JLabel();
        personita.setPreferredSize(new Dimension(200, 200));

        JLabel espacioadivinar = new JLabel();
        espacioadivinar.setPreferredSize(new Dimension(300, 30));
        espacioadivinar.setText("_".repeat(palabra.length()));

        JTextField textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(40, 30));

        JButton submit = new JButton("Probar letra");
        submit.setPreferredSize(new Dimension(150, 40));

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!textfield.getText().isBlank()) {
                    String temp = textfield.getText();
                    if (temp.length() == 1) {
                        char letra = temp.charAt(0);
                        // Aquí deberías llamar a la lógica para verificar la letra
                        // Ejemplo: verificarLetra(letra);
                        // Actualiza espacioadivinar con la nueva palabra actual
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese unicamente una letra");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Rellene el campo de letra");
                }
            }
        });

        JButton rendirse = new JButton("Rendirse");
        rendirse.setPreferredSize(new Dimension(150, 40));
        rendirse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(cardpanel, "menu");
            }
        });

        add(personita, con);
        add(espacioadivinar, con);
        add(textfield, con);
        add(submit, con);
        add(rendirse, con);
    }
}