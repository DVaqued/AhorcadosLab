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

public class Administrador extends JPanel {

    private CardLayout cardlayout;
    private JPanel cardpanel;
    private AdminPalabrasSecretas adminPalabras; 

    public Administrador(CardLayout cardlayout, JPanel cardpanel) {
        this.cardlayout = cardlayout;
        this.cardpanel = cardpanel;
        this.adminPalabras = new AdminPalabrasSecretas(); 

        setBackground(Color.gray);
        setSize(600, 600);
        setLayout(new GridBagLayout());

        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = GridBagConstraints.RELATIVE;
        
        JLabel textagregar = new JLabel("Ingrese la palabra que desea agregar");
        textagregar.setPreferredSize(new Dimension(300, 30));
        
        JTextField textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(300, 30));
        
        JButton agregar = new JButton("Agregar Palabra");
        agregar.setPreferredSize(new Dimension(200, 30));
        
        JButton volver = new JButton("Volver");
        volver.setPreferredSize(new Dimension(200, 30));
        
        agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String palabra = textfield.getText().trim();
                if (!palabra.isEmpty()) {
                    adminPalabras.agregarPalabra(palabra); // Usa adminPalabras para agregar la palabra
                    JOptionPane.showMessageDialog(null, "Palabra agregada correctamente.");
                    textfield.setText(""); // Limpiar el campo de texto
                } else {
                    JOptionPane.showMessageDialog(null, "Rellene el campo de palabra");
                }
            }
        });
        
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(cardpanel, "menu");
            }
        });
        
        add(textagregar, con);
        add(textfield, con);
        add(agregar, con);
        add(volver, con);
    }

    public AdminPalabrasSecretas getAdminPalabras() {
        return adminPalabras;
    }
}
