package team.bileton.application.gui;

import lombok.Getter;
import team.bileton.application.Bileton;
import team.bileton.application.gui.interfaces.Gui;

import java.util.InputMismatchException;
import java.util.Scanner;

@Getter
public class BaseGui implements Gui {

    private Bileton app = Bileton.getInstance();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void onEnter() {

    }

    public int selectOption() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[i] Input Mismatch Error! Write number");
            System.out.print("Select a option :/ ");

            scanner.nextLine();
            return -1;
        }
    }

}
