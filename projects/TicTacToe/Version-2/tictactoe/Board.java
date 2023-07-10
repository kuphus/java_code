//package tictactoe;

public class Board{
  public Cell[][] board;

  // constructor
  public Board(){
    board = new Cell[3][3];
    for(int x = 0; x<3; x++){
      for(int y = 0; y<3; y++){
        //creates 9 cells with empty states
        board[x][y]= new Cell();
      }
    }
  }

  // checks if cells at row Y have the same state
  boolean checkRow(int y){
    //isSet check for all cells
    for(int x = 0; x<3; x++){
      if(!board[x][y].isSet()){
        return false;
      }
    }
    // if all cells are set, check for win-condition
    if(  board[0][y].getState().equals( board[1][y].getState() ) && board[1][y].getState().equals(board[2][y].getState())    ){
      return true;
    }
    return false;
  }

  // checks if cells at column X have the same state
  boolean checkColumn(int x){
    // isSet check for all cells
    for(int y = 0; y<3; y++){
      if(!board[x][y].isSet()){
        return false;
      }
    }
    // if all cells are set, check for win-condition
    if(  board[x][0].getState().equals( board[x][1].getState() ) && board[x][1].getState().equals(board[x][2].getState())    ){
      return true;
    }
    return false;
  }

  boolean checkDiagonals(){
    boolean check1 = true;
    boolean check2 = true;
    // diagonal 1 (top left, bottom right) isSet check
    for(int i = 0; i<3; i++){
      if(!board[i][i].isSet()){
        check1 = false;
      }
    }
    // if all cells are set, check for win-condition
    if(check1){
      if( board[0][0].getState().equals( board[1][1].getState() ) && board[1][1].getState().equals(board[2][2].getState())    ){
        return check1;
      }
    }
    // diagonal 2 (bottom left, top right) isSet check (only if diagonal 1 didn't have the win-condition
    if(!board[0][2].isSet() || !board[1][1].isSet() || !board[2][0].isSet()){
      check2 = false;
    }

    // if all cells are set, check for win-condition
    if(check2){
      if( board[0][2].getState().equals( board[1][1].getState() ) && board[1][1].getState().equals(board[2][0].getState())    ){
        return check2;
      }
    }
    // no diagonal had a win-condition
    return false;
  }

  public boolean checkBoard(){
    if(checkRow(0) || checkRow(1) || checkRow(2) || checkColumn(0) || checkColumn(1) || checkColumn(2) || checkDiagonals()){
      return true;
    }
    return false;
  }
  
  public boolean isDraw(){
    boolean allSet = true;
    // isSet check for all cells
    for(int x = 0; x<3; x++){
      for(int y = 0; y<3; y++){
        if(!board[x][y].isSet()){
          allSet = false;
        }
      }
    }
    if(allSet && !checkBoard()){
      return true;
    }
    return false;
  }

  /*nog even niet implementeren
  void printBoard(){
    for(int x = 0; x<3; x++){
      for(int y = 0; y<3; y++){
        System.out.print(board[x][y].getState;
      }
      System.out.print("\n");
    }
  }
  */
}