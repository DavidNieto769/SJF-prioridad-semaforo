package Vista;

import javax.swing.*;

import java.awt.*;

public class SemaforoPanel extends JPanel {



    public SemaforoPanel(JFrame window, String title) {
        setBounds(0, 0,50,50);
        setBorder(BorderFactory.createTitledBorder(title));
        setLayout(new BorderLayout());
        setVisible(true);
        setBackground(Color.red);
    }

    public void cambiarSemaforo(boolean estado){

        if(estado){
            System.out.println("cambió a verde");
            this.setBackground(Color.green);
        }else{
            System.out.println("cambió a rojo");
            this.setBackground(Color.red);
        }
        /**
        if(this.getBackground()== Color.red){
            System.out.println("cambió a verde");
            this.setBackground(Color.green);
        }else{
            System.out.println("cambió a rojo");
            this.setBackground(Color.red);
        }**/

    }
}
