package NewCode;

import java.io.File;
import java.io.IOException;

public class Main {   

    private static Folder[] folders = {
            new Documents(),
            new Picture(),
            new Music(),
            new Video(),
            new Compressed(),
            new Programs(),
    };

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.mainPanel();

        // String folderPath = "C:\\Users\\PC\\Downloads";
        // Documents documents = new Documents();
        // documents.countFiles(folderPath);
        // documents.countExtensions(folderPath);
    }

    public static void createSubFolder(String sourceFolder) {

        for (Folder folder : folders) {
            folder.createSubFolder(sourceFolder);
        }
    }

    public static void organizeFiles(String sourceFolder) throws IOException {
        // Get all files in the source folder
        File[] files = new File(sourceFolder).listFiles();
        if (files != null) {
            for (File file : files) {
                // Check if the file is a file if so save the file name and extension
                if (file.isFile()) {
                    String fileName = file.getName();
                    String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);

                    for (Folder folder : folders) {
                        if (folder instanceof FileOrganizer) {
                            //casting, convert folder obj to FileOrganizer obj
                            FileOrganizer fileOrganizer = (FileOrganizer) folder;
                            for (String extension : fileOrganizer.getExtensions()) {
                                if (extension.equals(fileExtension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                    break;
                                }
                            }
                        } else {
                            if (fileExtension.equals(folder.folderName.toLowerCase())) {
                                folder.organizeFile(file, fileName, sourceFolder);
                            }
                        }
                    }
                }
            }
        }
    }
}