package NewCode;

import java.io.File;

public class Office extends Documents {
    protected String[] extensions = {"docx", "xlsx", "pptx"};

        public void countExtensions() {
            String documentFolder = "C:/Users/PC/Downloads/Documents";
            File folder = new File(documentFolder); // Initialize the folder variable
            int[] extensionCount = new int[extensions.length];

            // Counting extensions
            for (int i = 0; i < extensions.length; i++) {
                final String extension = extensions[i]; // declaring final variable to use in lambda expression
                File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith("." + extension));
                if (files != null) {
                extensionCount[i] = files.length;
                }
            }

            // Printing extension counts
            for (int i = 0; i < extensions.length; i++) {
                System.out.println("Extension: " + extensions[i] + ", Count: " + extensionCount[i]);
            }
        }    

}
