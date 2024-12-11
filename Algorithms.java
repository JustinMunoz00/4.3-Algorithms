import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Algorithms{
    private static File f;
    private static Scanner s;
    private static ArrayList<String> strs;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");
        s = new Scanner(f);
        strs = new ArrayList<String>();
        while (s.hasNextLine()){
            strs.add(s.nextLine());
        }
        int lengthTwo = length(2);
        int maxLength = numOfStrsWithLongestLength();
        int palindromes = numOfPalindromes();
        System.out.println("Strings with length of two: " + lengthTwo);
        System.out.println("Amount of strings tied for greatest length: " + maxLength);
        System.out.println("Palindromes: " + palindromes);
        s.close();
    }

    public static int length(int length){
        int count = 0;
        for (String i : strs){
            if (i.length() == length) count++;
        }
        return count;
    }

    public static int numOfStrsWithLongestLength(){
        int count = 0;
        int greatestLength = 0;
        for (String s : strs){
            if (s.length() == greatestLength) count++;
            else if (s.length() > greatestLength) {
                count = 1;
                greatestLength = s.length();
            }
        }
        return count;
    }

    public static int numOfPalindromes(){
        int count = 0;
        for (String s : strs){
            StringBuilder reverse = new StringBuilder(s);
            reverse = reverse.reverse();
            if (reverse.toString().equals(s)) count++;
        }
        return count;
    }
}