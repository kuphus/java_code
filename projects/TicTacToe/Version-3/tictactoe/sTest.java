import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class sTest extends Application{
  
  Scene myScene, choiceScene;

  public static void main(String[] args){
    //start the JavaFX application by calling launch()
    launch(args);
  }
  
  // override the start() method
  public void start(Stage myStage){

    // give the stage a title
    myStage.setTitle("Tic-Tac-Toe");

    //button 2 players
    Button twoPlayers = new Button("2 Players");
    //button AI player
    Button aiPlayer = new Button("AI Player");
    // label choice
    Label what = new Label("How do you want to play?");
    twoPlayers.setOnAction(e -> myStage.setScene(myScene));
    aiPlayer.setOnAction(e -> myStage.setScene(myScene));

    // first scene /layout
    GridPane choiceNode = new GridPane();
    choiceNode.setAlignment(Pos.CENTER);
    //create scene
    choiceScene = new Scene(choiceNode, 340, 340);

    choiceNode.add(what, 0, 0, 1, 1);
    choiceNode.add(twoPlayers, 0, 1, 1, 1);
    choiceNode.add(aiPlayer, 1, 1, 1, 1);
   
   // use a gridpane for the root node.
    GridPane rootNode = new GridPane();
    // center the controls in the scene
    rootNode.setAlignment(Pos.CENTER);
    // create a scene
    myScene = new Scene(rootNode, 340, 340);



    myStage.setScene(choiceScene);

    //show the stage and its scene
    myStage.show();
  }
}