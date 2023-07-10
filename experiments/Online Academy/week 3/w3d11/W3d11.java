//importeer de juiste libraries voor de visuele elementen
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
// de Graphics class komt uit de java.awt libraries
import java.awt.*;

class Paneel extends JPanel{
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(170, 50, 60,160);
    g.fillRect(195,210, 10,120);
    
    g.setColor(Color.RED);
    g.fillOval(180, 60, 40, 40);
    
    g.setColor(Color.ORANGE);
    g.fillOval(180,110, 40, 40);
    
    g.setColor(Color.GREEN);
    g.fillOval(180,160, 40, 40);

  }
}

// main class
public class W3d11 extends JFrame{

  public static void main(String[] args){

    JFrame frame = new W3d11();
    frame.setSize( 600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Voorbeeld");
    JPanel w3d11paneel = new Paneel();
    frame.setContentPane(w3d11paneel);
    frame.setVisible(true);
  }
}