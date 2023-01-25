// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- Krishna Nair (krishnanair)
// -- Ethan Triggiano (ethantrig)
package prj5;


/**
 * Object that holds all the data for a given location
 * @author Krishna Nair (krishnanair)
 * @version 2021.11.19
 * @author Ethan Triggiano (ethantrig)
 * @version 2021.11.19
 *
 */
public class Location {

    private String name;
    private LinkedList<Race> raceList;
    
    /**
     * new Location object
     * @param n - name of location
     * @param list - list of all of the races (and their data)
     */
    public Location(String n, LinkedList<Race> list) {
        name = n;
        raceList = list;
    }
    
    
    /**
     * returns the name of the location
     * @return the name of the location
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * returns the Linked List of races
     * @return the Linked List of races
     */
    public LinkedList<Race> getRaces()
    {
        return raceList;
    }
}
