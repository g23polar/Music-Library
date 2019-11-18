/**
 * 
 */
package prj5;

/**
 * @author SWAT Loaner
 *
 */
public class Song<T> implements Comparable<T> {
    private String artistName;
    private String songTitle;
    private int releaseYear;
    private String genre;
    private int numStudents;

    private int[] hearData; //NE, SE, rest, outside, compsci, eng, math, other, reading, art, sports, music
    private int[] likeData;

    public Song(String title, String artist, String genre, int year) {
        songTitle = title;
        artistName = artist;
        this.genre = genre;
        releaseYear = year;

        hearData = new int[12];
        likeData = new int[12];
    }

    public void addHear(int major, int region, int hobby) {
        if (major != -1) {
            hearData[major]++;
        }
        if (region != -1) {
            hearData[region + 4]++;
        }
        if (hobby != -1) {
            hearData[hobby + 8]++;
        }
    }
    
    public void addLike(int major, int region, int hobby) {
        if (major != -1) {
            likeData[major]++;
        }
        if (region != -1) {
            likeData[region + 4]++;
        }
        if (hobby != -1) {
            likeData[hobby + 8]++;
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
        
        return str.toString();
    }
    
    public String toStringMajor() {
        StringBuilder str = new StringBuilder();
        
        str.append("\nHeard\nComp Sci:");
        str.append(hearData[0]);
        str.append(" Other Eng:");
        str.append(hearData[1]);
        str.append(" Math/CMDA:");
        str.append(hearData[2]);
        str.append(" Other:");
        str.append(hearData[3]);
        
        return str.toString();
    }
    
    public String toStringRegion() {
        StringBuilder str = new StringBuilder();
        
        str.append("\nHeard\nNortheast:");
        str.append(hearData[0]);
        str.append(" Southeast:");
        str.append(hearData[1]);
        str.append(" Rest of US:");
        str.append(hearData[2]);
        str.append(" Outside of US:");
        str.append(hearData[3]);
        
        return str.toString();
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
        
        return str.toString();
    }

    @Override
    public int compareTo(T otherSong) {
        
        return 0;
    }
    





}
