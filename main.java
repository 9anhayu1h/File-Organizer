import java.io.IOException;

public class main {

    public static String sourceFolder = "C:/Users/PC/Documents/IFL/CE";

    public static void Main(String[] args) {

        try {
            CleanUp.createSubFolder(sourceFolder);

            // Organize files in the source folder
            CleanUp.organizeFiles(sourceFolder);

            System.out.println("Files organized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
