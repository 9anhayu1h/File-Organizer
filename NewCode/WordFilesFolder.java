package NewCode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class WordFilesFolder extends Folder {
    public WordFilesFolder() {
        super("WordFiles");
    }

    @Override
    public void organizeFile(File file, String fileName, String sourceFolder) throws IOException {
        // Implement Word file specific organization logic here
        // Move the file to the appropriate destination folder
        Path sourcePath = file.toPath();
        Path destinationPath = Path.of(sourceFolder, folderName, fileName);
        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }
}
