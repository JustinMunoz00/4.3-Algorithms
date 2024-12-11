import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Algorithms{
    private static File f;
    private static Scanner s;
    private static HashMap<String, Integer> m;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");
        s = new Scanner(f);
        m = new HashMap<String, Integer>();
        String x;
        while (s.hasNextLine()){
            x = s.nextLine();
            if (m.isEmpty()){
                m.put(x, 1);
            } else if (m.containsKey(x)){
                m.replace(x, m.get(x) + 1);
            } else m.put(x, 1);
        }
        int lengthTwo = length(2);
        int maxLength = numOfStrsWithLongestLength();
        int palindromes = numOfPalindromes();
        System.out.println(lengthTwo);
        System.out.println(maxLength);
        System.out.println(palindromes);
        s.close();
    }

    public static int length(int length){
        int count = 0;
        for (String i : m.keySet()){
            if (i.length() == length) count++;
        }
        return count;
    }

    public static int numOfStrsWithLongestLength(){
        int count = 0;
        int greatestLength = 0;
        for (String i : m.keySet()){
            if (i.length() == greatestLength) count++;
            else if (i.length() > greatestLength) count = 1;
        }
        return count;
    }

    public static int numOfPalindromes(){
        int count = 0;
        for (String i : m.keySet()){
            StringBuilder reverse = new StringBuilder(i);
            reverse = reverse.reverse();
            if (reverse.toString().equals(i)) count++;
        }
        return count;
    }
    
}