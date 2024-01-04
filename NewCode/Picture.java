package NewCode;

public class Picture extends Folder {
    protected String[] extensions = {"jpg", "jpeg", "png", "gif", "bmp"};

    public Picture() {
        super("Picture");
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
