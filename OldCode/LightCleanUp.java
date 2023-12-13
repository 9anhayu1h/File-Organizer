package OldCode;
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

    public void cleanUpLightly(String sourceFolder) throws IOException {
        createSubFolder(sourceFolder);
        organizeFiles(sourceFolder);
    }

}