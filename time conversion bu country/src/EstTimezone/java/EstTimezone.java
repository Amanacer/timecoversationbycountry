package EstTimezone.java;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class EstTimezone {

    public static void main(String[] args) {

        DateTimeFormatter globalformat = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma z");
        DateTimeFormatter etFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma 'ET' ");

        ZonedDateTime currentISTime = ZonedDateTime.now();
        ZonedDateTime currentETime = currentISTime
                .withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(globalformat.format(currentETime));
        System.out.println(etFormat.format(currentETime));

        SimpleDateFormat etDf = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mma 'ET'");
        TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");
        etDf.setTimeZone(etTimeZone);

        Date currentDate = new Date();
        Calendar currentTime = Calendar.getInstance();

        System.out.println(etDf.format(currentDate.getTime()));
        System.out.println(etDf.format(currentDate.getTime()));

    }
}
