/* Adapted from Try this 16-1
 *
 * A JavaFX-based comparison utility.
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import java.io.*;

public class JavaFXFileComp extends Application{

  TextField tfFirst;          // holds the first file name
  TextField tfSecond;         // holds the seconds file name

  Button btnComp;             // button to compare the files

  Label labFirst, labSecond;  // displays prompts
  Label labResult;            // displays results and error messages
  
  public static void main(String[] args){
    
    // start the JavaFX application by calling launch()
    launch(args);
  }

  // override the start() method
  public void start(Stage myStage){
    
    // give the stage a title
    myStage.setTitle("Compare Files");
    
    // use a FlowPane for the root node. In this case,
    // vertical and horizontal gaps of 10
    FlowPane rootNode = new FlowPane(10, 10);

    // center the controls in the scene
    rootNode.setAlignment(Pos.CENTER);

    // create a scene
    Scene myScene = new Scene(rootNode, 180, 180);
    
    // set the scene on the stage
    myStage.setScene(myScene);

    // create the text fields for the file names
    tfFirst = new TextField();
    tfSecond = new TextField();
    
    // set preferred column sizes
    tfFirst.setPrefColumnCount(12);
    tfSecond.setPrefColumnCount(12);
    
    // set prompts for file names
    tfFirst.setPromptText("Enter file name.");
    tfSecond.setPromptText("Enter file name.");
    
    // create the compare button
    btnComp = new Button("Compare");

    // create the labels
    labFirst = new Label("First file: ");
    labSecond = new Label("Second file: ");
    labResult = new Label("");
    
    // use lambda expressions to handle action events for the
    // text fields. These handlers simply fire the Compare button.
    tfFirst.setOnAction( (ae) -> btnComp.fire());
    tfSecond.setOnAction( (ae) -> btnComp.fire());
    
    // handle the action event for the compare button.
    btnComp.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        int i=0, j=0;

        // first, confirm that both file names have been entered
        if(tfFirst.getText().equals("")){
          labResult.setText("First file name missing.");
            return;
        }
        if(tfSecond.getText().equals("")){
          labResult.setText("Second file name missing.");
          return;
        }
    
        // compare files. Use try-with-resources to manage the files.
        try(FileInputStream f1 = new FileInputStream(tfFirst.getText());
            FileInputStream f2 = new FileInputStream(tfSecond.getText())){
      
          // check the contents of each file
          do{
            i = f1.read();
            j = f2.read();
            if(i != j){
              break;
            }
          } while(i != -1 && j != -1);
      
          if(i != j){
            labResult.setText("Files are not the same.");
          }
          else{
            labResult.setText("Files compare equal.");
          }
        }
        catch(IOException exc){
          labResult.setText("File Error Encountered");
        }
      }
    });

    // add controls to the scene graph
    rootNode.getChildren().addAll(labFirst, tfFirst, labSecond, tfSecond, btnComp, labResult);

    // show the stage and its scene
    myStage.show();
  }
}