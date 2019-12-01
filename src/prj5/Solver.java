/**
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 * Nikolai Long (nikolai)
 */
package prj5;

//import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Nikolai Long (nikolai)
 * @version Nov 17, 2019
 *
 *          Solver Class
 */
public class Solver
{
    @SuppressWarnings("rawtypes")
    private DLinkedSongs songs;

    /**
     * solver constructor
     * @param songs DLS to be used
     */
    public Solver(@SuppressWarnings("rawtypes") DLinkedSongs songs)
    {
        this.songs = songs;
    }

    /**
     * gets the songs DLS
     * @return the DLS
     */
    @SuppressWarnings("rawtypes")
    public DLinkedSongs getSongs()
    {
        return songs;
    }

    /**
     * sorts the song DLS
     * @param sortIndex type of sort
     */
    public void insertionSort(int sortIndex)
    {
        // create utilities
        @SuppressWarnings("rawtypes")
        Iterator iter = songs.iterator();
        DLinkedSongs<Song> newSongs = new DLinkedSongs<Song>();
        SongComparator<Song> comp = new SongComparator<Song>();
        
        // check if the list is empty
        if (!iter.hasNext())
        {
            return;
        }
        
        // add the first item
        newSongs.add(0, (Song)iter.next());

        // create utilities
        @SuppressWarnings("unused")
        int sortedCount = 1;
        @SuppressWarnings("rawtypes")
        Iterator sortedIter;
        
        // while the iterator has a next item
        while (iter.hasNext())
        {
            // hold the next song to be sorted
            Song hold = (Song)iter.next();
            // creates an iterator in the sorted list
            sortedIter = newSongs.iterator();
            // index stores the position the song should be added to
            // the sorted list
            int index = 0;
            // while the sorted iterator has a next item
            while (sortedIter.hasNext())
            {
                // gets the song from the sorted list
                Song currentSorted = (Song)sortedIter.next();
                // sorts based on the type of sort
                if (sortIndex == 0)
                {
                    if (comp.compareTitle(currentSorted, hold) > 0)
                    {
                        break;
                    }
                }
                if (sortIndex == 1)
                {
                    if (comp.compareArtist(currentSorted, hold) > 0)
                    {
                        break;
                    }
                }
                if (sortIndex == 2)
                {
                    if (comp.compareGenre(currentSorted, hold) > 0)
                    {
                        break;
                    }
                }
                if (sortIndex == 3)
                {
                    if (comp.compareYear(currentSorted, hold) > 0)
                    {
                        break;
                    }
                }
                // increases the index if the song should not be placed
                // at this index
                index++;
            }
            // adds the song to the sorted list at the correct index
            newSongs.add(index, hold);
            sortedCount++;
        }
        // copies the sorted list to the field songs
        songs.clear();
        songs = newSongs;
    }
}
