package hangman;

public class GameData {

    private static String name, word;

    public static String getName(){
        return name;
    }

    public static String getWord(){
        return word;
    }

    public static void setName(String n){
        name = n;
    }

    public static void setWord(String w){
        word = w;
    }
}
