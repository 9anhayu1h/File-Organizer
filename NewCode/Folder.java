package NewCode;
import java.io.File;
import java.io.IOException;

public abstract class Folder {
    protected String folderName;

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public abstract void organizeFile(File file, String fileName, String sourceFolder) throws IOException;

    public void createSubFolder(String sourceFolder) {
        File folder = new File(sourceFolder, folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }
}