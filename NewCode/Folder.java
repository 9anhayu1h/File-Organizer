package NewCode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Folder implements FileOrganizer {
    protected String folderName;
    private String[] extensions;

    public Folder(String folderName) {
        this.folderName = folderName;   
    }

    public String[] getExtensions(){
        return extensions;
    };

    public void organizeFile(File file, String fileName, String sourceFolder) throws IOException {
        Path sourcePath = file.toPath();
        Path destinationPath = Path.of(sourceFolder, folderName, fileName);
        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public void createSubFolder(String sourceFolder) {
        File folder = new File(sourceFolder, folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public void countFiles(String documentFolder) {
        File folder = new File(documentFolder); // Initialize the folder variable
        int fileCount = 0;

        // Counting files
        File[] files = folder.listFiles();
        if (files != null) {
            fileCount = files.length;
        }

        // Printing file count
        System.out.println("File Count: " + fileCount);
    }

    public void countExtensions(String documentFolder) {
        File folder = new File(documentFolder);
        int[] extensionCount = new int[extensions.length];
        
        // Counting extensions
        for (int i = 0; i < extensions.length; i++) {
            final String extension = extensions[i];
            //lambda expression
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith("." + extension));
            if (files != null) {
                extensionCount[i] = files.length;
            }
        }
        for (int i = 0; i < extensions.length; i++) {
            System.out.println("Extension: " + extensions[i] + ", Count: " + extensionCount[i]);
        }
    }

    public void countExtensions() {
        GUI gui = new GUI();
        String documentFolder = gui.getFolderPath();
        File folder = new File(documentFolder); // Initialize the folder variable
        int[] extensionCount = new int[extensions.length];
    
        // Counting extensions
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                String fileExtension = getFileExtension(fileName);
                int extensionIndex = getExtensionIndex(fileExtension);
                if (extensionIndex != -1) {
                    extensionCount[extensionIndex]++;
                }
            }
        }
    
        // Printing extension counts
        for (int i = 0; i < extensions.length; i++) {
            System.out.println("Extension: " + extensions[i] + ", Count: " + extensionCount[i]);
        }
    }
    
    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1);
        }
        return "";
    }
    
    private int getExtensionIndex(String extension) {
        for (int i = 0; i < extensions.length; i++) {
            if (extensions[i].equalsIgnoreCase(extension)) {
                return i;
            }
        }
        return -1;
    }
    
}