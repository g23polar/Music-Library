// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Michael Beeson (mbeeson)
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

public class DLinkedSongsTest extends TestCase {

    private DLinkedSongs<Song> songs;
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    /**
     * sets up the conditions for each test
     */
    public void setUp() {
        songs = new DLinkedSongs<Song>();

        song1 = new Song("AAA", "artistB", "genreC", "2004");
        song2 = new Song("BBB", "artistC", "genreD", "2003");
        song3 = new Song("CCC", "artistD", "genreA", "2002");
        song4 = new Song("DDD", "artistA", "genreB", "2001");

        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
    }

    public void testIterator() {
        Exception exception = null;
        Iterator iter = songs.iterator();

        assertTrue(iter.hasNext());
        try {
            iter.remove();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        iter.next();
        iter.remove();
        assertFalse(songs.contains(song1));
        assertTrue(songs.contains(song2));

        songs.clear();
        iter = songs.iterator();
        try {
            iter.next();
        }
        catch (Exception d) {
            exception = d;
        }
        assertTrue(exception instanceof NoSuchElementException);
    }

    public void testClearAndInit() {
        assertFalse(songs.isEmpty());
        songs.clear();
        assertTrue(songs.isEmpty());
    }

    public void testSize() {
        assertEquals(4, songs.size());
        songs.add(song1);
        assertEquals(5, songs.size());

        Iterator iter = songs.iterator();
        iter.next();
        iter.remove();
        assertEquals(4, songs.size());
    }

    public void testLastIndexOf() {
        Song song5 = new Song("DDD", "artistA", "genreB", "2001");

        assertEquals(-1, songs.lastIndexOf(song5));
        assertEquals(3, songs.lastIndexOf(song4));
        songs.add(song4);
        assertEquals(4, songs.lastIndexOf(song4));

    }

    public void testGetData() {
        assertEquals(song2, songs.getData(1));
        Exception exception = null;
        try {
            songs.getData(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }

    public void testAdd() {
        assertEquals(3, songs.lastIndexOf(song4));
        songs.add(song4);
        assertEquals(4, songs.lastIndexOf(song4));
        
        Exception exception = null;
        try {
            songs.add(-1, song1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        try {
            songs.add(6, song1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try {
            songs.add(2, null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        
        songs.add(2, song1);
        assertEquals(2, songs.lastIndexOf(song1));
    }
    
    public void testIterator2() {
        Iterator iter = songs.iterator();
        assertTrue(iter.hasNext());
        songs.clear();
        assertTrue(iter.hasNext());
        iter.next();
        iter.next();
        iter.next();
        assertTrue(iter.hasNext());
        
    }





}