// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- Krishna Nair (krishnanair)
// -- Ethan Triggiano (ethantrig)
package prj5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 * compiles and runs the program
 * @author Krishna Nair (krishnanair)
 * @version 2021.11.19
 * @author Ethan Triggiano (ethantrig)
 * @version 2021.11.19
 */
public class Input {

    /**
     * new projectrunner object
     */
    public Input()
    {
        
    }
    
    /**
     * Sets up the environment of the program
     * allowing it to be interacted with
     * @param args
     *          arguments to set up specific instance
     */
    public static void main(String[] args) 
        throws IOException
    {
        try
        {
            if (args.length == 1)
            {
                CovidReader c1 = new CovidReader(args[0]);
                GUICovidWindow cw1 = new GUICovidWindow(c1.getLocations());
            }
            else
            {
                CovidReader c2 = new CovidReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
                GUICovidWindow cw2 = new GUICovidWindow(c2.getLocations());
            }
        }
        catch (ParseException e)
        {
            System.out.println("Parse Exception Caught");
        }
    }
}
