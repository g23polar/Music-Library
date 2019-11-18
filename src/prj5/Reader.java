/**
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself 
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor 
 * will I accept the actions of those who do.
 * Nikolai Long (nikolai)
 */
package prj5;

import java.io.File;
import java.util.Scanner;

/**
 * @author Nikolai Long (nikolai)
 * @version Nov 17, 2019
 *
 * Reader Class
 */
public class Reader
{
    private DLinkedSongs songs;
    
    /**
     * Reader Constructor
     * @param songFile data file
     */
    public Reader(String songFile, String surveyFile)
    {
        songs = readSongs(songFile);
        readSurvey(surveyFile);
        Solver solv = new Solver(songs);
        Window win = new Window(solv);
    }
    
    /**
     * readSongs Method that creates a list of the
     * songs in the file
     * @param songFile data file
     * @return songs DLL
     */
    public DLkinedSongs readSongs(String songFile)
    {
        DLinkedSongs songs = new DLinkedSongs();
        File file = new File(songFile);
        Scanner scan = new Scanner(file);
        String[] strings = {};
        if (scan.hasNext())
        {
            scan.hasNextLine();
        }
        int index = 0;
        while (scan.hasNext())
        {
            strings = scan.nextLine().split(",");
            songs[index] = new Song(strings[0], strings[1],
                strings[2], strings[3]);
            index++;
        }
        return songs;
    }
    
    /**
     * readSurvey Method that uploads the survey
     * data into the songs DLL
     * @param surveyFile
     */
    public void readSurvey(String surveyFile)
    {
        if (songs = null)
        {
            throw new IllegalStateException();
        }
        File file = new File(surveyFile);
        Scanner scan = new Scanner(file);
        String[] strings = {};
        if (scan.hasNext())
        {
            scan.hasNextLine();
        }
        int song = 0;
        while (scan.hasNext())
        {
            strings = scan.nextLine().split(",");
            int[] categories = categories(strings);
            for (int count = 5; count < strings.length; 
                count = count + 2)
            {
                if (strings[count].equals("No"))
                {
                    // nothing is recorded
                }
                else if (strings[count + 1].equals("No"))
                {
                    // nothing is recorded
                    
                }
                if (strings[count].equals("Yes"))
                {
                    if (strings[count + 1].equals("Yes"))
                    {
                        // recorded as like
                        songs[song].addLike(categories[0],
                            categories[1], categories[2]);
                    }
                    else
                    {
                        // recorded as heard
                        songs[song].addHear(categories[0],
                            categories[1], categories[2]);
                    }
                }
                // else nothing is recorded    
                song++;
            }
        }
    }
    
    private int[] categories(String[] strings)
    {
        int[] re = new int[3];
        if (strings[2].equals("Computer Science"))
        {
            re[0] = 0;
        }
        else if (strings[2].equals("Other Engineering"))
        {
            re[0] = 1;
        }
        else if (strings[2].equals("Math or CMDA"))
        {
            re[0] = 2;
        }
        else if (strings[2].equals("Other"))
        {
            re[0] = 3;
        }
        else
        {
            throw new IllegalArgumentException();
        }
        if (strings[3].equals("Northeast"))
        {
            re[1] = 0;
        }
        else if (strings[3].equals("Southeast"))
        {
            re[1] = 1;
        }
        else if (strings[3].equals("United States (other than " +
            "Southeast or Northwest"))
        {
            re[1] = 2;
        }
        else if (strings[3].equals("Outside of United States"))
        {
            re[1] = 3;
        }
        else
        {
            throw new IllegalArgumentException();
        }
        if (strings[4].equals("reading"))
        {
            re[2] = 0;
        }
        else if (strings[4].equals("art"))
        {
            re[2] = 1;
        }
        else if (strings[4].equals("sports"))
        {
            re[2] = 2;
        }
        else if (strings[4].equals("music"))
        {
            re[2] = 3;
        }
        else
        {
            throw new IllegalArgumentException();
        }
        return re;
    }
    
    public String toString()
    {
        StringBuilder build = new StringBuilder("[{");
        
        build.append("]");
        return build.toString();
    }
}
