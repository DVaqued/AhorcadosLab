package ahorcadopro;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

    CardLayout cardlayout;
    JPanel cardpanel;
    
    
    
    public Frame() {
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ahorcados");
        
        cardlayout = new CardLayout();
        cardpanel = new JPanel(cardlayout);
        
        Menu menu=new Menu(cardlayout, cardpanel);
        cardpanel.add(menu, "menu");
        
        Administrador admin=new Administrador(cardlayout, cardpanel);
        cardpanel.add(admin,"admin");
        
        SeleccionarPalabra selec=new SeleccionarPalabra(cardlayout, cardpanel);
        cardpanel.add(selec,"selec");
        
        add(cardpanel);
        
        cardlayout.show(cardpanel, "menu");
        
        setVisible(true);
    }

}
