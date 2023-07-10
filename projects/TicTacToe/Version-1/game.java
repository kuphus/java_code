/* My own Tic-Tac-Toe game.
 */
 
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class game extends Application{

  private boolean isPlayer1 = true;
  private boolean finished = false;
  private board gameBoard = new board();
  private player player1 = new player("X");
  private player player2 = new player("O");
  Label comm;

  public static void main(String[] args){

    //start the JavaFX application by calling launch()
    launch(args);
  }
  
  // override the start() method
  public void start(Stage myStage){

    // give the stage a title
    myStage.setTitle("Tic-Tac-Toe");
    // use a flowpane for the root node. In this case,
    // vertical and horizontal gaps of 10
    GridPane rootNode = new GridPane();

    // center the controls in the scene
    rootNode.setAlignment(Pos.CENTER);
    // create a scene
    Scene myScene = new Scene(rootNode, 340, 340);
    // set the scene on the stage
    myStage.setScene(myScene);
    
    //communication label
    comm = new Label("Its the turn of player X");

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

    //hbox rows
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

    //show the stage and its scene
    myStage.show();
  }
  
  public void buttonClicked(cell x){
    String sym = isPlayer1 ? player1.getUserSymbol() : player2.getUserSymbol();                                 //shorthand if
    if(!finished){
      x.setText(sym);
      x.setState(sym);
      x.setDisable(true);
      if(gameBoard.checkBoard()){
        finished = true;
        comm.setText(sym + " has won!");
      }
      else if(gameBoard.isDraw()){
        finished = true;
        comm.setText("Game is a draw!");
      }
      else{
        isPlayer1 = !isPlayer1;
        sym = isPlayer1 ? player1.getUserSymbol() : player2.getUserSymbol();                                 //shorthand if
        comm.setText("Its the turn of player " + sym);
      }
    }
  }
}
