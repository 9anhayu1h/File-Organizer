package NewCode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Videos extends Folder {
    protected String[] extensions = {"mp4", "mkv", "avi", "mov", "flv", "wmv"};
    public Videos() {
        super("Videos");
    }

    @Override
    public void organizeFile(File file, String fileName, String sourceFolder) throws IOException {
        Path sourcePath = file.toPath();
        Path destinationPath = Path.of(sourceFolder, folderName, fileName);
        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }
}
