import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2{
    public static void main(String[] args){
        try{
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);
            int totalPaper = 0;
            int smallest = -1;
            String line = "";
            String num = "";
            int l = 0;
            int w = 0;
            int h = 0;
            int present = 0;
            int totalRibbon = 0;
            int wrapPresent = 0;
            int bow = 0;

            while(scanner.hasNextLine()){
                line = scanner.nextLine();

                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) != 'x'){
                        num += line.charAt(i);
                    }
                    else if(line.charAt(i) == 'x'){
                        if(l == 0){
                            l = Integer.parseInt(num);
                            num = "";
                        }
                        else if(w == 0){
                            w = Integer.parseInt(num);
                            num = "";
                        }
                    }
                }
                
                h = Integer.parseInt(num);
                num = "";

                present = (2 * l * w) + (2 * w * h) + (2 * h * l);
                bow = l * w * h;
                totalRibbon += bow;
                totalPaper += present;
                 
                smallest = l * w;
                if((w * h) < smallest){
                    smallest = w * h;
                }
                if((h * l) < smallest){
                    smallest = h * l;
                }

                wrapPresent = l + l + w + w;
                if((w + w + h + h) < wrapPresent){
                    wrapPresent = w + w + h + h;
                }
                if((h + h + l + l) < wrapPresent){
                    wrapPresent = h + h + l + l;
                }
                
                totalPaper += smallest;
                totalRibbon += wrapPresent;

                l = 0;
                w = 0;
                h = 0;
                smallest = 0;
                present = 0;
                bow = 0;
                wrapPresent = 0;
            }

            System.out.println("totalPaper = " + totalPaper);
            System.out.println("totalRibbon = " + totalRibbon);

            scanner.close();

        }
        catch(FileNotFoundException e){
            System.out.println("There is no file you fool");
            e.printStackTrace();
        }



    }
}