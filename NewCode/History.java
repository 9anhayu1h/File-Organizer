package NewCode;

import java.io.FileWriter;
import java.io.BufferedWriter;

public class History {
    String folderName;
    String path;

    public static void savePath(String folderPath) {
        String filePath = "C:/Users/PC/Desktop/Programming/Java/Project/NewCode/History.txt";

        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(folderPath);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
