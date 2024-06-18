package utils;

import java.util.Scanner;

import static constant.Constant.*;

public class AskingYesNoQuestion {
    public static boolean askYesNoQuestion(String confirmation){
        String[] yesValues = YES.split(",");
        return yesValues[INT_ZERO].equalsIgnoreCase(confirmation) || yesValues[INT_ONE].equalsIgnoreCase(confirmation);
    }

    public static boolean continueAction(Scanner scanner){
        System.out.println("Would you like to continue?" + ASKING_YES_NO);
        String confirmation = scanner.nextLine();
        return askYesNoQuestion(confirmation);
    }
}
