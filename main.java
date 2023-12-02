import java.io.IOException;
import java.util.Scanner;

public class main {

    public String sourceFolder = "C:/Users/PC/Documents/IFL/ISK";
    public String cleanUpLevel;

    public static void main(String[] args) {
        try {
            main program = new main();
            program.getUserInput();
            switch (program.cleanUpLevel) {
                case "Light":

                    LightCleanUp lightCleanUp = new LightCleanUp(program.sourceFolder);
                    lightCleanUp.createLightFolder(program.sourceFolder);
                    System.out.println("Files have been lightly organized");
                    break;
                default:
                    // Add your code here for other cases
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    

    
    }

        public void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to File Organizer!");
        System.out.println("Please select your plan (Light, Medium, Huge):");
        cleanUpLevel = scanner.nextLine();

        // System.out.println("Enter your local path:");
        // sourceFolder = scanner.nextLine();

        scanner.close();
    }

}
