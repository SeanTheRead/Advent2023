package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.entry;

public class CalibrationDocument {
    private List<String> lines;
    List<Integer> calibrationValues = new ArrayList<Integer>();
    private static final String INT_REGEX = "one|two|three|four|five|six|seven|eight|nine|\\d";
    private static final Map<String, Integer> INT_MAP = Map.ofEntries(
            entry("one",1),entry("1",1),
            entry("two",2),entry("2",2),
            entry("three",3),entry("3",3),
            entry("four",4),entry("4",4),
            entry("five",5),entry("5",5),
            entry("six",6),entry("6",6),
            entry("seven",7),entry("7",7),
            entry("eight",8),entry("8",8),
            entry("nine",9),entry("9",9)
    );





    public CalibrationDocument(List<String> lines){
        this.lines=lines;
        this.fillCalibrationValues();
    }

    public void fillCalibrationValues(){
        Pattern digitRegex = Pattern.compile(INT_REGEX);
        for(String line:lines){
            Matcher digitFinder = digitRegex.matcher(line);
            Integer firstDigit = null;
            Integer secondDigit = null;
            if(digitFinder.find()){
                firstDigit =  INT_MAP.get(digitFinder.group());
                secondDigit =  INT_MAP.get(digitFinder.group());

            }
            //get last digit
            while(digitFinder.find()){
                secondDigit =  INT_MAP.get(digitFinder.group());
            }
            if(firstDigit!=null&&secondDigit!=null){
                this.calibrationValues.add(Integer.valueOf(firstDigit.toString()+secondDigit.toString()));
            }

        }
    }

    public List<Integer> getCalibrationValues(){
        return this.calibrationValues;
    }

}
