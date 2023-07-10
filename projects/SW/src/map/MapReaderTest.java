package map;

public class MapReaderTest{
  public static void main(String[] args){
  
  String path = "src/map/resources/";
  
  String[] maps = MapReader.listAllFiles(path);
  for(String s: maps){
    System.out.println(s);
  }

  }
}
