package bridgelabz.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    /**
     * Method for finding day of week by taking date as input parameter.
     * @param userInput : Date of the day.
     * @return : Week Day lies on input date.
     */
    public static String findWeekDay(String userInput){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String result = "";
        try {
            Date date = sdf.parse(userInput);
            sdf = new SimpleDateFormat("EEEE");
            result = sdf.format(date);
        } catch (ParseException e) {
            System.out.println("Parse Exception");
        }
        return  result;
    }
}
