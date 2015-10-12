package step_definitions;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.fest.assertions.Assertions.assertThat;


/**
 *
 */
public class DateFormatExploration {


    @Test
    public void formats_dates() {

        //Given
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2012, 01 -1, 14, 0, 0, 0);
        Date date = gregorianCalendar.getTime();
        //When
        String format = formatDate(date);
        //then
        assertThat(format).isEqualTo("14/01/2012");
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}