import java.util.Scanner;

public class UserInputRetriever {

    private Scanner input;

    public UserInputRetriever() {
        input = new Scanner(System.in);
    }

    int getIntInput(int min, int max) {
        boolean validInput = false;
        int output = -1;
        while(!validInput) {
            try {
                output = input.nextInt();
                if(output >= min && output <= max) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input (invalid range).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input (integer expected).");
                input.nextLine();
            }
        }
        return output;
    }

}
