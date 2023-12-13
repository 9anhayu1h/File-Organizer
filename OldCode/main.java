package OldCode;
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
                    lightCleanUp.CleanUpLightly(program.sourceFolder);
                    System.out.println("Files have been lightly organized.");
                    break;

                case "Normal":

                    MediumCleanUp mediumCleanUp = new MediumCleanUp(program.sourceFolder);
                    mediumCleanUp.CleanUpNormally(program.sourceFolder);
                    System.out.println("Files have been normally organized.");
                    break;

                case "Huge":

                    HugeCleanUp hugeCleanUp = new HugeCleanUp(program.sourceFolder);
                    hugeCleanUp.CleanUpProfessionally(program.sourceFolder);
                    System.out.println("Files have been deeply organized.");

                default:
                    System.out.println("Invalid plan. Files will not be organized.");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    public void getUserInput() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to File Organizer!");
    System.out.println("Please select your plan (Light, Normal, Huge):");
    cleanUpLevel = scanner.nextLine();

    // System.out.println("Enter your local path:");
    // sourceFolder = scanner.nextLine();

    scanner.close();
    }

}
