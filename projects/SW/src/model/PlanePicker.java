package model;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PlanePicker extends VBox{

  private ImageView circleImage;
  private ImageView planeImage;
  
  private String circleNotChosen = "view/resources/blue_circle.png";
  private String circleChosen = "view/resources/blue_boxTick.png";
  
  private PLANE plane;
  private boolean isCircleChosen;
  
  public PlanePicker(PLANE plane){
    circleImage = new ImageView(circleNotChosen);
    planeImage = new ImageView(plane.getURL());
    this.plane = plane;
    isCircleChosen = false;
    this.setAlignment(Pos.CENTER);
    this.setSpacing(20);
    this.getChildren().add(circleImage);
    this.getChildren().add(planeImage);
  }
  
  public PLANE getPlane(){
    return plane;
  }
  
  public boolean getIsCircleChosen(){
    return isCircleChosen;
  }
  
  public void setIsCircleChosen(boolean isCircleChosen){
    this.isCircleChosen = isCircleChosen;
    String imageToSet = this.isCircleChosen ? circleChosen : circleNotChosen;
    circleImage.setImage(new Image(imageToSet));
  }
}