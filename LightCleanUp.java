import java.io.File;
import java.io.IOException;

public class LightCleanUp extends CleanUp {

    String[][] freeExtensionFolders = {
        {"pdf", "PDFFiles"},
        {"docx", "WordFiles"},
        {"xlsx", "ExcelFiles"},
        // Add more extensions for the Free plan as needed
        };

    public LightCleanUp(String sourceFolder) throws IOException {
        super();
        this.extensionsAndFolders = freeExtensionFolders;
        createLightFolder(sourceFolder);
        organizeFiles(sourceFolder);
    }


    public void createLightFolder(String sourceFolder) {

        for (String[] extensionAndfolder : freeExtensionFolders) {
            String folderName = extensionAndfolder[1];

            File folder = new File(sourceFolder, folderName);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }
    }
}