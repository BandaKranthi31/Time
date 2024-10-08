import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class complexityAnalyzer {
    public static void main(String[] args) {
        input();
    }

    private static void input() {
        System.out.println(" --- Time and Space Complexity --- ");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter File Path:");
            String file = sc.nextLine();

            String code = readFile(file);
            if (code == null) {
                System.out.print("Error Reading File.");
                return;
            }
            analyzeTimeComplexity(code);
        }
    }

    private static void analyzeTimeComplexity(String code) {
        String timeComplexity = determineTimeComplexity(code);
        System.out.println("Estimated Time Complexity: " + timeComplexity);
    }

    private static String readFile(String file) {
        StringBuilder code = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                code.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return code.toString().trim();
    }

    private static String determineTimeComplexity(String code) {
        if (matchesPattern(code, "\\b\\w+\\s*\\(.*\\)\\s*\\{[^}]*\\b\\w+\\s*\\(.*\\)")) {
            return "O(2^n) {Exponential (simple recursion)}";
        } else if (matchesPattern(code, "for\\s*\\(.*;.*;.*\\)\\s*\\{[\\s\\S]*?for\\s*\\(.*;.*;.*\\)")) {
            return "O(n^2) {Quadratic}";
        } else if (matchesPattern(code, "for\\s*\\(.*;.*;.*\\)")) {
            return "O(n) {Linear}";
        } else if (matchesPattern(code, "while\\s*\\(.*\\)")) {
            return "O(n) {Linear}";
        } else if (matchesPattern(code, "if\\s*\\(.*\\)")) {
            return "O(1) {Constant}";
        }
        return "unknown";
    }

    private static boolean matchesPattern(String code, String pattern) {
        Pattern p = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher m = p.matcher(code);
        return m.find();
    }
}
