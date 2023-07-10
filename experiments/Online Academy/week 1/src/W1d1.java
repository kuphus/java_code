package w1d1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
   
public class W1d1 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new W1d1();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening 0605" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

// Het paneel
class Paneel extends JPanel {
  private Tijdstip tijdstip;
  private JButton volgendUurKnop, volgendeMinuutKnop, volgendeSecondeKnop;
    
  public Paneel() {
    setBackground( Color.WHITE );
    
    // Maak een instantie van Tijdstip
    tijdstip = new Tijdstip( 22, 55, 43 );
    
    // De knoppen
    volgendUurKnop = new JButton( "Uur++" );
    volgendeMinuutKnop = new JButton( "Minuut++" );
    volgendeSecondeKnop = new JButton( "Seconde++" );
    
    volgendUurKnop.addActionListener( new VolgendUurKnopHandler() );
    volgendeMinuutKnop.addActionListener( new VolgendeMinuutKnopHandler() );
    volgendeSecondeKnop.addActionListener( new VolgendeSecondeKnopHandler() );
    
    add( volgendUurKnop );
    add( volgendeMinuutKnop );
    add( volgendeSecondeKnop );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawString( "Het tijdstip is " + tijdstip, 120, 100 );
  }
  
  class VolgendUurKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      tijdstip.volgendUur();
      repaint();
    }
  }
  
  class VolgendeMinuutKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      tijdstip.volgendeMinuut();
      repaint();
    }
  }
  
  class VolgendeSecondeKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      tijdstip.volgendeSeconde();
      repaint();
    }
  }    
}

