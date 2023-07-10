package map;

import java.util.Arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.layout.*;                   //for AnchorPane, Background, BackgroundImage, BackgroundPosition, BackgroundRepeat, HBox
import javafx.scene.*;                          //for Scene
import javafx.stage.*;
import javafx.application.Application;

import java.awt.image.BufferedImage;
import java.awt.Color;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


class MapLoaderTest{
  public static void main(String[] args) throws Exception{

    String locatie = "src/map/maps/Map-danny-1s.png"; //"map/resources/map1.png";
    //boolean[][] testArray = MapLoader.loadMap(locatie);

    //System.out.println(Arrays.toString(testArray[54]));

    int[] horizon = MapLoader.getHorizon(locatie);
    System.out.println(Arrays.toString(horizon));
  }

  /*
  public static Image drawMap(boolean[][] map){
    int w = map.length;
    int h = map[0].length;
    BufferedImage bImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    
    for (int x = 0; x <w ; x++) {
      for (int y = 0; y < h; y++) {
        if(map[x][y]){
         int rgb = new Color(255,255,255).getRGB();
         bImage.setRGB(x, y, rgb );
        }
        else {
         int rgb = new Color(0,0,0).getRGB();
         bImage.setRGB(x, y, rgb );
        }
      }
    }
    
    Image image = SwingFXUtils.toFXImage(bImage, null);
    return image;
  }
  */
}