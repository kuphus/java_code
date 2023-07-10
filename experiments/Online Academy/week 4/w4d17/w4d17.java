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
public class w4d17 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new w4d17();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening: examen gehaald?" );
    frame.setContentPane( new Paneel(5.49) );
    frame.setVisible( true );
  }
}

// Paneel
class Paneel extends JPanel {
  private double cijfer;

  public Paneel(double c){
    cijfer = c;
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //Zet de waarden op het scherm:
    if(cijfer>=5.5){
      g.drawString("Je hebt een voldoende!", 40, 40);
    }
    else{
      g.drawString("Je hebt een onvoldoende!", 40, 40);
    }
  }
}