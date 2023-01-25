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
 * allows sort method to compare race objects by CFR
 * @author Krishna Nair (krishnanair)
 * @version 2021.11.19
 * @author Ethan Triggiano (ethantrig)
 * @version 2021.11.19
 */
public class CompareByCFR implements Comparator<Race> {

    /**
     * returns a number denoting if race1 is greater than, 
     * less than or equal to based on CFR
     * @param race1 - first race being compared
     * @param race2 - second race being compared
     * @return 1, 0, or -1 based on CFR 
     */
    public int compare(Race race1, Race race2) {
        if (race1.getCFR() > race2.getCFR()) {
            return 1;
        }
        if (race1.getCFR() == race2.getCFR()) {
            return 0;
        }
        return -1;
    }
    
}
