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
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening: Uitgebreide kassa" );
    frame.setContentPane( new Paneel(35) );
    frame.setVisible( true );
  }
}

// Paneel
class Paneel extends JPanel {
  private int leeftijd;

  public Paneel(int x){
    leeftijd = x;
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //Zet de waarden op het scherm:
    if(leeftijd>=18){
      g.drawString("Je mag een biertje of wijntje drinken!", 40, 40);
    }
  }
}