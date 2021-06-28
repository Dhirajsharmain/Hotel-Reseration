package bridgelabz.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    public static long dayBetweenDates(String inputString1, String inputString2){
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        long difference = 0;
        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            difference = date2.getTime() - date1.getTime();
            System.out.println ("Days: " + TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return difference;
    }
}
