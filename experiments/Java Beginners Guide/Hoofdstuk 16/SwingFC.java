/* Try this 16-1
 *
 * A swing-based comparison utility.
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SwingFC implements ActionListener{
  
  JTextField jtfFirst;          // holds the first file name
  JTextField jtfSecond;         // holds the seconds file name
  
  JButton jbtnComp;             // button to compare the files
  
  JLabel jlabFirst, jlabSecond; // displays prompts
  JLabel jlabResult;            // displays results and error messages
  
  SwingFC(){
    
    // create a new JFrame container
    JFrame jfrm = new JFrame("Compare Files");
    
    // specify flowlayout for the layout manager
    jfrm.setLayout(new FlowLayout());
    
    // give the grame an initial size
    jfrm.setSize(200, 190);
    
    // terminate the program when the user closes the application
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // create the text fields for the file names
    jtfFirst = new JTextField(14);
    jtfSecond = new JTextField(14);
    
    // set the action commands for the text fields
    jtfFirst.setActionCommand("fileA");
    jtfSecond.setActionCommand("fileB");
    
    // create the compare button
    JButton jbtnComp = new JButton("Compare");
    
    // add action listener for the compare button
    jbtnComp.addActionListener(this);
    
    // create the labels
    jlabFirst = new JLabel("First file: ");
    jlabSecond = new JLabel("Second file: ");
    jlabResult = new JLabel("");
    
    // add the components to the content pane
    jfrm.add(jlabFirst);
    jfrm.add(jtfFirst);
    jfrm.add(jlabSecond);
    jfrm.add(jtfSecond);
    jfrm.add(jbtnComp);
    jfrm.add(jlabResult);
    
    // display the frame
    jfrm.setVisible(true);
  }

  // compare the files when the compare button is pressed
  public void actionPerformed(ActionEvent ae){
    int i=0, j=0;
    
    // first, confirm that both file names have been entered
    if(jtfFirst.getText().equals("")){
      jlabResult.setText("First file name missing.");
      return;
    }
    if(jtfSecond.getText().equals("")){
      jlabResult.setText("Second file name missing.");
      return;
    }
    
    // compare files. Use try-with-resources to manage the files.
    try(FileInputStream f1 = new FileInputStream(jtfFirst.getText());
        FileInputStream f2 = new FileInputStream(jtfSecond.getText())){
      
      // check the contents of each file
      do{
        i = f1.read();
        j = f2.read();
        if(i != j){
          break;
        }
      } while(i != -1 && j != -1);
      
      if(i != j){
        jlabResult.setText("Files are not the same.");
      }
      else{
        jlabResult.setText("Files compare equal.");
      }
    }
    catch(IOException exc){
      jlabResult.setText("File Error");
    }
  }
  
  public static void main(String[] args){
    
    // create the frame on the event dispatching thread
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new SwingFC();
      }
    });
  }

}