/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w3d14;  //moet gelijk zijn aan de directory!!!

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;  
   
public class w3d4 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new w3d4();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening: Uitgebreide kassa" );
    frame.setContentPane( new KassaPaneel() );
    frame.setVisible( true );
  }
}


// Paneel voor een kassa
class KassaPaneel extends JPanel {
  private JTextField bedragVak, subtotaalVak,
                     btwVak,totaalExBTWVak, totaalVak;
  private JLabel bedragLabel, subtotaalLabel, 
                 btwLabel, totaalExBTWLabel, totaalLabel;
  private JButton totaalKnop, resetKnop;
  private Kassa kassa;
  
  public KassaPaneel() {
    // Kies GridLayout
    setLayout( new GridLayout( 5, 3, 10, 10 ) );
    Border border = 
           BorderFactory.createEmptyBorder( 5, 5, 5, 5 );
    setBorder( border );

    // Maak een kassa:
    kassa = new Kassa();
    
    // Maak de tekstvakken
    bedragVak = new JTextField( 10 );
    bedragVak.addActionListener( new InvoerVakHandler() );
    bedragVak.setHorizontalAlignment( JTextField.RIGHT );

    subtotaalVak = new JTextField( 10 );
    subtotaalVak.setBackground( Color.YELLOW );
    
    btwVak = new JTextField( 10 );
    totaalExBTWVak = new JTextField( 10 );
    totaalVak = new JTextField( 10 );
      
    // Zorg dat gebruiker niet kan wijzigen en lijn rechts uit
    subtotaalVak.setEditable( false );
    subtotaalVak.setHorizontalAlignment( JTextField.RIGHT );    

    btwVak.setEditable( false );
    btwVak.setHorizontalAlignment( JTextField.RIGHT );    

    totaalExBTWVak.setEditable( false );
    totaalExBTWVak.setHorizontalAlignment( JTextField.RIGHT );    

    totaalVak.setEditable( false );
    totaalVak.setHorizontalAlignment( JTextField.RIGHT );    
    
    // Maak de knoppen
    totaalKnop = new JButton( "Totaal" );
    totaalKnop.addActionListener( new TotaalKnopHandler() );
    
    resetKnop = new JButton( "Reset" );
    resetKnop.addActionListener( new ResetKnopHandler() );
    
    // Maak de labels
    bedragLabel = new JLabel( "Voer bedrag in" );
    subtotaalLabel = new JLabel( "Subtotaal" );
    btwLabel = new JLabel( "btw" );
    totaalExBTWLabel = new JLabel( "Totaal ex btw" );
    totaalLabel = new JLabel( "Totaal" );
    
    // Voeg de componenten toe aan het paneel
    add( bedragLabel);       add( bedragVak );      add( new JLabel( "" ) );
    add( subtotaalLabel );   add( subtotaalVak );   add( totaalKnop );
    add( btwLabel );         add( btwVak );         add( new JLabel( "" ) );
    add( totaalExBTWLabel ); add( totaalExBTWVak ); add( new JLabel( "" ) );
    add( totaalLabel );      add( totaalVak );      add( resetKnop );
  }

  class InvoerVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = bedragVak.getText();
      double invoerBedrag = Double.parseDouble( invoer );

      kassa.telOp( invoerBedrag );
      double st = kassa.getSubtotaal();
      
      // Formatteer de uitvoer
      subtotaalVak.setText( String.format( "%.2f", st ) );
      
      // Maak invoervak leeg
      bedragVak.setText( "" );
    }
  }
  
  class TotaalKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      btwVak.setText( String.format( "%.2f", kassa.berekenBTW() ) );
      totaalExBTWVak.setText( String.format( "%.2f", kassa.berekenSubtotaalExBTW() ) );
      totaalVak.setText( String.format( "%.2f", kassa.getSubtotaal() ) );
    }
  }
  
  class ResetKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      subtotaalVak.setText( "" );
      btwVak.setText( "" );
      totaalExBTWVak.setText( "" );
      totaalVak.setText( "" );
      kassa.reset();
      
    }
  }
}
