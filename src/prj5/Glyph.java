package prj5;
import java.awt.Color;
import java.awt.color.*;

import CS2114.Shape;
import CS2114.TextShape;


public class Glyph {

    private Position position;
    private Shape[] bars;

    Shape shape;

    public static final int fac = 200; 

    public Glyph(Song<?> song, String repr, Position pos) {

        bars = new Shape[8]; 
        int [] hData = song.getHearData();
        int [] lData = song.getLikeData();
        
        switch (repr) {
            case "hobby":
                this.addHobbyBars(pos, song);
                
                break;
            case "major":
                this.addMajorBars(pos, song);
                break;
            case "region":
                this.addRegionBars(pos, song);
                break;
            default:
                System.out.println("Wrong choice glyph class");
        }
    }
    
    private void addRegionBars(Position pos, Song s) {
        bars[0] = new Shape(0, 0, fac * s.getHearData()[4]/s.getNumStudents(), 10, Color.PINK); 
        bars[1] = new Shape(0, 0, fac * s.getHearData()[5]/s.getNumStudents(), 10, Color.BLUE);
        bars[2] = new Shape(0, 0, fac * s.getHearData()[6]/s.getNumStudents(), 10, Color.YELLOW);
        bars[3] = new Shape(0, 0, fac * s.getHearData()[7]/s.getNumStudents(), 10, Color.GREEN);
        
        bars[4] = new Shape(0, 0, fac * s.getLikeData()[4]/s.getNumStudents(), 10, Color.PINK);
        bars[5] = new Shape(0, 0, fac * s.getLikeData()[5]/s.getNumStudents(), 10, Color.BLUE);
        bars[6] = new Shape(0, 0, fac * s.getLikeData()[6]/s.getNumStudents(), 10, Color.YELLOW);
        bars[7] = new Shape(0, 0, fac * s.getLikeData()[7]/s.getNumStudents(), 10, Color.GREEN);
        
    }

    private void addMajorBars(Position pos, Song s) {
        bars[0] = new Shape(0, 0, fac * s.getHearData()[0]/s.getNumStudents(), 10, Color.PINK); 
        bars[1] = new Shape(0, 0, fac * s.getHearData()[1]/s.getNumStudents(), 10, Color.BLUE);
        bars[2] = new Shape(0, 0, fac * s.getHearData()[2]/s.getNumStudents(), 10, Color.YELLOW);
        bars[3] = new Shape(0, 0, fac * s.getHearData()[3]/s.getNumStudents(), 10, Color.GREEN);
        
        bars[4] = new Shape(0, 0, fac * s.getLikeData()[0]/s.getNumStudents(), 10, Color.PINK);
        bars[5] = new Shape(0, 0, fac * s.getLikeData()[1]/s.getNumStudents(), 10, Color.BLUE);
        bars[6] = new Shape(0, 0, fac * s.getLikeData()[2]/s.getNumStudents(), 10, Color.YELLOW);
        bars[7] = new Shape(0, 0, fac * s.getLikeData()[3]/s.getNumStudents(), 10, Color.GREEN);
        
    }

    private void addHobbyBars(Position pos, Song s) {
        bars[0] = new Shape(0, 0, fac * s.getHearData()[8]/s.getNumStudents(), 10, Color.PINK); 
        bars[1] = new Shape(0, 0, fac * s.getHearData()[9]/s.getNumStudents(), 10, Color.BLUE);
        bars[2] = new Shape(0, 0, fac * s.getHearData()[10]/s.getNumStudents(), 10, Color.YELLOW);
        bars[3] = new Shape(0, 0, fac * s.getHearData()[11]/s.getNumStudents(), 10, Color.GREEN);
        
        bars[4] = new Shape(0, 0, fac * s.getLikeData()[8]/s.getNumStudents(), 10, Color.PINK);
        bars[5] = new Shape(0, 0, fac * s.getLikeData()[9]/s.getNumStudents(), 10, Color.BLUE);
        bars[6] = new Shape(0, 0, fac * s.getLikeData()[10]/s.getNumStudents(), 10, Color.YELLOW);
        bars[7] = new Shape(0, 0, fac * s.getLikeData()[11]/s.getNumStudents(), 10, Color.GREEN);

    }

    public Shape[] getBars()
    {
        return this.bars;
    }

    public Position pos(Position pos) {
        return this.position;
    }

}
