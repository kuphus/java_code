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
public class w4d19 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new w4d19();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening: leeftijd en geslacht" );
    frame.setContentPane( new Paneel("man", 9) );
    frame.setVisible( true );
  }
}

// Paneel
class Paneel extends JPanel {
  private String geslacht;
  private int leeftijd;

  public Paneel(String g, int l){
    geslacht = g;
    leeftijd = l;
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //Zet de waarden op het scherm:
    if(geslacht.equals("man") || geslacht.equals("m") && leeftijd < 18){
      g.drawString("Jij mag nog geen alcohol drinken!", 40, 40);
    }
    else if(geslacht.equals("vrouw") || geslacht.equals("v") && leeftijd < 18){
      g.drawString("Jij mag net aan een Breezertje!", 40, 40);
    }
    else if(geslacht.equals("man") || geslacht.equals("m") && leeftijd >= 18){
      g.drawString("Jij mag een biertje!", 40, 40);
    }
    else if(geslacht.equals("vrouw") || geslacht.equals("v") && leeftijd >= 18){
      g.drawString("Jij mag een wijntje!", 40, 40);
    }
    else{
      g.drawString("Verkeerde invoer!", 40, 40);
    }
  }
}