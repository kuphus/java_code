package hangman;

import java.util.*;             //for the ArrayList

public class Game {

    private int badCounter = 0;
    private String[] activeGuess;
    private Integer[] foundIndexes;
    ArrayList<Character> chosenLetters = new ArrayList<Character>();

    // Constructor Game
    public Game(){
        createActiveGuess(GameData.getWord());
        startGame();
    }

    public void createActiveGuess(String w){
        activeGuess = new String[w.length()];
        for(int index = 0; index<w.length(); index++){
            activeGuess[index] = "_ ";
        }
    }

    // The Game
    public void startGame(){

        do {
            printActiveGuess();
            printChosenChars();
            System.out.println("Welke letter kies je? : ");
            Scanner scanner = new Scanner(System.in);
            String letter = scanner.nextLine();
            letter = letter.toLowerCase();
            if(letter.length() != 1){
                System.out.println("Verkeerde invoer, voer 1 letter in");
                continue;
            }
            char chosenChar = letter.charAt(0);
            foundIndexes = searchWord(chosenChar);
            if(foundIndexes.length > 0){
                System.out.println("Goed geraden!");
                updateActiveGuess(chosenChar);
            }
            else {
                badCounter++;
                chosenLetters.add(chosenChar);
                System.out.println("Helaas!");
                //System.out.println("Je hebt " + badCounter + " keer fout geraden!");
                printHangman(badCounter);
            }

        }while(!checkWinCondition() && badCounter < 10);
        System.out.println("Het woord was: " + GameData.getWord());
        if(checkWinCondition()){
            printWin();
        }
        else{
            printLoose();
        }

    }

    public void updateActiveGuess(char l){
        for(int index = 0; index < foundIndexes.length; index++){
            activeGuess[foundIndexes[index]] = Character.toString(l);
        }
    }

    public void printActiveGuess(){
        String temp = "";
        for(int index = 0; index < activeGuess.length; index++){
            temp += activeGuess[index];
        }
        System.out.println(temp);
    }

    public boolean checkWinCondition(){
        String temp = "";
        for(int index = 0; index < activeGuess.length; index++){
            temp += activeGuess[index];
        }
        if(temp.equals(GameData.getWord())){
            return true;
        }
        return false;
    }

    public Integer[] searchWord(char l){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int index = 0;
        do{
            int charIndex = GameData.getWord().indexOf(l, index);
            if(charIndex >= 0){
                result.add(charIndex);
                index = charIndex + 1;
            }
            else{
                break;
            }
        }while(index <= GameData.getWord().length());

        return result.toArray(new Integer[0]);
    }


    public void printChosenChars(){
        System.out.print("Deze letters heb je al gekozen: ");
        for (Character let : chosenLetters) {
            System.out.print(let.toString()+" ");
        }
        System.out.println();
    }

    public void printWin(){
        System.out.println("------------------------");
        System.out.println("||      YOU WIN!      ||");
        System.out.println("------------------------");
    }

    public void printLoose(){
        System.out.println("------------------------");
        System.out.println("||     YOU SUCK!      ||");
        System.out.println("------------------------");
    }


    public void printHangman(int fout){
        switch(fout) {
            case 1:
                System.out.println("");
                System.out.println("|_____________________|");
                break;
            case 2:
                System.out.println("");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
            case 3:
                System.out.println("");
                System.out.println(" _____________        ");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
            case 4:
                System.out.println("");
                System.out.println(" __/|\\________        ");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
            case 5:
                System.out.println("");
                System.out.println("                       ");
                System.out.println("                       ");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println(" __/|\\________        ");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
            case 6:
                System.out.println("");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println(" __/|\\________        ");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
            case 7:
                System.out.println("");
                System.out.println("    |/                 ");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println(" __/|\\________        ");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
            case 8:
                System.out.println("     --------          ");
                System.out.println("    |/                 ");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println(" __/|\\________        ");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
            case 9:
                System.out.println("     --------          ");
                System.out.println("    |/    |            ");
                System.out.println("    |     |            ");
                System.out.println("    |                  ");
                System.out.println("    |                  ");
                System.out.println(" __/|\\________        ");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
            case 10:
                System.out.println("     --------          ");
                System.out.println("    |/    |            ");
                System.out.println("    |    \\0/          ");
                System.out.println("    |     |            ");
                System.out.println("    |    / \\          ");
                System.out.println(" __/|\\________        ");
                System.out.println("|             |_______ ");
                System.out.println("|_____________________|");
                break;
        }
    }
}
