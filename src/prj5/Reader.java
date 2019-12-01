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
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Nikolai Long (nikolai)
 * @version Nov 17, 2019
 *
 *          Reader Class
 */
public class Reader
{
    private DLinkedSongs<Song> songs;


    /**
     * Reader Constructor
     * 
     * @param songFile
     *            data file
     * @throws FileNotFoundException
     */
    public Reader(String songFile, String surveyFile)
        throws FileNotFoundException
    {
        songs = readSongs(songFile);
        readSurvey(surveyFile);
        Solver solv = new Solver(songs);
        GUIMusicWindow win = new GUIMusicWindow(solv);
    }


    /**
     * readSongs Method that creates a list of the
     * songs in the file
     * 
     * @param songFile
     *            data file
     * @return songs DLL
     * @throws FileNotFoundException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private DLinkedSongs readSongs(String songFile) throws FileNotFoundException
    {
        DLinkedSongs songs = new DLinkedSongs();
        File file = new File(songFile);
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(file);
        String[] strings = {};
        if (scan.hasNext())
        {
            scan.nextLine();
        }
        while (scan.hasNext())
        {
            strings = scan.nextLine().split(",");
            Song newSong = new Song(strings[0], strings[1], strings[2],
                strings[3]);
            songs.add(newSong);
            
        }
        return songs;
    }


    /**
     * readSurvey Method that uploads the survey
     * data into the songs DLL
     * 
     * @param surveyFile
     * @throws FileNotFoundException
     */
    private void readSurvey(String surveyFile) throws FileNotFoundException
    {
        if (songs == null)
        {
            throw new IllegalStateException();
        }
        File file = new File(surveyFile);
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(file);
        String[] strings =
        {};
        if (scan.hasNext())
        {
            scan.nextLine();
        }
        while (scan.hasNext())
        {
            strings = scan.nextLine().split(",");
            int[] categories = categories(strings);
            if (categories != null)
            {
                int song = 0;
                for (int count = 5; count < strings.length; count = count + 2)
                {
                    if (strings[count].equals("Yes") && strings.length > count + 1)
                    {
                        if (strings[count + 1].equals("Yes"))
                        {
                            // recorded as like
                            Song toAddto = (Song) songs.getData(song);
                            toAddto.addLike(categories[0], categories[1],
                                categories[2]);
                        }
                        else
                        {
                            // recorded as heard
                            Song toAddto = (Song) songs.getData(song);
                            toAddto.addHear(categories[0], categories[1],
                                categories[2]);
                        }
                    }
                    // else nothing is recorded
                    song++;
                }
            }
        }
        Song check = (Song) songs.getData(0);
    }

    /**
     * categories helper private method
     * @param strings the line of code to be used
     * @return the int array of they type of person this is
     */
    private int[] categories(String[] strings)
    {
        int[] re = new int[3];
        switch (strings[2])
        {
            case "Computer Science":
                re[0] = 0;
                break;
            case "Other Engineering":
                re[0] = 1;
                break;
            case "Math or CMDA":
                re[0] = 2;
                break;
            case "Other":
                re[0] = 3;
                break;
            default:
                return null;
        }
        switch (strings[3])
        {
            case "Northeast":
                re[1] = 0;
                break;
            case "Southeast":
                re[1] = 1;
                break;
            case "United States (other than Southeast or Northwest)":
                re[1] = 2;
                break;
            case "Outside of United States":
                re[1] = 3;
                break;
            default:
                return null;
        }
        switch (strings[4])
        {
            case "reading":
                re[2] = 0;
                break;
            case "art":
                re[2] = 1;
                break;
            case "sports":
                re[2] = 2;
                break;
            case "music":
                re[2] = 3;
                break;
            default:
                return null;
        }
        return re;
    }
    
    public DLinkedSongs<Song> getSongs()
    {
        return songs;
    }
     
    /**
     * to array method for toStringMajor
     * @return a string array of the songs
     */
    public String[] toArrayMajor()
    {
        int length = songs.size();
        String[] re = new String[length];
        for (int i = 0; i < length; i++)
        {
            re[i] = ((Song)songs.getData(i)).toStringMajor();
        }
        return re;
    }
    
    /**
     * to array method for toStringRegion
     * @return a string array of the songs
     */
    public String[] toArrayRegion()
    {
        int length = songs.size();
        String[] re = new String[length];
        for (int i = 0; i < length; i++)
        {
            re[i] = ((Song)songs.getData(i)).toStringRegion();
        }
        return re;
    }
    
    /**
     * to array method for toStringHobby
     * @return a string array of the songs
     */
    public String[] toArrayHobby()
    {
        int length = songs.size();
        String[] re = new String[length];
        for (int i = 0; i < length; i++)
        {
            re[i] = ((Song)songs.getData(i)).toStringHobby();
        }
        return re;
    }
}
