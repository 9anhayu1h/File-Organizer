package NewCode;
import java.io.File;
import java.io.IOException;

public class Main {
    private static String sourceFolder = "C:/Users/PC/Documents/IFL/DGE";
    private static Folder[] folders = {
            new PDFFilesFolder(),
            new WordFilesFolder(),
            new ExcelFilesFolder()
            // Add more folder instances as needed
    };

    public static void main(String[] args) {

        try {
            
            createSubFolder(sourceFolder);

            // Organize files in the source folder
            organizeFiles(sourceFolder);

            System.out.println("Files organized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createSubFolder(String sourceFolder) {

        for (Folder folder : folders) {
            folder.createSubFolder(sourceFolder);
        }
    }

    private static void organizeFiles(String sourceFolder) throws IOException {
        File[] files = new File(sourceFolder).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

                    for (Folder folder : folders) {
                        if (folder instanceof ExcelFilesFolder && extension.equalsIgnoreCase("csv")) {
                            folder.organizeFile(file, fileName, sourceFolder);
                            break;
                        } else if (folder.getClass().getSimpleName().equalsIgnoreCase(extension + "FilesFolder")) {
                            folder.organizeFile(file, fileName, sourceFolder);
                            break;
                        }
                    }
                }
            }
        }
    }
}


