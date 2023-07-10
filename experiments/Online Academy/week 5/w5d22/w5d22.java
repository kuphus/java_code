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
public class w5d22 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new w5d22();
    frame.setSize( 800, 400 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening: temperaturen" );
    Paneel paneel = new Paneel(15);
    frame.setContentPane( paneel );
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
    int x = 40;
    //Zet de waarden op het scherm:
    while(temperatuur < 30){
      if(temperatuur < 24){
        System.out.println("Het is nu " + temperatuur + " graden");
        g.drawString("Het is nu " + temperatuur + " graden", 40, x);
      }
      else if(temperatuur <30){
        System.out.println("Het is boven de 24 graden!");
        g.drawString("Het is boven de 24 graden!", 40, x);
      }
      else{
        System.out.println("Er gaat iets mis!");
        g.drawString("Er gaat iets mis!", 40, x);
      }
      temperatuur++;
      x += 20;
    }
  }
}