import constant.Constant;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (isContinue) {
                try {
                    MainMenu.displayChoices();
                    System.out.println(Constant.WELCOME_CHOOSE_OPTION_MESSAGE);
                    int choice = Integer.parseInt(scanner.nextLine());
                    isContinue = MainMenu.execute(scanner, choice);
                } catch (NumberFormatException ex) {
                    System.out.println(Constant.CHOOSE_MAIN_MENU_OPTION_MESSAGE);
                }
            }
        } catch (Exception ex) {
            System.out.println(Constant.EXIT_PROGRAM_MESSAGE);
        }
    }
}
