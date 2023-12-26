package NewCode;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class SelectPath {
    
    static String sourceFolder;
    static ArrayList<FolderNameAndPath> folderNameAndPath = new ArrayList<FolderNameAndPath>();

    public SelectPath(String FolderName) {
        
    }
    
    public static void list() {

        String filePath = "C:/Users/PC/Desktop/Programming/Java/Project/NewCode/FolderName&Path.txt";

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] selectedFolderNameAndPath = line.split( " : ");
                FolderNameAndPath selectedFolder = new FolderNameAndPath(selectedFolderNameAndPath[0], selectedFolderNameAndPath[1]);
                folderNameAndPath.add(selectedFolder);

                }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean verifySelectPath(String inputFolderName) {
        
        list();

        boolean found = false;
        FolderNameAndPath input = new FolderNameAndPath(inputFolderName, null);
        for (FolderNameAndPath folder : folderNameAndPath) {
            if (folder.equals(input)) {
                found = true;
            }
        }

        if (found == true) {
            sourceFolder = input.getPath();
            return true;
        } else {
            System.out.println("Folder not found!");
            return false;
        }
    }

}