/* Maak een programma dat een leeftijd opslaat in de variabele ‘leeftijd’. 
 * Vervolgens maak je een if-statement dat controleert of de leeftijd gelijk 
 * aan of hoger is dan 18. Als de leeftijd 18 of hoger is (dit stel je zelf in), 
 * dan verschijnt de melding “Je mag een biertje of wijntje drinken!”.
 */

//juiste import
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
 
 
//main class
public class w4d16 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new w4d16();
    frame.setSize( 600, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening: Leeftijd" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

// Paneel
class Paneel extends JPanel {
  private int leeftijd;
  private JLabel leeftLab;
  private JTextField leeftText, uitvoer;

  //constructor
  public Paneel(){
    //initialiseer de visuele elementen
    leeftText = new JTextField(10);
    leeftText.addActionListener( new leeftijdHandler() );
    leeftText.setHorizontalAlignment( JTextField.RIGHT );
    
    uitvoer = new JTextField(30);
    uitvoer.setHorizontalAlignment(JTextField.RIGHT);
    uitvoer.setBackground(Color.YELLOW);
    
    leeftLab = new JLabel("Wat is uw leeftijd?");
    
    //voeg componenten toe aan het paneel
    add(leeftLab);     add(leeftText);      add(uitvoer);

  }
  
  //de actionListener
  class leeftijdHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String lft = leeftText.getText();
      int leeftijd = Integer.parseInt(lft);
      if(leeftijd>=18){
        uitvoer.setText("Je mag een biertje of wijntje drinken!");
      }
      else{
        uitvoer.setText("Je mag nog geen biertje of wijntje drinken!");
      }
    }
  }
}