package NewCode;

public class Compressed extends Folder {
    protected String[] extensions = {"zip", "rar", "7z", "tar", "gz", "arj", "cab", "iso", "xz"};
    public Compressed() {
        super("Compressed");
    }

    public String[] getExtensions() {
        return extensions;
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
