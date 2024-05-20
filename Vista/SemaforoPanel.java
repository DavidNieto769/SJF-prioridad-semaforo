package Vista;

import javax.swing.*;

import java.awt.*;


public class SemaforoPanel extends JPanel {



    public SemaforoPanel(JFrame window, String title) {
        super();
        JLabel text = new JLabel();
        add(text);
        setBounds(0, 0,50,50);
        setBorder(BorderFactory.createTitledBorder(title));
        setLayout(new BorderLayout());
        setVisible(true);
        setBackground(Color.red);
    }

    public void cambiarSemaforo(Color color){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    setBackground(color);
                    revalidate();
                    repaint();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        /**
        setBackground(color);
        System.out.println(color.toString());
        this.revalidate();
        this.repaint();

        if(this.getBackground()== Color.red){
            System.out.println("cambió a verde");
            this.setBackground(Color.green);
        }else{
            System.out.println("cambió a rojo");
            this.setBackground(Color.red);
        }**/

    }
}
