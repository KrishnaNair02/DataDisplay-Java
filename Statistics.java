// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- Krishna Nair (krishnanair)
// -- Ethan Triggiano (ethantrig)
package prj5;

/**
 * Class that holds cases and deaths statistics
 * @author Krishna Nair (krishnanair)
 * @version 2021.11.19
 * @author Ethan Triggiano (ethantrig)
 * @version 2021.11.19
 *
 */
public class Statistics {

    private double raceCases;
    private double raceDeaths;
    
    /**
     * new Statistics object
     * @param cases - number of cases
     * @param deaths - number of deaths
     */
    public Statistics(double cases, double deaths)
    {
        raceCases = cases;
        raceDeaths = deaths;
    }
    
    /**
     * returns the number of cases
     * @return the number of cases
     */
    public double getCases()
    {
        return raceCases;
    }
    
    /**
     * returns the number of deaths
     * @return the number of deaths
     */
    public double getDeaths()
    {
        return raceDeaths;
    }
    
    /**
     * string representation of Statistics
     * @return the string form of Statistics
     */
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("Cases: ");
        string.append(getCases());
        string.append(", Deaths: ");
        string.append(getDeaths());
        return string.toString();
    }
}
