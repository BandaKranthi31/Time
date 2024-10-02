package Practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class readingFile {

    public static void main(String[] args) {
        System.out.println(input());

    }

    private static String input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String file = sc.nextLine();

        String code = readFile(file);
        return code;
    }

    private static String readFile(String file){
        StringBuilder code = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                code.append((line)).append("\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return "Exception occurred";
        }
        return code.toString().trim();
    }
}
