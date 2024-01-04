package NewCode;

public class Video extends Folder {
    protected String[] extensions = {"mp4", "mkv", "avi", "mov", "flv", "wmv"};
    public Video() {
        super("Video");
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
