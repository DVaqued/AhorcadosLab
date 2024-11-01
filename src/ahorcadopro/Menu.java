package ahorcadopro;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel {

    private CardLayout cardlayout;
    private JPanel cardpanel;

    public Menu(CardLayout cardlayout, JPanel cardpanel) {
        this.cardlayout = cardlayout;
        this.cardpanel = cardpanel;

        setSize(600, 600);
        setBackground(Color.gray);
        setLayout(new GridBagLayout());

        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = GridBagConstraints.RELATIVE;

        JButton playSet = new JButton("Jugar Ahorcados Fijo");
        playSet.setPreferredSize(new Dimension(200, 30));
        JButton playRand = new JButton("Jugar Ahorcados Azar");
        playRand.setPreferredSize(new Dimension(200, 30));
        JButton Admin = new JButton("Adimnistrar Palabras");
        playRand.setPreferredSize(new Dimension(200, 30));
        
        
        playRand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String palabraAleatoria = "ejemplo"; // Reemplaza con la lógica para seleccionar una palabra al azar
                JuegoAhorcadosAzar game = new JuegoAhorcadosAzar(palabraAleatoria);
                
                // Para inicializar o mostrar la palabra secreta, si es necesario
                game.inicializarPalabraSecreta();

                // Agregar el juego al cardpanel y mostrarlo
                cardpanel.add(game, "game");
                cardlayout.show(cardpanel, "game");
            }
        });
        
        playSet.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardlayout.show(cardpanel, "selec");
            }
        });
        
        Admin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardlayout.show(cardpanel, "admin");
            }
        });
        
        

        add(playSet, con);
        add(playRand, con);
        add(Admin,con);
    }

}
