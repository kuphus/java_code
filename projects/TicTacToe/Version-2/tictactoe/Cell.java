//package tictactoe;

import javafx.scene.control.Button;

public class Cell extends Button{
  //int length;                   // length of all sides
  private String state;           // X, O, or unset ""
  
  // constructor
  public Cell(){
    super();                      // for super constructor
    state = "";
    setPrefWidth(100);            // from super class
    setPrefHeight(100);           // from super class
    // set button style using CSS
    setStyle("-fx-font-size: 45; -fx-font-weight: bold;");  // from super class
  }

  public boolean isSet(){
    if(!state.equals("")){
      return true;
    }
    return false;
  }

  public void setState(String x){
    state = x;
  }

  public String getState(){
    return state;
  }
}