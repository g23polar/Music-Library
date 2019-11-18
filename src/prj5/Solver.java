/**
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself 
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor 
 * will I accept the actions of those who do.
 * Nikolai Long (nikolai)
 */
package prj5;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Nikolai Long (nikolai)
 * @version Nov 17, 2019
 *
 * Solver Class
 */
public class Solver
{
    private DLinkedSongs songs;
    
    public Solver(DLinkedSongs songs)
    {
        this.songs = songs;
    }
    
    public DLinkedSongs getSongs()
    {
        return songs;
    }
    
    public void insertionSort2(DLinkedSongs songList, Comparator<Song> comp) {
        DLinkedSongs cloneList = songList;
        Iterator oldIter = cloneList.iterator();
        Iterator sortedIter;
        
        if (!oldIter.hasNext()) {
            return;
        }
        songList.clear();
        //add first item to sort
        songList.add(0, oldIter.next());
        oldIter.remove();
        
        while (oldIter.hasNext()) {
            Song hold = (Song)oldIter.next();
            oldIter.remove();
            
            sortedIter = songList.iterator();
            int sortedCount = 0;
            
            while (sortedIter.hasNext()) {
                
                Song currentSorted = (Song)sortedIter.next();
                
                if (comp.compare(hold, currentSorted) > 0) {
                    break;
                }
                sortedCount++;
            }
            songList.add(sortedCount - 1, hold);
            
        }
        
    }
}
