// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- Krishna Nair (krishnanair)
// -- Ethan Triggiano (ethantrig)
package prj5;
import java.util.Comparator;

/**
 * allows sort method to compare the Race objects via their strings
 * @author Krishna Nair (krishnanair)
 * @version 2021.11.19
 * @author Ethan Triggiano (ethantrig)
 * @version 2021.11.19
 */
public class CompareByAlpha implements Comparator<Race> {
    /**
     * compares two race objects and returns a number based on 
     * alphabetical order
     * @param race1 - first race being compared
     * @param race2 - second race being compared
     * @return 0, -1, or 1 based on alphabetical order
     */
    public int compare(Race race1, Race race2) {
        if (race1.getName().compareTo(race2.getName()) < 0) {
            return 1;
        }
        if (race1.getName().compareTo(race2.getName()) == 0) {
            return 0;
        }
        return -1;
    }
}
