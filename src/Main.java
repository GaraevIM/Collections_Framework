import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        File file = new File("Voyna.txt");
        String[] words;

        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);

        String s;

        int count = 0;

        while (true) {
            try {
                if (!((s = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            words = s.split(" ");
            for (String word : words) {
                Pattern input = Pattern.compile("[Сс]трад");
                Matcher mc = input.matcher(word);
                while (mc.find()) {
                    count++;
                }
            }
        }
        if (count != 0)
        {
            System.out.println("Данное слово встречается в книге " + count + " раз(а)");
        } else {
            System.out.println("Данное слово в книге отсутствует");
        }
        try {
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (int i = 1; i <= 10; i++) {
            System.out.println();
            for (int n = 1; n <= 10; n++) {
                System.out.print((i * n) + " \t");
            }
        }
    }
}
