// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- Krishna Nair (krishnanair)
// -- Ethan Triggiano (ethantrig)
package prj5;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import cs2.Button;
import cs2.Shape;
/**
 * @author Krishna Nair (krishnanair)
 * @author Ethan Triggiano (ethantrig)
 * @version 12.1.2021
 * Creates the GUI for the project
 */
public class GUICovidWindow {

    private Window window;
    private Button md;
    private Button nc;
    private Button va;
    private Button dc;
    private Button ga;
    private Button tn;
    private String title;
    private Location[] states;
    private Location current;
    
    private static final double DISPLAY_FACTOR = 25;
    private static final int BAR_WIDTH = 20;
    
    /**
     * new CovidWindow object
     * @param stateList
     *          the list of locations that the window will
     *          interact with
     */
    public GUICovidWindow(Location[] stateList)
    {
        states = stateList;
        current = states[0];
        window = new Window();
        window.setTitle(
            "Covid Stats of Each Race by Location (krishnanair ethantrig)");
        md = new Button("MD");
        md.onClick(this, "clickedMD");
        
        nc = new Button("NC");
        nc.onClick(this, "clickedNC");

        va = new Button("VA");
        va.onClick(this, "clickedVA");
        
        dc = new Button("DC");
        dc.onClick(this, "clickedDC");
        
        ga = new Button("GA");
        ga.onClick(this, "clickedGA");
        
        tn = new Button("TN");
        tn.onClick(this, "clickedTN");
        
        Button cfr = new Button("Sort by CFR");
        cfr.onClick(this, "clickedCFR");
        
        Button alpha = new Button("Sort by Alpha");
        alpha.onClick(this, "clickedAlpha");
        
        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        
        window.addButton(dc, WindowSide.SOUTH);
        window.addButton(ga, WindowSide.SOUTH);
        window.addButton(md, WindowSide.SOUTH);
        window.addButton(nc, WindowSide.SOUTH);
        window.addButton(tn, WindowSide.SOUTH);
        window.addButton(va, WindowSide.SOUTH);
        window.addButton(alpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(cfr, WindowSide.NORTH);
        
        setCurrentState(dc);
        title = current.getName() + " Case Fatality Ratios by Race";
        draw(current.getRaces());
        
    }
    
    /**
     * clears the window
     */
    public void clear() {
        window.removeAllShapes();
    }
    
    /**
     * sets which state will be displayed on the window
     * @param button
     *          button that is pressed
     */
    public void setCurrentState(Button button) {
        for (int i = 0; i < states.length; i++) {
            if (states[i].getName().equalsIgnoreCase(
                button.getTitle().substring(0))) {
                current = states[i];
                break;
            }
        }
    }
    
    /**
     * draws the shaped on the window
     * @param x
     *          the LinkedList of races that
     *          the method will use to draw the shapes
     */
    public void draw(LinkedList<Race> x) {
        window.addShape(new TextShape(175, 20, title));
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getFormatCFR().equals("-1")) {
                window.addShape(new TextShape(125 + (i * 75),
                    250, x.get(i).getName()));
                window.addShape(new TextShape(125 + (i * 75),
                    235, "NA"));
            }
            else {
                window.addShape(new TextShape(125 + (i * 75),
                    250, x.get(i).getName()));
                window.addShape(new TextShape(125 + (i * 75),
                    270, "" + x.get(i).getFormatCFR() + "%"));
                window.addShape(new Shape(130 + (i * 75), 250 - 
                    (int)(DISPLAY_FACTOR * x.get(i).getCFR()), 
                    BAR_WIDTH, (int)(DISPLAY_FACTOR *
                        x.get(i).getCFR())));
            }
        }
    }
    
    /**
     * will display the graph of MD's covid stats
     * @param button
     *          MD button
     */
    public void clickedMD(Button button)
    {
        clear();
        if (button.toString().substring(0).
            equalsIgnoreCase(md.toString().substring(0))) {
            setCurrentState(md);
            title = current.getName() + " Case Fatality Ratios by Race";
            draw(current.getRaces());
        }
    }
    
    /**
     * will display the graph of NC's covid stats
     * @param button
     *          NC button
     */
    public void clickedNC(Button button)
    {
        clear();
        if (button.toString().substring(0).
            equalsIgnoreCase(nc.toString().substring(0))) {
            setCurrentState(nc);
            title = current.getName() + " Case Fatality Ratios by Race";
            draw(current.getRaces());
        }
    }
    
    /**
     * will display the graph of VA's covid stats
     * @param button
     *          VA button
     */
    public void clickedVA(Button button)
    {
        clear();
        if (button.toString().substring(0).
            equalsIgnoreCase(va.toString().substring(0))) {
            setCurrentState(va);
            title = current.getName() + " Case Fatality Ratios by Race";
            draw(current.getRaces());
        }
    }
    
    /**
     * will display the graph of DC's covid stats
     * @param button
     *          DC button
     */
    public void clickedDC(Button button)
    {
        clear();
        if (button.toString().substring(0).
            equalsIgnoreCase(dc.toString().substring(0))) {
            setCurrentState(dc);
            title = current.getName() + " Case Fatality Ratios by Race";
            draw(current.getRaces());
        }
    }
    
    /**
     * will display the graph of GA's covid stats
     * @param button
     *          GA button
     */
    public void clickedGA(Button button)
    {
        clear();
        if (button.toString().substring(0).
            equalsIgnoreCase(ga.toString().substring(0))) {
            setCurrentState(ga);
            title = current.getName() + " Case Fatality Ratios by Race";
            draw(current.getRaces());
        }
    }
    
    /**
     * will display the graph of TN's covid stats
     * @param button
     *          TN button
     */
    public void clickedTN(Button button)
    {
        clear();
        if (button.toString().substring(0).
            equalsIgnoreCase(tn.toString().substring(0))) {
            setCurrentState(tn);
            title = current.getName() + " Case Fatality Ratios by Race";
            draw(current.getRaces());
        }
    }
    
    /**
     * will organize the graph in order of CFR
     * @param button
     *          CFR button
     */
    public void clickedCFR(Button button)
    {
        clear();
        current.getRaces().selectionSortCFR(
            current.getRaces().getHead(), new CompareByCFR());
        draw(current.getRaces());
    }
    
    /**
     * will organize the graph alphabetically
     * @param button
     *          Alpha button
     */
    public void clickedAlpha(Button button)
    {
        clear();
        current.getRaces().selectionSortAlpha(
            current.getRaces().getHead(), new CompareByAlpha());
        draw(current.getRaces());
    }
    
    /**
     * will close the program
     * @param button
     *          Quit button
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }
}

