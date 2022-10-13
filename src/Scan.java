import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scan {
    public static void main(String[] args) {
        File f = new File("Voyna.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(reader);
        scanner.useDelimiter("\\s");
        List<String> st = new ArrayList<>();
        int count = 0;
        while (scanner.hasNext()) {
            String words = scanner.next();
            st.add(words);
        }
        for (String word : st) {
            Pattern input = Pattern.compile("[Сс]трад");
            Matcher mc = input.matcher(word);
            while (mc.find()) {
                count++;
            }
        }
        if (count != 0)
        {
            System.out.println("Данное слово встречается в книге " + count + " раз(а)");
        } else {
            System.out.println("Данное слово в книге отсутствует");
        }
        scanner.close();
    }

}
