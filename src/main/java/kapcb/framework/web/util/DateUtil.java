package kapcb.framework.web.util;

import lombok.experimental.UtilityClass;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

/**
 * <a>Title: DateUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:54
 */
@UtilityClass
public class DateUtil {

    public static String format(@NonNull Date date, @NonNull String pattern) {
        return new DateTime(date).toString(pattern);
    }

    public static String format(@NonNull LocalDate localDate, @NonNull String pattern) {
        return new DateTime(localDate).toString(pattern);
    }

    public static String format(@NonNull LocalDateTime localDateTime, @NonNull String pattern) {
        return new DateTime(localDateTime).toString(pattern);
    }

    public static DateTime parseDateTime(@NonNull String dateTime, @NonNull String pattern, @NonNull Locale locale) {
        return DateTimeFormat.forPattern(pattern).withLocale(locale).parseDateTime(dateTime);
    }
}