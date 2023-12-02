import java.io.File;
import java.io.IOException;

public class LightCleanUp extends CleanUp {

    private static String[][] freeExtensionFolders = {
        {"pdf", "PDFFiles"},
        {"docx", "WordFiles"},
        {"xlsx", "ExcelFiles"},
        // Add more extensions for the Free plan as needed
        };

    public LightCleanUp(String sourceFolder) {
        super();
        this.extensionsAndFolders = freeExtensionFolders;
    }

    public void CleanUpLightly(String sourceFolder) throws IOException {
        createLightFolder(sourceFolder);
        organizeFiles(sourceFolder);
    }

    private static void createLightFolder(String sourceFolder) {

        for (String[] extensionAndfolder : freeExtensionFolders) {
            String folderName = extensionAndfolder[1];

            File folder = new File(sourceFolder, folderName);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }
    }
}