package NewCode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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

        Scanner keyboard = new Scanner(System.in);
        String tempFolderName;
        String tempPath;
        int Choice;

        System.out.println("Welcome to File Organizer!");
        System.out.print("Select actions \n1. for folder selection \n2. to add more folder path\n: ");
        Choice = keyboard.nextInt();

        switch (Choice) {
            case 1:
                System.out.print("add folder name: ");
                tempFolderName = keyboard.next();
                System.out.print("folder path: ");
                tempPath = keyboard.next();

                RegisterPath.registerPath(tempFolderName, tempPath);
                break;

            case 2:
                System.out.println("Select folder name: ");
                tempFolderName = keyboard.next();

                if (SelectPath.verifySelectPath(tempFolderName) == true) {
                    String sourceFolder = SelectPath.sourceFolder;
                    FolderNameAndPath selectedFolder = new FolderNameAndPath(tempFolderName, sourceFolder);
                    System.out.println(selectedFolder.getPath());
                    // try {
                        
                    //     createSubFolder(selectedFolder.getPath());

                    //     organizeFiles(selectedFolder.getPath());

                    //     System.out.println("Files organized successfully!");
                    // } catch (IOException e) {
                    //     e.printStackTrace();
                    // } 
                }
            default:
                break;
        }

        //anonymous class
        Documents document = new Documents() {

            @Override
            public void countExtensions() {
                String documentFolder = "C:/Users/PC/Downloads/Documents";
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

        // Picture pictures = new Picture();
        // Documents a = new Documents();
        
        // String test = document.toString();
        // System.out.println(test);
        // System.out.println(pictures.toString());

        // System.out.println(document.equals(pictures));
        // document.countExtensions();
        keyboard.close();
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