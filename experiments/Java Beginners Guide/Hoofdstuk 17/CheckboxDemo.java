// demonstrate checkboxes  try this 17-1

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;     // voor centreren controls in de FlowPane

public class CheckboxDemo extends Application{
  
  CheckBox cbSmartphone;
  CheckBox cbTablet;
  CheckBox cbNotebook;
  CheckBox cbDesktop;
  
  Label response;
  Label selected;
  
  String computers;
  
  public static void main(String[] args){
    
    // start the JavaFX application by calling launch()
    launch(args);
  }
  
  // override the start() method
  public void start(Stage myStage){
    
    // give the stage a title
    myStage.setTitle("Demonstrate Check Boxes");
    
    // use a vertical FlowPane for the root node. In this case
    // vertical and horizontal gaps of 10.
    FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
    
    // center the controls in the scene
    rootNode.setAlignment(Pos.CENTER);
    
    // create a scene
    Scene myScene = new Scene(rootNode, 230, 200);
    
    // set the scene on the stage
    myStage.setScene(myScene);
    
    Label heading = new Label("What computers do you own?");
    
    // create a label that will report the state change of a check box
    response = new Label("");
    
    // create a label that will report all selected check boxes
    selected = new Label("");
    
    // create the check boxes
    cbSmartphone = new CheckBox("Smartphone");
    cbTablet = new CheckBox("Tablet");
    cbNotebook = new CheckBox("Notebook");
    cbDesktop = new CheckBox("Desktop");
    
    // allow indeterminate state for smartphone
    cbSmartphone.setAllowIndeterminate(true);
    
    // handle action events for the check boxes
    cbSmartphone.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        if(cbSmartphone.isIndeterminate()){
          response.setText("Smartphone state is indeterminate.");
        }
        else if(cbSmartphone.isSelected()){
          response.setText("Smartphone was just selected.");
        }
        else{
          response.setText("Smartphone was just cleared.");
        }
        showAll();
      }
    });
    cbTablet.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        if(cbTablet.isSelected()){
          response.setText("Tablet was just selected.");
        }
        else{
          response.setText("Tablet was just cleared.");
        }
        showAll();
      }
    });
    cbNotebook.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        if(cbNotebook.isSelected()){
          response.setText("Notebook was just selected.");
        }
        else{
          response.setText("Notebook was just cleared.");
        }
        showAll();
      }
    });
    cbDesktop.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        if(cbDesktop.isSelected()){
          response.setText("Desktop was just selected.");
        }
        else{
          response.setText("Desktop was just cleared.");
        }
        showAll();
      }
    });
    
    // add controls to the scene graph
    rootNode.getChildren().addAll(heading, cbSmartphone, cbTablet,
                                  cbNotebook, cbDesktop, response, selected);
    
    // show the stage and its scene
    myStage.show();
    
    showAll();
  }
  
  // update and show the selections
  void showAll(){
    computers = "";
    if(cbSmartphone.isSelected()){
      computers = "Smartphone ";
    }
    if(cbTablet.isSelected()){
      computers += "Tablet ";
    }
    if(cbNotebook.isSelected()){
      computers += "Notebook ";
    }
    if(cbDesktop.isSelected()){
      computers += "Desktop ";
    }
    
    selected.setText("Computers selected: " + computers);
  }
}
