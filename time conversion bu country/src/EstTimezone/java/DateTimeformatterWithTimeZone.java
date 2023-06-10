package EstTimezone.java;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeformatterWithTimeZone {
    private static  final String DT_PATTERN = "dd/MM/YYYY HH:mm z";

    public static void main(String[] args) {
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern(DT_PATTERN);

        ZonedDateTime zdt = ZonedDateTime.now();

        String localizedDateTime = dtFormatter.format(zdt);
        System.out.println(localizedDateTime);

        String localizedDateTimeInUTC = dtFormatter.format(zdt.withZoneSameInstant(ZoneId.of("UTC-4")));
        System.out.println(localizedDateTimeInUTC);



    }
}
