package NewCode;
import java.io.File;
import java.io.IOException;

public class Main {
    private static String sourceFolder = "C:/Users/PC/Downloads/NYC";
    private static Folder[] folders = {
            new Documents(),
            new Pictures(),
            new Musics(),
            new Videos(),
            new Compressed(),
            new Programs(),
    };

    public static void main(String[] args) {

        try {
            
            createSubFolder(sourceFolder);

            // Organize files in the source folder
            organizeFiles(sourceFolder);

            System.out.println("Files organized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createSubFolder(String sourceFolder) {

        for (Folder folder : folders) {
            folder.createSubFolder(sourceFolder);
        }
    }

    private static void organizeFiles(String sourceFolder) throws IOException {
        File[] files = new File(sourceFolder).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

                    for (Folder folder : folders) {
                        if (folder instanceof Documents) {
                            //cast this folder object to documents object to access the extensions array
                            Documents documents = (Documents) folder;
                            for (String docExtension : documents.extensions) {
                                if (extension.equals(docExtension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                }
                            }
                        } else if (folder instanceof Pictures) {
                            Pictures pictures = (Pictures) folder;
                            for (String picExtension : pictures.extensions) {
                                if (extension.equals(picExtension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                }
                            }
                        } else if (folder instanceof Pictures) {
                            Pictures pictures = (Pictures) folder;
                            for (String picExtension : pictures.extensions) {
                                if (extension.equals(picExtension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                }
                            }
                        } else if (folder instanceof Musics) {
                            Musics musics = (Musics) folder;
                            for (String musicExtension : musics.extensions) {
                                if (extension.equals(musicExtension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                }
                            } 
                        } else if (folder instanceof Videos) {
                            Videos videos = (Videos) folder;
                            for (String vidExtension : videos.extensions) {
                                if (extension.equals(vidExtension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                }
                            }
                        } else if (folder instanceof Compressed) {
                            Compressed compressed = (Compressed) folder;
                            for (String compressedExtension : compressed.extensions) {
                                if (extension.equals(compressedExtension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                }
                            }
                        } else if (folder instanceof Programs) {
                            Programs programs = (Programs) folder;
                            for (String programExtension : programs.extensions) {
                                if (extension.equals(programExtension)) {
                                    folder.organizeFile(file, fileName, sourceFolder);
                                }
                            }
                        } else {
                            if (extension.equals(folder.folderName.toLowerCase())) {
                                folder.organizeFile(file, fileName, sourceFolder);
                            }
                        }
                    }
                }
            }
        }
    }
}