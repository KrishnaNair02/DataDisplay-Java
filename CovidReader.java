// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- Krishna Nair (krishnanair)
// -- Ethan Triggiano (ethantrig)
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Krishna Nair (krishnanair)
 * @version 2021.11.19
 * @author Ethan Triggiano (ethantrig)
 * @version 2021.11.19
 */
public class CovidReader {
    
    /**
     * Fields
     */
    private Location[] states;
    
    /**
     * new CovidReader Objects
     * @param covidDatabase - file that will be scanned
     * @throws FileNotFoundException - thrown if file not found
     * @throws ParseException - thrown if data isn't correctly input
     */
    public CovidReader(String covidDatabase) throws FileNotFoundException, ParseException {
        states = readStates(covidDatabase);
    }
    
    private Location[] readStates(String covidDatabase) throws FileNotFoundException, ParseException {
        Location[] locations = new Location[6];
        Scanner s = new Scanner(new File(covidDatabase));
        String[] line = new String[11];
        int count = 0;
        if (s.hasNext()) {
            s.nextLine();
        }
        while (s.hasNextLine()) {
            line = getRecordFromLine(s.nextLine());
            locations[count] = new Location(line[0], readRaces(line));
            count++;
        }
        s.close();
        return locations;
    }
    
    @SuppressWarnings("resource")
    private String[] getRecordFromLine(String next) {
        String[] values = new String[11];
        Scanner s = new Scanner(next);
        s.useDelimiter(",");
        int count = 0;
        while (s.hasNext()) {
            values[count] = s.next();
            count++;
        }
        s.close();
        return values;
    }
    
    private LinkedList<Race> readRaces(String[] line) {
        String[] newLine = convertNA(line);
        LinkedList<Race> races = new LinkedList<Race>();
        races.add(new Race("Asian", Integer.parseInt(newLine[4]), Integer.parseInt(newLine[9])));
        races.add(new Race("Black", Integer.parseInt(newLine[2]), Integer.parseInt(newLine[7])));
        races.add(new Race("LatinX", Integer.parseInt(newLine[3]), Integer.parseInt(newLine[8])));
        races.add(new Race("Other", Integer.parseInt(newLine[5]), Integer.parseInt(newLine[10])));
        races.add(new Race("White", Integer.parseInt(newLine[1]), Integer.parseInt(newLine[6])));
        return races;
    }
    
    private String[] convertNA(String[] line) {
        for (int i = 0; i < line.length; i++) {
            if (line[i].equalsIgnoreCase("NA")) {
                line[i] = "-1";
            }
        }
        return line;
    }
    
    /**
     * returns the list of Locations
     * @return the list of Locations
     */
    public Location[] getLocations()
    {
        return states;
    }
}
