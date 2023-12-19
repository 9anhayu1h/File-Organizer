package NewCode;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class VerifyingPath {
    
    static String sourceFolder;
    static ArrayList<FolderNameAndPath> folderNameAndPath = new ArrayList<FolderNameAndPath>();

    public VerifyingPath(String FolderName) {
        
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

    public void selectPath(FolderNameAndPath input) {
        
        list();

        boolean found = false;
        for (FolderNameAndPath folder : folderNameAndPath) {
            if (folder.equals(input)) {
                found = true;
            }
        }

        if (found == true) {
            sourceFolder = input.getPath();
        } else {
            System.out.println("Folder not found!");
        }
    }

}
