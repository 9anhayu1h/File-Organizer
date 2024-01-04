package NewCode;

public class Programs extends Folder {
    protected String[] extensions = {"exe", "msi"};

    public Programs() {
        super("Programs");
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

