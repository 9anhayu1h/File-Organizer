package OldCode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class CleanUp {

    // Define the file extensions and corresponding folders
    protected ArrayList<String[]> extensionsAndFolders = new ArrayList<String[]>();

    public CleanUp() {
    }

    public void createSubFolder(String sourceFolder) {
        for (String[] extensionAndfolder : extensionsAndFolders) {
            for (String extension : extensionAndfolder) {
                String folderName = extensionAndfolder[1];

                File folder = new File(sourceFolder, folderName);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
            }
        }
    }

    public void organizeFiles(String sourceFolder) throws IOException {
        File[] files = new File(sourceFolder).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

                    // Find the corresponding folder for the file extension
                    String destinationSubFolder = findDestinationSubFolder(extension);
                    
                    if (destinationSubFolder != null) {
                        // Move the file to the appropriate destination folder
                        Path sourcePath = file.toPath();
                        Path destinationPath = Path.of(sourceFolder, destinationSubFolder, fileName);
                        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        }
    }

    private String findDestinationSubFolder(String extension) {
        
        for (String[] extensionAndFolder : extensionsAndFolders) {
            if (extensionAndFolder[0].equalsIgnoreCase(extension)) {
                return extensionAndFolder[1];
            }
        }
        return null; // Return null if no corresponding folder found
    }
}
