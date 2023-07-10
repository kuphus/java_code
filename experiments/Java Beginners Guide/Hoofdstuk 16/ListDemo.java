// Demonstrate multiple selection in a JList.

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ListDemo implements ListSelectionListener{
  
  JList<String> jlst;
  JLabel jlab;
  JScrollPane jscrlp;
  
  // Create an array of names.
  String[] names = { "Sherry", "Jon", "Rachel",
                     "Sasha", "Josselyn", "Randy",
                     "Tom", "Mary", "Ken",
                     "Andrew", "Matt", "Todd" };
  
  ListDemo(){
    
    // create a new JFrame container
    JFrame jfrm = new JFrame("Jlist Demo");
    
    // specify a flow layout
    jfrm.setLayout(new FlowLayout());
    
    // give the frame an initial size
    jfrm.setSize(200, 160);
    
    // terminate the program when the user closes the application
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // create a JList
    jlst = new JList<String>(names);
    
    // by removing the following line, multiple selection 
    //(which is the default behavior of a JList) will be used.
  //jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  
    // add list to a scroll pane
    jscrlp = new JScrollPane(jlst);
    
    // set the preferred size of the scroll pane
    jscrlp.setPreferredSize(new Dimension(120, 90));
    
    // make a label that displays the selection
    jlab = new JLabel("Please choose a name");
    
    // add list selection handler
    jlst.addListSelectionListener(this);
    
    // add the list and label to the content pane
    jfrm.add(jscrlp);
    jfrm.add(jlab);
    
    // display the frame
    jfrm.setVisible(true);
  }
  
  // handle list selection events
  public void valueChanged(ListSelectionEvent le){
    
    // get the indices of the changed item
    int[] indices = jlst.getSelectedIndices();
    
    // display the selections, if one or more items were selected
    if(indices.length !=0){
      String who = "";
      
      // construct a string of the name
      for(int i: indices){
        who += names[i] + " ";
      }
      
      jlab.setText("Current selections: " + who);
    }
    else{    // otherwise, repromt
      jlab.setText("Please choose a name");
    }
  }
  
  public static void main(String[] args){
    
    // create the frame on the event dispatching thread
    SwingUtilities.invokeLater(new Runnable() {
      public void run(){
        new ListDemo();
      }
    });
  }
}