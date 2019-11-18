// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Michael Beeson (mbeeson)
package prj5;

/**
 * @author Michael Beeson (mbeeson)
 * @version 2019.11.18
 *
 */
public class Song<T> {
    private String artistName;
    private String songTitle;
    private String releaseYear;
    private String genre;
    private int numStudents;

    private int[] hearData; //NE, SE, rest, outside, compsci, eng, math, other, reading, art, sports, music
    private int[] likeData;

    /**
     * Creates a Song object with basic info fields and arrays of length 12
     * for survey hear and like data based on major, region, and hobby.
     * @param title the title
     * @param artist the artist name
     * @param genre the genre
     * @param year the year of release
     */
    public Song(String title, String artist, String genre, String year) {
        songTitle = title;
        artistName = artist;
        this.genre = genre;
        releaseYear = year;

        hearData = new int[12];
        likeData = new int[12];
    }
    
    /**
     * get the artist name of the song
     * @return the artist name
     */
    public String getArtist() {
        return artistName;
    }
    
    /**
     * get the title of the song
     * @return the song title
     */
    public String getTitle() {
        return songTitle;
    }

    /**
     * get the release year of the song
     * @return the release year
     */
    public String getYear() {
        return releaseYear;
    }
    
    /**
     * get the genre of the song
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * get the number of students for which the song has survey data.
     * @return the total number of students
     */
    public int getNumStudents() {
        return numStudents;
    }
    
    /**
     * get the hear student survey data
     * @return the array of hear data based on majors, regions, and hobbies
     */
    public int[] getHearData() {
        return hearData;
    }
    
    /**
     * get the like student survey data
     * @return the array of like data based on majors, regions, and hobbies
     */
    public int[] getLikeData() {
        return likeData;
    }
    
    /**
     * add to the hear data array for the students given major, region,
     * and hobby.  a parameter of -1 represents the student hasnt heard it.
     * @param major
     * @param region
     * @param hobby
     */
    public void addHear(int major, int region, int hobby) {
        if (major < -1 || major > 3) {
            throw new IllegalArgumentException("major must be between 0 & 3");
        }
        if (major != -1) {
            hearData[major]++;
        }
        
        if (region < -1 || region > 3) {
            throw new IllegalArgumentException("region must be between 0 & 3");
        }
        if (region != -1) {
            hearData[region + 4]++;
        }
        
        if (hobby < -1 || hobby > 3) {
            throw new IllegalArgumentException("hobby must be between 0 & 3");
        }
        if (hobby != -1) {
            hearData[hobby + 8]++;
        }
        numStudents++;
    }
    
    /**
     * add to the like data array for the students given major, region,
     * and hobby.  a parameter of -1 represents the student hasnt heard it.
     * @param major
     * @param region
     * @param hobby
     */
    public void addLike(int major, int region, int hobby) {
        if (major < -1 || major > 3) {
            throw new IllegalArgumentException("major must be between 0 & 3");
        }
        if (major != -1) {
            likeData[major]++;
        }

        if (region < -1 || region > 3) {
            throw new IllegalArgumentException("region must be between 0 & 3");
        }
        if (region != -1) {
            likeData[region + 4]++;
        }

        if (hobby < -1 || hobby > 3) {
            throw new IllegalArgumentException("hobby must be between 0 & 3");
        }
        if (hobby != -1) {
            likeData[hobby + 8]++;
        }
        numStudents++;
    }
    
    /**
     * sends the basic info of the song to a string.
     * @return the song info
     */
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
    
    /**
     * sends the hear and like data based on student major to a string.
     * @return the hear and like data based on major
     */
    public String toStringMajor() {
        StringBuilder str = new StringBuilder();
        str.append(toString());
        
        str.append("\nHeard\nComp Sci:");
        str.append(hearData[0]);
        str.append(" Other Eng:");
        str.append(hearData[1]);
        str.append(" Math/CMDA:");
        str.append(hearData[2]);
        str.append(" Other:");
        str.append(hearData[3]);
        str.append("\nLikes\nComp Sci:");
        str.append(likeData[0]);
        str.append(" Other Eng:");
        str.append(likeData[1]);
        str.append(" Math/CMDA:");
        str.append(likeData[2]);
        str.append(" Other:");
        str.append(likeData[3]);
        
        return str.toString();
    }
    
    /**
     * sends the hear and like data based on student major to a string.
     * @return the hear and like data based on major
     */
    public String toStringRegion() {
        StringBuilder str = new StringBuilder();
        str.append(toString());
        
        str.append("\nHeard\nNortheast:");
        str.append(hearData[4]);
        str.append(" Southeast:");
        str.append(hearData[5]);
        str.append(" Rest of US:");
        str.append(hearData[6]);
        str.append(" Outside of US:");
        str.append(hearData[7]);
        str.append("\nLikes\nNortheast:");
        str.append(likeData[4]);
        str.append(" Southeast:");
        str.append(likeData[5]);
        str.append(" Rest of US:");
        str.append(likeData[6]);
        str.append(" Outside of US:");
        str.append(likeData[7]);
        
        return str.toString();
    }
    
    /**
     * sends the hear and like data based on student major to a string.
     * @return the hear and like data based on major
     */
    public String toStringHobby() {
        StringBuilder str = new StringBuilder();
        str.append(toString());
        
        str.append("\nHeard\nreading:");
        str.append(hearData[8]);
        str.append(" art:");
        str.append(hearData[9]);
        str.append(" sports:");
        str.append(hearData[10]);
        str.append(" music:");
        str.append(hearData[11]);
        str.append("\nLikes\nreading:");
        str.append(likeData[8]);
        str.append(" art:");
        str.append(likeData[9]);
        str.append(" sports:");
        str.append(likeData[10]);
        str.append(" music:");
        str.append(likeData[11]);
        
        return str.toString();
    }


}
