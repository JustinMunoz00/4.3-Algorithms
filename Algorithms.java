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
        System.out.println(lengthTwo);
        s.close();
    }

    public static int length(int length){
        int count = 0;
        for (String i : m.keySet()){
            if (i.length() == length) count++;
        }
        return count;
    }

    public static int stringsWithLength(){
        
    }
}