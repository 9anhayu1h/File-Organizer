package NewCode;
import java.io.File;
import java.io.IOException;

public class Main {
    private static String sourceFolder = "C:/Users/PC/Downloads";
    private static Folder[] folders = {
            new Documents(),
            new Picture(),
            new Music(),
            new Video(),
            new Compressed(),
            new Programs(),
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

        // Documents documents = new Documents();
        // Pictures pictures = new Pictures();
        // Documents a = new Documents();
        
        // String test = documents.toString();
        // String pic = pictures.toString();
        // System.out.println(test);
        // System.out.println(pic);

        // System.out.println(documents.equals(pictures));
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
                        if (folder instanceof FileOrganizer) {
                            FileOrganizer fileOrganizer = (FileOrganizer) folder;
                            for (String finalExtension : fileOrganizer.getExtensions()) {
                                if (finalExtension.equals(extension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                    break;
                                }
                            }
                        } else {
                            if (extension.equals(folder.folderName.toLowerCase())) {
                                folder.organizeFile(file, fileName, sourceFolder);
                            }
                        }
                    }
                }
            }
        }
    }
}