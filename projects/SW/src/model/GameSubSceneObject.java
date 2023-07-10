package model;

import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.animation.TranslateTransition;    //for moving effect
import javafx.util.Duration;                    //for Duration

public class GameSubSceneObject extends SubScene{

  private int height, width;
  double xCoordinate,yCoordinate;

  public GameSubSceneObject(String bgImage, int width, int height, double xCoordinate, double yCoordinate){
    super(new GridPane(),(double)width,(double)height);
    this.width = width;
    this.height = height;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    prefWidth(width);
    prefHeight(height);
    
    BackgroundImage image = new BackgroundImage(new Image(bgImage, width, height, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
    
    GridPane root3 = (GridPane) this.getRoot();
    
    root3.setBackground(new Background(image));
  /*
   *startout position is beyond screen
   * its half of the image, minus half of the current screen (1024 with)
   * so ((width / 2) - 512)
   */
    setLayoutX(xCoordinate);
    setLayoutY(yCoordinate);
  }
  
  public GridPane getPane(){
    return (GridPane) this.getRoot();
  }
  
  public void moveSubSceneObject(double distance){
    double newX = getLayoutX() + distance;
    if(newX >= 0 | newX <= (width-1024)){
      setLayoutX(newX);
    }
  }
  
  public void reset(){
    setLayoutX(xCoordinate);
    setLayoutY(yCoordinate);
  }

  public double getGameSceneObjectLayoutX(){
    return getLayoutX();
  }

}