package hangman;

import java.util.Scanner;

public class StartScherm {

    // Constructor StartScherm
    public StartScherm(){
        printStartScherm();
        askName();
        askWord();
        emptyScreen();
    }

    public void printStartScherm(){
        System.out.println("------------------------");
        System.out.println("|  Welkom bij Hangman! |");
        System.out.println("------------------------");
    }

    public void askName(){
        String temp = "";
        do {
            System.out.println("Wie gaat er spelen? : ");
            Scanner scanner = new Scanner(System.in);
            temp = scanner.nextLine();
            if(temp.length() <= 0){
                System.out.println("Geen naam ingevoerd!");
            }
        }while(temp.length() <= 0 );
        GameData.setName(temp);
    }

    public void askWord(){
        String temp = "";
        boolean correctWord;
        do {
            correctWord = true;
            System.out.println("Welk woord moet worden geraden? : ");
            Scanner scanner = new Scanner(System.in);
            temp = scanner.nextLine();
            temp = temp.toLowerCase();
            if(temp.length() <= 0){
                System.out.println("Geen woord ingevoerd!");
                correctWord = false;
            }
            else if(temp.length() == 1){
                System.out.println("Er bestaat ^%#$% geen 1-letter woord! CHEATER");
                correctWord = false;
            }
            else if(validateWord(temp)){
                System.out.println("Je mag niet schelden van je moeder!");
                correctWord = false;
            }
        }while(!correctWord );
//        }while(temp.length() <= 0 && !correctWord );
            GameData.setWord(temp);
    }

    public void emptyScreen(){
        for(int x=0; x<30; x++){
            System.out.println("\n");
        }
    }

    public boolean validateWord(String w){
        String[] badWords = {"klootzak","eikel", "lul", "dick", "idioot"};
        for(String t: badWords){
            if(t.equals(w)){
                return true;
            }
        }
        return false;
    }
}
