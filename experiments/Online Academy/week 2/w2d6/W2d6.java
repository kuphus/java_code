/*  Maak eens het programma na dat vandaag als voorbeeld is gebruikt.
 */

//importeer de juiste libraries voor de visuele elementen
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//importeer de event afhandeling libraries
import java.awt.event.*;

//Paneel class
class Paneel extends JPanel{
  private JButton knop;
  private JTextField tekstvak;
  
  
  //constructor
  public Paneel(){
    knop = new JButton("Klik");
    tekstvak = new JTextField(10);

    knop.addActionListener(new KnopKlikken() );

    add(knop);
    add(tekstvak);
  }
  
  //inwendige class die de actie definieert voor knop
  class KnopKlikken implements ActionListener{
    public void actionPerformed(ActionEvent e){
      tekstvak.setText("Ik heb geklikt!");
    }
  }
}

// main class
public class W2d6 extends JFrame{
  
  public static void main(String[] args){
    
    JFrame frame = new W2d6();
    frame.setSize( 300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Test");
    JPanel w2d6paneel = new Paneel();
    frame.setContentPane(w2d6paneel);
    frame.setVisible(true);
  }
}