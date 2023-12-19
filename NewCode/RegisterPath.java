package NewCode;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class RegisterPath {
    public static void registerPath(String folderName, String path) {
        Scanner keyboard = new Scanner(System.in);
        String filePath = "C:/Users/PC/Desktop/Programming/Java/Project/NewCode/FolderName&Path.txt";
        String folderNameAndPath = folderName + " : " + path;

        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(folderNameAndPath);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

        keyboard.close();
    }
}
