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
  private JTextField invoerVak, uitvoerVakJ, uitvoerVak10;
  private JLabel invoerLabel, uitvoerLabelJ, uitvoerLabel10;
  private JButton knop;
  
  public Paneel(){
    //Schakel lay-outmanager uit
    setLayout(null);
    //maak de tekstvakken
    invoerVak = new JTextField(10);
    invoerVak.setHorizontalAlignment(JTextField.RIGHT);

    uitvoerVakJ = new JTextField(10);
    uitvoerVakJ.setHorizontalAlignment(JTextField.RIGHT);
    uitvoerVakJ.setBackground(Color.YELLOW);
    
    uitvoerVak10 = new JTextField(10);
    uitvoerVak10.setHorizontalAlignment(JTextField.RIGHT);
    uitvoerVak10.setBackground(Color.GREEN);
    
    //maak de labels
    invoerLabel = new JLabel("Maandsalaris");
    uitvoerLabelJ = new JLabel("Jaarsalaris");
    uitvoerLabel10 = new JLabel("Salaris in 10 jaar");
    
    //maak de knop
    knop = new JButton("Bereken");
    knop.addActionListener(new KnopBereken() );
    
    //toevoegen componenten
    add(invoerLabel);
    add(invoerVak);
    add(uitvoerLabelJ);
    add(uitvoerVakJ);
    add(uitvoerLabel10);
    add(uitvoerVak10);
    add(knop);

    //we bepalen zelf de plaats en afmeting van de componenten
    invoerLabel.setBounds( 80, 50,120, 20);
    invoerVak.setBounds(200, 50, 90, 20);
    uitvoerLabelJ.setBounds( 80, 80,120, 20);
    uitvoerVakJ.setBounds(200, 80, 90, 20);
    uitvoerLabel10.setBounds( 80,110,120, 20);
    uitvoerVak10.setBounds(200,110, 90, 20);
    knop.setBounds(300, 50, 100, 20);
  }

  //inwendige class die de actie definieert voor knop
  class KnopBereken implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String maand = invoerVak.getText();
      int mnd = Integer.parseInt(maand);
      uitvoerVakJ.setText(Integer.toString(mnd*12));
      uitvoerVak10.setText(Integer.toString(mnd*120));
    }
  }

}


// main class
public class W3d13 extends JFrame{

  public static void main(String[] args){

    JFrame frame = new W3d13();
    frame.setSize( 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Voorbeeld");
    JPanel w3d13paneel = new Paneel();
    frame.setContentPane(w3d13paneel);
    frame.setVisible(true);
  }
}