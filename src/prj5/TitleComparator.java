/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Michael Beeson (mbeeson)
 * @version 2019.11.18
 * Class that implements Comparator<T> to compare song objects in various 
 * ways
 */
public class TitleComparator<T> implements Comparator<T> {

    @Override
    public int compare(T arg0, T arg1) {
        return 0;
    }
    
    public int compareTitle(Song song1, Song song2) {
        return song1.getTitle().compareToIgnoreCase(song2.getTitle());
    }
    
    public int compareGenre(Song song1, Song song2) {
        return song1.getGenre().compareToIgnoreCase(song2.getGenre());
    }
    
    public int compareYear(Song song1, Song song2) {
        return song1.getYear().compareToIgnoreCase(song2.getYear());
    }

    
}
