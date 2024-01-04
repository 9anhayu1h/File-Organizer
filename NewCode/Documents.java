package NewCode;

import java.io.File;
import java.io.FilenameFilter;

public class Documents extends Folder {
    protected String[] extensions = {"docx", "doc", "txt", "pdf", "pptx", "ppt", "xlsx", "xls", "csv", "rtf", "dotx"};

    public Documents() {
        super("Documents");
    }

    public String[] getExtensions() {
        return extensions;
    }

    @Override
    public void countExtensions(String documentFolder) {
    File folder = new File(documentFolder);
    int[] extensionCount = new int[extensions.length];

    // Counting extensions
    for (int i = 0; i < extensions.length; i++) {
        final String extension = extensions[i];
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith("." + extension);
            }
        });

        if (files != null) {
            extensionCount[i] = files.length;
        }
    }

    // Printing extension counts
    for (int i = 0; i < extensions.length; i++) {
        System.out.println("Extension: " + extensions[i] + ", Count: " + extensionCount[i]);
    }
}

    @Override
    public String toString() {
        String d = "Folder Name: " + folderName + "\n" + "Extensions: " + String.join(", ", extensions) + "\n";
        return d;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
