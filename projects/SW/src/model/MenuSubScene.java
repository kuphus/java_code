package model;

import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.animation.TranslateTransition;    //for moving effect
import javafx.util.Duration;                    //for Duration

public class MenuSubScene extends SubScene{

  private final static String FONT_PATH = "model/resources/vintage.ttf";
  private final static String BACKGROUND_IMAGE = "model/resources/blue_panel.png";
  
  private boolean isHidden;

  public MenuSubScene(){
    super(new AnchorPane(), 600, 400);
    prefWidth(600);
    prefHeight(400);
    
    BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 400, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
    
    AnchorPane root2 = (AnchorPane) this.getRoot();
    
    root2.setBackground(new Background(image));
    
    //startout position is beyond screen
    setLayoutX(1024);
    setLayoutY(150);
    isHidden = true;
  }
  
  public void moveSubScene(){
    TranslateTransition transition = new TranslateTransition();
    transition.setDuration(Duration.seconds(0.3));
    transition.setNode(this);   //curent node moves
    
    if(isHidden){
      transition.setToX(-674); //moves minus 674 pixels on x-axis
      isHidden=false;
    }
    else{
      transition.setToX(0);
      isHidden=true;
    }

    transition.play(); //start transition
  }
  
  public AnchorPane getPane(){
    return (AnchorPane) this.getRoot();
  }
}