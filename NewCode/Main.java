package NewCode;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
    private static String sourceFolder = "C:/Users/PC/Downloads";

    //anonymous class
    static Documents document = new Documents() {

        @Override
        public void countExtensions() {
            String documentFolder = sourceFolder + "/Documents";
            File folder = new File(documentFolder); // Initialize the folder variable
            int[] extensionCount = new int[extensions.length];

            // Counting extensions
            for (int i = 0; i < extensions.length; i++) {
                final String extension = extensions[i]; // declaring final variable to use in lambda expression
                File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith("." + extension));
                if (files != null) {
                    extensionCount[i] = files.length;
                }
            }

            // Printing extension counts
            for (int i = 0; i < extensions.length; i++) {
                System.out.println("Extension: " + extensions[i] + ", Count: " + extensionCount[i]);
            }
        }
    };    

    private static Folder[] folders = {
            document,
            new Picture(),
            new Music(),
            new Video(),
            new Compressed(),
            new Programs(),
    };

    public static void main(String[] args) {

        try {
            
            createSubFolder(sourceFolder);

            organizeFiles(sourceFolder);

            System.out.println("Files organized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Picture pictures = new Picture();
        // Documents a = new Documents();
        
        // String test = document.toString();
        // System.out.println(test);
        // System.out.println(pictures.toString());

        // System.out.println(document.equals(pictures));
        document.countExtensions();

    }

    private static void createSubFolder(String sourceFolder) {

        for (Folder folder : folders) {
            folder.createSubFolder(sourceFolder);
        }
    }

    private static void organizeFiles(String sourceFolder) throws IOException {
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