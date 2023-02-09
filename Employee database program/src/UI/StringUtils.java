//Programmer: Samuel Greenlee
//Program: Java06 Program Assignment
//Description: This program allows
//	the user to read and write to
//	a database
//Date Created On: 4/30/2020

package UI;

public class StringUtils {

    public static String padWithSpaces(String s, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return s.substring(0, length);
        }
    }
}