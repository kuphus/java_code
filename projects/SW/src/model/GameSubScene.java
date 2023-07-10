package model;

import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.animation.TranslateTransition;    //for moving effect
import javafx.util.Duration;                    //for Duration

public class GameSubScene extends SubScene{

  private int height, width;

  public GameSubScene(String bgImage, int width, int height){
    super(new GridPane(),(double)width,(double)height);
    this.width = width;
    this.height = height;
    prefWidth(width);
    prefHeight(height);
    
    BackgroundImage image = new BackgroundImage(new Image(bgImage, width, height, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
    
    GridPane root2 = (GridPane) this.getRoot();
    
    root2.setBackground(new Background(image));
  /*
   *startout position is beyond screen
   * its half of the image, minus half of the current screen (1024 with)
   * so ((width / 2) - 512)
   */
    setLayoutX(-((width / 2) - 512));
    setLayoutY(0);
  }
  
  public GridPane getPane(){
    return (GridPane) this.getRoot();
  }
  
  public void moveSubScene(double distance){
    double newX = getLayoutX() + distance;
    if(newX >= 0 | newX <= (width-1024)){
      setLayoutX(newX);
    }
  }
  
  public void reset(){
    setLayoutX(-((width / 2) - 512));
    setLayoutY(0);
  }

  public double getGameSceneLayoutX(){
    return getLayoutX();
  }

}