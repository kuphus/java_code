package map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import java.util.ArrayList;
import java.util.List;

public class MapReader{

  private static List<String> mapList = new ArrayList<String>();

  public static String[] listAllFiles(String path){
    try(Stream<Path> paths = Files.walk(Paths.get(path))) {
      paths.forEach(filePath -> {
        if (Files.isRegularFile(filePath)) {
          try {
            mapList.add(filePath.toString());
            //System.out.println(filePath.toString());
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      });
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return mapList.toArray(new String[0]);

  }
  


}
