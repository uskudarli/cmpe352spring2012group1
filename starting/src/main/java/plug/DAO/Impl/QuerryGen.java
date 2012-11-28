package plug.DAO.Impl;

import java.util.Collections;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.jeremybrooks.knicker.AccountApi;
import net.jeremybrooks.knicker.Knicker;
import net.jeremybrooks.knicker.Knicker.RelationshipType;
import net.jeremybrooks.knicker.KnickerException;
import net.jeremybrooks.knicker.WordApi;
import net.jeremybrooks.knicker.dto.Related;
import net.jeremybrooks.knicker.dto.TokenStatus;

/**
 *
 * @author Seckin Savasci
 */
public class QuerryGen {

    /**
     * @param args the command line arguments
     */
    // example usage for searching in the given cols of the table
   /* public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello world");
        String[] priolist = new String[3];
        priolist[0] = "tag";
        priolist[1] = "title";
        priolist[2] = "`desc`"; // desc is a keyword in mysql and also a colname in our table


        System.out.println(searchQuerry("requested_services",
                priolist,
                "2012-1-1",
                "2013-1-1",
                tagQuerry("brownie")));
        //System.out.println(
        //tagQuerry("cake,cooking"));



    }*/
    // method that generates SQL string for given parameters
    public static String searchQuery(String tableName, String[] fieldName, String begin_date, String end_date, String tags,int cityId,int townId) {
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

                //for (int j = 0; j < i; j++) {
                //    result += "(" + tags + ")(.*)";
                //}
                result += "((" + tags + ")(.*)){"+Integer.toString(i)+"}";
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
    // returns semantic related tags in comma seperated form
    public static String tagQuery(String tags) {

        System.setProperty("WORDNIK_API_KEY", "d874cc25bbe666b1573050b7e6f00bfab8747812f1a6f9dc5");
        String allRelated = tags;
        String[] list = tags.split(",");
        List<Related> relationList;
        try {
            TokenStatus status = AccountApi.apiTokenStatus();
            if (status.isValid()) {
                System.out.println("API key is valid.");
            } else {
                System.out.println("API key is invalid!");
                System.exit(1);
            }

            for (String inputWord : list) {
                relationList = WordApi.related(inputWord);

                for (Related relation : relationList) {
                    System.out.println(relation.getRelType());

                    if (RelationshipType.hyponym.toString().equals(relation.getRelType())
                            || "verb-stem".equals(relation.getRelType())
                            || "equivalent".equals(relation.getRelType())
                            || "form".equals(relation.getRelType())
                            || "verb-form".toString().equals(relation.getRelType())
                            || "variant".equals(relation.getRelType())
                            || "same-context".toString().equals(relation.getRelType())) {

                        for (String word : relation.getWords()) {
                            allRelated = allRelated + "," + word;

                        }

                    }
                }

            }


        } catch (KnickerException ex) {
            Logger.getLogger(QuerryGen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allRelated;
    }
}
