import javafx.scene.control.Button;

public class cell extends Button{
  //int length;                //length of all sides
  private String state;              // X, O, or unset ""
  
  //constructor
  public cell(){
    super();
    state = "";
    super.setPrefWidth(100);
    super.setPrefHeight(100);
    // set button style using CSS
    super.setStyle("-fx-font-size: 45; -fx-font-weight: bold;");
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