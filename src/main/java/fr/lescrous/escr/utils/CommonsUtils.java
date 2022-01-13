package fr.lescrous.escr.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Commons utils.
 */
public class CommonsUtils {

    /**
     * Gets pic etablissement from escn.
     *
     * @param input the input
     * @return the pic etablissement from escn
     */
    public static Integer getPicEtablissementFromEscn(String input) {
        String picStr = "";
        Integer pic = null;
        if (input.length() > 9)
        {
            picStr = input.substring(input.length() - 9);
        }
        else
        {
            picStr = input;
        }

        if (StringUtils.isNumeric(picStr)) {
            pic = Integer.valueOf(picStr);
        }

        return pic;
    }

    /**
     * Gets timestamp from string.
     *
     * @param value the value
     * @return the timestamp from string
     * @throws ParseException the parse exception
     */
    public static Timestamp getTimestampFromString(String value) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date parsedDate = dateFormat.parse(value);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        return  timestamp;
    }

}
