package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;          //for Background, BackgroundImage, BackgroundRepeat, BackgroundPosition
import javafx.scene.text.Font;

public class InfoLabel extends Label{
  
  private final static String FONT_PATH = "model/resources/vintage.ttf";
  private final static String BACKGROUND_IMAGE = "model/resources/blue_button13.png";
  
  public InfoLabel(String text){
    setPrefWidth(400);
    setPrefHeight(45);
    setText(text);
    setWrapText(true);
    setLabelFont();
    setAlignment(Pos.CENTER);
    
    BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE,400,49, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
    setBackground(new Background(backgroundImage));
  }
  
  private void setLabelFont(){
    try{
      setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
    }
    catch(FileNotFoundException e){
      setFont(Font.font("Verdana", 23));
    }
  }
}