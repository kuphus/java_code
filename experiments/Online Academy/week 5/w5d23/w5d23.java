/* Maak een programma dat de temperatuur bijhoudt en laat oplopen tot 30 graden.
 * De temperatuur is in het begin 15 graden. Zolang de temperatuur onder de 24 graden 
 * is, krijg je de melding “Het is nu … graden”. Bij 24 graden begint het toch wel 
 * een beetje warm te worden en geeft het programma de melding “Het is boven de 24 graden!”. 
 * Maak uiteraard gebruik van de while-loop.
 */

//juiste import
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
 
 
//main class
public class w5d23 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new w5d23();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening: temperaturen" );
    frame.setContentPane( new Paneel(15) );
    frame.setVisible( true );
  }
}

// Paneel
class Paneel extends JPanel {
  private int temperatuur;

  public Paneel(int t){
    temperatuur = t;
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //Zet de waarden op het scherm:      //overigens is de initializer niet nodig aangezien temperatuur al bestaat en een waarde heeft
    for(; temperatuur < 30; temperatuur += 2){

      if(temperatuur < 24){
        System.out.println("Het is nu " + temperatuur + " graden");
        repaint();
        g.drawString("Het is nu " + temperatuur + " graden", 40, 40);
      }
      else if(temperatuur <30){
        System.out.println("Het is boven de 24 graden!");
        repaint();
        g.drawString("Het is boven de 24 graden!", 40, 40);
      }
      else{
        System.out.println("Er gaat iets mis!");
        repaint();
        g.drawString("Er gaat iets mis!", 40, 40);
      }

    }
  }
}