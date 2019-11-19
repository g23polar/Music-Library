// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Michael Beeson (mbeeson)
package prj5;

import student.TestCase;

public class SolverTest extends TestCase {
    private DLinkedSongs<Song> songs;
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    private Solver solver;

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

        solver = new Solver(songs);

    }

    public void testInsertion() {
        solver.insertionSort(songs, 1);

        assertEquals(song4, songs.getData(0));
        assertEquals(song1, songs.getData(1));
        assertEquals(song2, songs.getData(2));
        assertEquals(song3, songs.getData(3));
        assertEquals(4, songs.size());

        solver.insertionSort(songs, 0);

        assertEquals(song1, songs.getData(0));
        assertEquals(song2, songs.getData(1));
        assertEquals(song3, songs.getData(2));
        assertEquals(song4, songs.getData(3));
        assertEquals(4, songs.size());
        
        solver.insertionSort(songs, 2);

        assertEquals(song3, songs.getData(0));
        assertEquals(song4, songs.getData(1));
        assertEquals(song1, songs.getData(2));
        assertEquals(song2, songs.getData(3));
        assertEquals(4, songs.size());
        
        solver.insertionSort(songs, 3);

        assertEquals(song4, songs.getData(0));
        assertEquals(song3, songs.getData(1));
        assertEquals(song2, songs.getData(2));
        assertEquals(song1, songs.getData(3));
        assertEquals(4, songs.size());

        songs = new DLinkedSongs<Song>();

        song1 = new Song("AAA", "D", "genreC", "2004");
        song2 = new Song("BBB", "B", "genreD", "2003");
        song3 = new Song("CCC", "E", "genreA", "2002");
        song4 = new Song("DDD", "F", "genreB", "2001");
        Song song5 = new Song("DDD", "C", "genreB", "2001");
        Song song6 = new Song("DDD", "A", "genreB", "2001");

        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);

        solver = new Solver(songs);
        solver.insertionSort(songs, 1);

        assertEquals(song6, songs.getData(0));
        assertEquals(song2, songs.getData(1));
        assertEquals(song5, songs.getData(2));
        assertEquals(song1, songs.getData(3));
        assertEquals(song3, songs.getData(4));
        assertEquals(song4, songs.getData(5));
        assertEquals(6, songs.size());
    }

}
