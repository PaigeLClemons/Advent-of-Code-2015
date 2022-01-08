import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1{
    public static void main(String[] args){
        try{
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile); 
            int floor = 0;
            int basement = 0;
            char parenthesis = ' ';

            String inputString = scanner.nextLine();

            scanner.close();

            for(int i = 0; i < inputString.length(); i++){
                parenthesis = inputString.charAt(i);
                if(parenthesis == '('){
                    floor++;
                    if(basement == 0 && floor < 0){
                        basement = i + 1;
                    }
                }
                else if(parenthesis == ')'){
                    floor--;
                    if(basement == 0 && floor < 0){
                        basement = i + 1;
                    }
                }
            }

            System.out.println("Floor = " + floor);
            System.out.println("Basement = " + basement);
        }
        catch(FileNotFoundException e){
            System.out.println("There is no file you fool");
            e.printStackTrace();
        }



    }
}