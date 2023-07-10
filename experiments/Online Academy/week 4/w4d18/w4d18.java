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
public class w4d18 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new w4d18();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening: kleuren kiezen" );
    frame.setContentPane( new Paneel("groen") );
    frame.setVisible( true );
  }
}

// Paneel
class Paneel extends JPanel {
  private String kleur;

  public Paneel(String k){
    kleur = k;
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //Zet de waarden op het scherm:
    if(kleur == "blauw"){
      g.drawString("Je koos voor blauw!", 40, 40);
    }
    else if(kleur == "rood"){
      g.drawString("Je koos voor rood!", 40, 40);
    }
    else if(kleur == "groen"){
      g.drawString("Je koos voor groen!", 40, 40);
    }
    else if(kleur == "zwart"){
      g.drawString("Je koos voor zwart!", 40, 40);
    }
    else{
      g.drawString("Geen goede kleur ingevoerd!", 40, 40);
    }
  }
}