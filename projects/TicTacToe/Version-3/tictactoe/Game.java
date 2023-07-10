/* My own Tic-Tac-Toe game.
 */
 
//package tictactoe;
 
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import java.util.*;

public class Game extends Application{

  private boolean isPlayer1 = true;
  private boolean finished = false;
  private boolean aiOn;
  private Board gameBoard = new Board();
  private Player player1 = new Player("X");
  private Player player2;
  Label comm, result, what2;
  Scene myScene, choiceScene, endScene;
  Stage myStageRef;

  public static void main(String[] args){

    // start the JavaFX application by calling launch()
    launch(args);
  }
  
  // override the start() method
  public void start(Stage myStage){
    
    // for use in different method, because myStage cannot be used outside this start method.
    myStageRef = myStage;

    // give the stage a title
    myStage.setTitle("Tic-Tac-Toe");

    // FIRST SCENE
    GridPane choiceNode = new GridPane();
    choiceNode.setAlignment(Pos.CENTER);
    // create scene
    choiceScene = new Scene(choiceNode, 340, 340);
    // button 2 players
    Button twoPlayers = new Button("2nd Player");
    // button AI player
    Button aiPlayer = new Button("Computer");
    // label choice
    Label what = new Label("Who do you want to play?");
    
    choiceNode.add(what, 0, 0, 1, 1);
    choiceNode.add(twoPlayers, 0, 1, 1, 1);
    choiceNode.add(aiPlayer, 1, 1, 1, 1);
    // set first scene
    myStage.setScene(choiceScene);

    // start choice handlers
    twoPlayers.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        aiOn = false;
        player2 = new Player("O");
        // set the scene on the stage
        myStage.setScene(myScene);
      }
    });
    aiPlayer.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        aiOn = true;
        player2 = new Player("O");
        // set the scene on the stage
        myStage.setScene(myScene);
      }
    });


    // MAIN SCENE
    // use a gridpane for the root node.
    GridPane rootNode = new GridPane();
    // center the controls in the scene
    rootNode.setAlignment(Pos.CENTER);
    // create a scene
    myScene = new Scene(rootNode, 340, 340);
    // communication label
    comm = new Label("Its the turn of player X");
    // hbox rows
    HBox hbox1 = new HBox();
    HBox hbox2 = new HBox();
    HBox hbox3 = new HBox();
    hbox1.getChildren().addAll(gameBoard.board[0][0], gameBoard.board[1][0], gameBoard.board[2][0]);
    hbox2.getChildren().addAll(gameBoard.board[0][1], gameBoard.board[1][1], gameBoard.board[2][1]);
    hbox3.getChildren().addAll(gameBoard.board[0][2], gameBoard.board[1][2], gameBoard.board[2][2]);
    // add the label and buttons to the scene graph
    rootNode.add(hbox1, 0, 0, 1, 1);
    rootNode.add(hbox2, 0, 1, 1, 1);
    rootNode.add(hbox3, 0, 2, 1, 1);
    rootNode.add(comm,0, 3, 1, 1);

    // handle the action events for the cell-buttons
    gameBoard.board[0][0].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[0][0]);
      }
    });
    gameBoard.board[0][1].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[0][1]);
      }
    });
    gameBoard.board[0][2].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[0][2]);
      }
    });
    gameBoard.board[1][0].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[1][0]);
      }
    });
    gameBoard.board[1][1].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[1][1]);
      }
    });
    gameBoard.board[1][2].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[1][2]);
      }
    });
    gameBoard.board[2][0].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[2][0]);
      }
    });
    gameBoard.board[2][1].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[2][1]);
      }
    });
    gameBoard.board[2][2].setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        buttonClicked(gameBoard.board[2][2]);
      }
    });
    
    // END SCENE
    GridPane endNode = new GridPane();
    endNode.setAlignment(Pos.CENTER);
    // create scene
    endScene = new Scene(endNode, 340, 340);
    // button 2 players
    Button replay = new Button("Play Again");
    // button AI player
    Button exit = new Button("Exit Game");
    // label result
    result = new Label();
    // label choice
    what2 = new Label("What do you want to do?");

    endNode.add(result, 0, 0, 1, 1);
    endNode.add(what2, 0, 1, 1, 1);
    endNode.add(replay, 0, 2, 1, 1);
    endNode.add(exit, 1, 2, 1, 1);


    // end choice handlers
    replay.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        // replay the game
        // go back to first scene
        myStage.setScene(choiceScene);
        // unset board
        gameBoard.unSetBoard();
        // unset finished
        finished = false;
      }
    });
    exit.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent ae){
        // exit program
        Platform.exit();
      }
    });

    // show the stage and its scene
    myStage.show();
  }
  
  public void buttonClicked(Cell x){
    String sym = isPlayer1 ? player1.getUserSymbol() : player2.getUserSymbol();                                 // shorthand if
    if(!finished){
      x.setText(sym);
      x.setState(sym);
      x.setDisable(true);
      if(gameBoard.checkBoard()){
        finished = true;
        // go to End Scene
        myStageRef.setScene(endScene);
        result.setText(sym + " has won!");
      }
      else if(gameBoard.isDraw()){
        finished = true;
        // go to End Scene
        myStageRef.setScene(endScene);
        result.setText("Game is a draw!");
      }
      else{
        isPlayer1 = !isPlayer1;
        sym = isPlayer1 ? player1.getUserSymbol() : player2.getUserSymbol();                                 // shorthand if
        comm.setText("Its the turn of player " + sym);
      if(aiOn && !isPlayer1){
          int xMove, yMove;
          Random r = new Random();
          // make a random position
          do{
          xMove = r.nextInt(3);
          yMove = r.nextInt(3);
          // make a new random position if this random position is already taken
          }while(gameBoard.board[xMove][yMove].isSet() );
          buttonClicked(gameBoard.board[xMove][yMove]);
        }
      }
    }
  }
}
