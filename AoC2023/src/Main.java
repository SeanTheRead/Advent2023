import aoc.objects.Elevator;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Please enter the instructions so Santa can find out which floor to go to:");
        Elevator elevator = new Elevator(0);
        //get the instructions
        Scanner userInput = new Scanner(System.in);
        String instructions = userInput.nextLine();

        //figure out which floor Santa goes to
        instructions.chars()
                .mapToObj(i -> (char) i)
                .forEach(elevator::takeElevator);

        System.out.println("Santa is currently on floor number: "+elevator.getCurrentFloor());
    }


}