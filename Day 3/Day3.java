import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3{
    public static void main(String[] args){
        try{
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);
            

            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("There is no file you fool");
            e.printStackTrace();
        }
    }
}
