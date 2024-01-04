package NewCode;

import java.io.File;
import java.io.IOException;

interface FileOrganizer {

    public String[] getExtensions();

    public void organizeFile(File file, String fileName, String sourceFolder) throws IOException;

    public void countExtensions(String documentFolder);
    
}
