import java.io.File;
import java.io.IOException;

public class HugeCleanUp extends CleanUp {

    private static String[][] freeExtensionFolders = {
        {"pdf", "PDFFiles"},
        {"docx", "WordFiles"},
        {"xlsx", "ExcelFiles"},
        // Add more extensions for the Free plan as needed
        };

    public HugeCleanUp(String sourceFolder) {
        super();
        this.extensionsAndFolders = freeExtensionFolders;
    }

    public void CleanUpProfessionally(String sourceFolder) throws IOException {
        createSubFolder(sourceFolder);
        organizeFiles(sourceFolder);
    }

}