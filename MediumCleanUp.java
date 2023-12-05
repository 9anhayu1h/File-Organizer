import java.io.IOException;

public class MediumCleanUp extends CleanUp {

    private static String[][] freeExtensionFolders = {
        {"pdf", "PDFFiles"},
        {"docx", "WordFiles"},
        {"xlsx", "ExcelFiles"},
        // Add more extensions for the Free plan as needed
        };

    public MediumCleanUp(String sourceFolder) {
        super();
        this.extensionsAndFolders = freeExtensionFolders;
    }

    public void CleanUpNormally(String sourceFolder) throws IOException {
        createSubFolder(sourceFolder);
        organizeFiles(sourceFolder);
    }

}