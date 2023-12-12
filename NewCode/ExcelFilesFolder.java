package NewCode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ExcelFilesFolder extends Folder {
    public ExcelFilesFolder() {
        super("ExcelFiles");
    }

    @Override
    public void organizeFile(File file, String fileName, String sourceFolder) throws IOException {
        // Implement Excel file specific organization logic here
        // Move the file to the appropriate destination folder
        Path sourcePath = file.toPath();
        Path destinationPath = Path.of(sourceFolder, folderName, fileName);
        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }
}