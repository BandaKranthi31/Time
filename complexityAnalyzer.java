import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class complexityAnalyzer {
    public static void main(String[] args) {
        input();
    }

    private static void input() {
        System.out.println(" --- Time and Space Complexity --- ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter File Path");
        String file = sc.nextLine();

        String code = readFile(file);
        if(code == null){
            System.out.print("Error Reading File : ");
            return;
        }
    }

    private static String readFile(String file) {
        StringBuilder code = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while( (line = br.readLine()) != null ){
                code.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return code.toString();
    }
}
