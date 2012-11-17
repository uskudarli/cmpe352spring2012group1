package querrygen;

import java.util.Collections;
import java.util.*;

/**
 *
 * @author Seckin Savasci
 */
public class QuerryGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello world");
        String[] priolist = new String[3];
        priolist[0] = "tag";
        priolist[1] = "title";
        priolist[2] = "`desc`"; // desc is a keyword in mysql



        System.out.println(searchQuerry("requested_services",
                priolist,
                "2012-1-1",
                "2013-1-1",
                "washing,dishes"));



    }

    public static String searchQuerry(String tableName, String[] fieldName, String begin_date, String end_date, String tags) {
        String result = "";
        String[] list = tags.split(",");
        //Syntatic Improvement
        //////////////////////////
        tags = tags.replaceAll("ing,", ",");
        tags = tags.replaceAll("ing$", "");
        tags = tags.replaceAll("es,", ",");
        tags = tags.replaceAll("es$", "");
        tags = tags.replaceAll("s,", ",");
        tags = tags.replaceAll("s$", "");
        ///////////////////////////
        tags = tags.replaceAll(",", "|");

        for (int k = 0; k < fieldName.length; k++) {
            for (int i = list.length; i > 0; i--) {
                result += "select * from \n ( select * from " + tableName + " where\n "
                        + "begin_date > '" + begin_date + "' \n"
                        + " and end_date < '" + end_date + "'\n"
                        + " and enabled = 1) as date_checked \n"
                        + " where " + fieldName[k] + " " + "rlike '(.*)";

                for (int j = 0; j < i; j++) {
                    result += "(" + tags + ")(.*)";
                }
                result += "'";
                if (i != 1) {
                    result += "\n union \n";
                }

            }
            if (k == fieldName.length - 1) {
                result += ";";
            } else {
                result += " \n union \n";
            }
        }
        return result;
    }
}
