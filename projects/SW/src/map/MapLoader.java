package map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class MapLoader{

  public static int[] getHorizon(String path) throws FileNotFoundException{

    Image image = new Image(new FileInputStream(path));

    int width = (int) image.getWidth();
    int height = (int) image.getHeight();
    int[] horizon = new int[width];

    BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
    int colour = bImage.getRGB(0,height-1);

    for(int x = 0; x < width; x++){
      for(int y = 0; y < height; y++){
        if(bImage.getRGB(x,y) == colour){
          horizon[x] = y;//add coordinate to array
          break;
        }
      }
    }
    return horizon;
  }
  
  //nieuwe versie gebaseerd op transparency en volledige map, niet enkel de horizon
  public static boolean[][] loadMap(String path) throws FileNotFoundException{
    
    Image image = new Image(new FileInputStream(path));

    int width = (int) image.getWidth();
    int height = (int) image.getHeight();
    boolean[][] flyable = new boolean[width][height];
    
    BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
    
    for(int x = 0; x < width; x++){
      for(int y = 0; y < height; y++){
        int pixel = bImage.getRGB(x,y);
        if( (pixel>>24) == 0x00 ){
          flyable[x][y] = true;
        }
        else{
          flyable[x][y] = false;
        }
      }
    }
    
    return flyable;

  }
}