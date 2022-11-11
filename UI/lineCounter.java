package UI;

import java.io.*;
import java.util.*;

/**
 * This class counts the number of lines in a txt file
 */
public class lineCounter {

    /**
     * Constructor for lineCounter class
     */
    public lineCounter() {
    }

    /**
     * This method parses through every line in a txt file and increments a counter
     * 
     * @param f Input file to be scanned
     * @return Number of lines in a file
     */
    public int counter(File f) {
        int numLines = 0;
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                s.nextLine();
                numLines++;
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return numLines;
    }
}
