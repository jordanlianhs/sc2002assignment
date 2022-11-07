package UI;

import java.io.*;
import java.util.*;

public class lineCounter {
    public lineCounter() {
    }

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
