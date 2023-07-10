//gebruik JLabels en reken het jaarsalaris uit


//importeer de juiste libraries voor de visuele elementen
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
//importeer de event afhandeling libraries
import java.awt.event.*;
// de Graphics class komt uit de java.awt libraries
import java.awt.*;


//paneel class
class Paneel extends JPanel{
  private JTextField invoerVak, uitvoerVak;
  private JLabel invoerLabel, uitvoerLabel;
  private JButton knop;
  
  public Paneel(){
    //maak de tekstvakken
    invoerVak = new JTextField(10);
    uitvoerVak = new JTextField(10);
    
    //maak de labels
    invoerLabel = new JLabel("Maandsalaris");
    uitvoerLabel = new JLabel("Jaarsalaris");
    
    //maak de knop
    knop = new JButton("Bereken");
    
    knop.addActionListener(new KnopBereken() );
    
    add(invoerLabel);
    add(invoerVak);
    add(uitvoerLabel);
    add(uitvoerVak);
    add(knop);
  }

  //inwendige class die de actie definieert voor knop
  class KnopBereken implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String maand = invoerVak.getText();
      int mnd = Integer.parseInt(maand);
      uitvoerVak.setText(Integer.toString(mnd*12));
    }
  }

}


// main class
public class W3d12 extends JFrame{

  public static void main(String[] args){

    JFrame frame = new W3d12();
    frame.setSize( 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Voorbeeld");
    JPanel w3d12paneel = new Paneel();
    frame.setContentPane(w3d12paneel);
    frame.setVisible(true);
  }
}