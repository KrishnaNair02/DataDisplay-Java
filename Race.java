// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- Krishna Nair (krishnanair)
// -- Ethan Triggiano (ethantrig)
package prj5;
import java.text.DecimalFormat;

/**
 * Holds specific data for a given race
 * @author Krishna Nair (krishnanair)
 * @version 2021.11.19
 * @author Ethan Triggiano (ethantrig)
 * @version 2021.11.19
 */
public class Race {

    private String nameOfRace;
    private double caseNum;
    private double deathNum;
    private double theCFR;
    private String format;
    
    /**
     * new Race object
     * @param raceName - name of the race
     * @param cases - cases within the race
     * @param deaths - deaths within the race
     */
    public Race(String raceName, double cases, double deaths)
    {
        nameOfRace = raceName;
        caseNum = cases;
        deathNum = deaths;
        if (cases == -1 || deaths == -1) {
            theCFR = -1.0;
        }
        else {
            theCFR = deathNum / caseNum * 100;
        }
        DecimalFormat df = new DecimalFormat("#.#");
        format = df.format(theCFR);
    }
    
    /**
     * returns the cases of this race
     * @return the cases of this race
     */
    public int getCases() 
    {
        int theCases = (int) caseNum;
        return theCases;
    }
    
    /**
     * returns the CFR of this race, formatted properly
     * @return the CFR of this race, formatted properly
     */
    public String getFormatCFR() {
        return format;
    }
    
    /**
     * returns the deaths of this race
     * @return the deaths of this race
     */
    public double getDeath() {
        return deathNum;
    }
    
    /**
     * returns the name of this race
     * @return the name of this race
     */
    public String getName()
    {
        return nameOfRace;
    }
    
    /**
     * returns the CFR of this race
     * @return the CRF of this race
     */
    public double getCFR()
    {
        return theCFR;
    }
    
    /**
     * checks to see if obj is equal to this race
     * @param obj - object that this is being compared to
     * @return true or false if obj is equal or not
     */
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            Race temp = (Race)obj;
            if (this.getName().equals(temp.getName()) &&
                this.getCases() == temp.getCases() &&
                this.getDeath() == temp.getDeath()) {
                return true;
            }
        }
        return false;
    }

}
