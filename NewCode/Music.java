package NewCode;

public class Music extends Folder {
    protected String[] extensions = {"mp3", "wav", "flac", "m4a"};

    public Music() {
        super("Music");
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
