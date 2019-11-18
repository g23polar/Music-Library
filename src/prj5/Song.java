/**
 * 
 */
package prj5;

/**
 * @author SWAT Loaner
 *
 */
public class Song implements Comparable<T> {
    private String artistName;
    private String songTitle;
    private int releaseYear;
    private String genre;
    private int numStudents;

    private int[] hearData;
    private int[] likeData;

    public Song(String title, String artist, String genre, int year) {
        songTitle = title;
        artistName = artist;
        this.genre = genre;
        releaseYear = year;

        hearData = new int[12];
        likeData = new int[12];
    }

    public void addHear(int hobby, int major, int region) {
        if (hobby != -1) {
            hearData[hobby]++;
        }
        if (major != -1) {
            hearData[major + 4]++;
        }
        if (region != -1) {
            hearData[region + 8]++;
        }
    }
    
    public void addLike(int hobby, int major, int region) {
        if (hobby != -1) {
            likeData[hobby]++;
        }
        if (major != -1) {
            likeData[major + 4]++;
        }
        if (region != -1) {
            likeData[region + 8]++;
        }
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("Song Title: ");
        str.append(songTitle);
        str.append("\nSong Artist: ");
        str.append(artistName);
        str.append("\nSong Genre: ");
        str.append(genre);
        str.append("\nSong Year: ");
        str.append(releaseYear);
    }
    
    public String toStringHobby() {
        StringBuilder str = new StringBuilder();
        
        str.append("\nHeard\nreading:");
        str.append(hearData[0]);
        str.append(" art:");
        str.append(hearData[1]);
        str.append(" sports:");
        str.append(hearData[2]);
        str.append(" music:");
        str.append(hearData[3]);
    }

    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        return 0;
    }
    





}
