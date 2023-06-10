package EstTimezone.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XmlGregorianCalenderExamples {
    private final static String TIMESTAMP_PATTERN
            ="MM/dd/yyyy hh:mm a z";
    private final static DateTimeFormatter FORMATTER
            =DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN);

    @SuppressWarnings("unused")
    public static void main(final String[] args) throws DatatypeConfigurationException {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime( new Date());
        XMLGregorianCalendar xCal = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(cal);

        XMLGregorianCalendar xmlGregorianCalendar =
                DatatypeFactory.newInstance()
                        .newXMLGregorianCalendar(LocalDate.now().toString());
        System.out.println(xCal);

        Date date = xCal.toGregorianCalendar().getTime();
        System.out.println(date);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");
        String formattedString = df.format(date);
        System.out.println(formattedString);

        TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
        df.setTimeZone(gmtTimeZone);
        System.out.println(df.format(date));

        ZonedDateTime zdt = xCal.toGregorianCalendar().toZonedDateTime();
        System.out.println(FORMATTER.format(zdt));

        DateFormat dateFormat = new SimpleDateFormat(TIMESTAMP_PATTERN);
        formattedString =
                dateFormat.format(xCal.toGregorianCalendar().getTime());
        System.out.println(formattedString);



    }
}
