// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Michael Beeson (mbeeson)
package prj5;

import student.TestCase;

/**
 * Tests the methods of the Song class.
 * @author Michael Beeson (mbeeson)
 * @version 2019.11.18
 *
 */
public class SongTest extends TestCase {
    
    private Song song1;
    
    /**
     * sets up the conditions for each test
     */
    public void setUp() {
        song1 = new Song("titleA", "artistA", "genreA", "2000");
    }
    
    /**
     * tests the getter methods.
     */
    public void testGetters() {
        assertEquals("titleA", song1.getTitle());
        assertEquals("artistA", song1.getArtist());
        assertEquals("genreA", song1.getGenre());
        assertEquals("2000", song1.getYear());
    }
    
    /**
     * tests the addHear method.
     */
    public void testAddHear() {
        song1.addHear(0, 1, 2);
        assertEquals(1, song1.getNumStudents());
        assertEquals(1, song1.getHearData()[0]);
        assertEquals(0, song1.getHearData()[1]);
        assertEquals(0, song1.getHearData()[2]);
        assertEquals(0, song1.getHearData()[3]);
        assertEquals(0, song1.getHearData()[4]);
        assertEquals(1, song1.getHearData()[5]);
        assertEquals(0, song1.getHearData()[6]);
        assertEquals(0, song1.getHearData()[7]);
        assertEquals(0, song1.getHearData()[8]);
        assertEquals(0, song1.getHearData()[9]);
        assertEquals(1, song1.getHearData()[10]);
        assertEquals(0, song1.getHearData()[11]);
    }
    
    /**
     * tests the addLike method.
     */
    public void testAddLike() {
        song1.addLike(3, 2, 0);
        assertEquals(1, song1.getNumStudents());
        assertEquals(0, song1.getLikeData()[0]);
        assertEquals(0, song1.getLikeData()[1]);
        assertEquals(0, song1.getLikeData()[2]);
        assertEquals(1, song1.getLikeData()[3]);
        assertEquals(0, song1.getLikeData()[4]);
        assertEquals(0, song1.getLikeData()[5]);
        assertEquals(1, song1.getLikeData()[6]);
        assertEquals(0, song1.getLikeData()[7]);
        assertEquals(1, song1.getLikeData()[8]);
        assertEquals(0, song1.getLikeData()[9]);
        assertEquals(0, song1.getLikeData()[10]);
        assertEquals(0, song1.getLikeData()[11]);
    }
   
    /**
     * tests the toString method.
     */
    public void testToString() {
        assertEquals("Song Title: titleA\nSong Artist: artistA\nSong Genre: "
            + "genreA\nSong Year: 2000", song1.toString());
    }
    
    /**
     * tests the toStringMajor method.
     */
    public void testToStringMajor() {
        song1.addHear(0, 1, 2);
        song1.addLike(-1, -1, -1);
        song1.addHear(3, 2, 0);
        song1.addLike(3, 2, 0);
        
        assertEquals("Song Title: titleA\nSong Artist: artistA\nSong Genre: "
            + "genreA\nSong Year: 2000\nHeard\nComp Sci:1 Other Eng:0 Math/CMD"
            + "A:0 Other:1\nLikes\nComp Sci:0 Other Eng:0 Math/CMDA:0 Other:1",
            song1.toStringMajor());
    }
    
    /**
     * tests the toStringRegion method.
     */
    public void testToStringRegion() {
        song1.addHear(0, 1, 2);
        song1.addLike(-1, -1, -1);
        song1.addHear(3, 2, 0);
        song1.addLike(3, 2, 0);
        
        assertEquals("Song Title: titleA\nSong Artist: artistA\nSong Genre: "
            + "genreA\nSong Year: 2000\nHeard\nNortheast:0 Southeast:1 Rest of"
            + " US:1 Outside of US:0\n"
            + "Likes\nNortheast:0 Southeast:0 Rest of US:1 Outside of US:0", 
            song1.toStringRegion());
    }
    
    /**
     * tests the toStringHobby method.
     */
    public void testToStringHobby() {
        song1.addHear(0, 1, 2);
        song1.addLike(-1, -1, -1);
        song1.addHear(3, 2, 0);
        song1.addLike(3, 2, 0);
        
        assertEquals("Song Title: titleA\nSong Artist: artistA\nSong Genre: "
            + "genreA\nSong Year: 2000\nHeard\nreading:1 art:0 "
            + "sports:1 music:0\n"
            + "Likes\nreading:1 art:0 sports:0 music:0", 
            song1.toStringHobby());
    }
    
    /**
     * tests the compareTo method.
     */
    public void testCompareTo() {
        Song song2 = new Song("titleB", "artistB", "genreB", "2000");
        Song song3 = new Song("titleC", "artistC", "genreC", "2000");
        assertTrue(song2.compareTo(song3) < 0);
        assertTrue(song2.compareTo(song1) > 0);
        assertTrue(song2.compareTo(song2) == 0);
        assertEquals(2, song3.compareTo(song1));
    }
    
    
    
    

}