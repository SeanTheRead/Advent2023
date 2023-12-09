import objects.CalibrationDocument;
import objects.CubeConundrum;
import objects.CubeGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        dayTwo();

    }

    public static void dayTwo(){
        CubeConundrum cubeConundrum = new CubeConundrum(":",";",",");
        cubeConundrum.loadGamesList("src/CubeGame.txt");
        //get total cubes in bag from input
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many blue cubes are there?");
        int blueCubes = userInput.nextInt();
        System.out.println("How many red cubes are there?");
        int redCubes = userInput.nextInt();
        System.out.println("How many green cubes are there?");
        int greenCubes = userInput.nextInt();
        userInput.close();

        System.out.println("Sum of minimum power: "+cubeConundrum.getSumMinimumPower()+System.lineSeparator());

    }



    private void dayOne(){
        System.out.println("Loading Calibration Document");


        try{
            CalibrationDocument calibrationDocument = new CalibrationDocument(Files.readAllLines(Paths.get("src/CalibrationDocument.txt")));
            List<Integer> calibrationValues = calibrationDocument.getCalibrationValues();
            //get the calibration value
            if(!calibrationValues.isEmpty()){
                Integer sum = calibrationValues.stream()
                        .reduce(0, Integer::sum);
                System.out.println("Calibration value is: "+sum.toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}