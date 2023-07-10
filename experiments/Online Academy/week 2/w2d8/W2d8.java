//nieuw panel


//importeer de juiste libraries voor de visuele elementen
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
// de Graphics class komt uit de java.awt libraries
import java.awt.*;

//paneel class
class Paneel extends JPanel{
  private int leeftijd;
  private String vNaam, aNaam, datum;

  public Paneel(){
    leeftijd = 35;
    vNaam = "Kevin";
    aNaam = "Up";
    datum = "19-05-1983";
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //zet de waarden op het scherm:
    //de eerste waarde is naar rechts, de tweede naar beneden
    g.drawString("Ik ben " + vNaam + " " + aNaam + " en ben " + leeftijd + " jaar oud en geboren op " + datum, 140, 140);
  }
}


// main class
public class W2d8 extends JFrame{
  
  public static void main(String[] args){
    
    JFrame frame = new W2d8();
    frame.setSize( 600, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Voorbeeld");
    JPanel w2d8paneel = new Paneel();
    frame.setContentPane(w2d8paneel);
    frame.setVisible(true);
  }
}