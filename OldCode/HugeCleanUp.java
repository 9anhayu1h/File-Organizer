package OldCode;
import java.io.IOException;
import java.util.ArrayList;

public class HugeCleanUp extends CleanUp {

    private static String[] compressed = {"zip"};
    private static String[] documents = {"pdf", "docx", "xlsx", "pptx"};
    private static String[] pictures = {"jpg", "png", "gif"};
    private static String[] videos = {"mp4", "avi", "mkv"};
    private static String[] programs = {"exe", "msi"};

    private static ArrayList<String[]> hugeExtensionFolders;

    static {
        hugeExtensionFolders = new ArrayList<>();
        hugeExtensionFolders.add(compressed);
        hugeExtensionFolders.add(documents);
        hugeExtensionFolders.add(pictures);
        hugeExtensionFolders.add(videos);
        hugeExtensionFolders.add(programs);
    }

    public HugeCleanUp(String sourceFolder) {
        super();
        this.extensionsAndFolders = hugeExtensionFolders;
    }

    public void cleanUpProfessionally(String sourceFolder) throws IOException {
        createSubFolder(sourceFolder);
        organizeFiles(sourceFolder);
    }

    public static void main(String[] args) {
        for (String[] extension : hugeExtensionFolders)

            System.out.println(extension);
    }
}