// Demonstrate Platform.exit()

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class JavaFXEventDemo extends Application{
  
  Label response;
  
  public static void main(String[] args){
    
    //start the JavaFX application by calling launch()
    launch(args);
  }
  
  // override the start() method
  public void start(Stage myStage){
    
    // give the stage a title
    myStage.setTitle("Use Platform.exit().");
    
    // use a flowpane for the root node. In this case,
    // vertical and horizontal gaps of 10
    FlowPane rootNode = new FlowPane(10, 10);
    
    // center the controls in the scene
    rootNode.setAlignment(Pos.CENTER);
    
    // create a scene
    Scene myScene = new Scene(rootNode, 300, 100);
    
    // set the scene on the stage
    myStage.setScene(myScene);
    
    // create a label
    response = new Label("Push a Button");
    
    // create two push buttons
    Button btnRun = new Button("Run");
    Button btnExit = new Button("Exit");
    
    // handle the action events for the Run button
    btnRun.setOnAction((ae) -> response.setText("You pressed Run."));
    
    // handle the action events for the Exit button
    btnExit.setOnAction((ae) -> Platform.exit());
    
    // add the label and buttons to the scene graph
    rootNode.getChildren().addAll(btnRun, btnExit, response);
    
    //show the stage and its scene
    myStage.show();
  }
}