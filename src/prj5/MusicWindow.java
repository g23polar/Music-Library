package prj5;

import CS2114.Window;
import java.awt.*;
import CS2114.WindowSide;
import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Command;
import CS2114.Shape;
import CS2114.TextShape;
public class MusicWindow {

    private Window window;
    private Solver solver;

    private TextShape[][] legendText; 
    // BUTTONS
    private Button[] buttonArray;

    //GLYPHS
    private Glyph[] glyphArray; 
    
    private TextShape legend; 

    private String[] hobbies;
    private String[] majors;
    private String[] regions;
    
    public MusicWindow(Solver solve) {
        window = new Window();
        window.setTitle("Project 5");
        this.buttonArray = new Button[10];
        Button artistButton = new Button("Sort by Artist Name");
        artistButton.onClick(this, "clickedArtist");
        Button titleButton = new Button("Sort by Song Title");
        titleButton.onClick(this, "clickedTitle");
        Button yearButton = new Button("Sort by Year");
        yearButton.onClick(this, "clickedYear");
        Button genreButton = new Button("Sort by Genre");
        genreButton.onClick(this, "clickedGenre");
        Button hobbyButton = new Button("Represent Hobby");
        hobbyButton.onClick(this, "clickedHobby");
        Button majorButton = new Button("Represent Major");
        majorButton.onClick(this, "clickedMajor");
        Button regionButton = new Button("Represent Region");
        regionButton.onClick(this, "clickedRegion");
        Button prevButton = new Button("<- Prev");
        prevButton.onClick(this, "clickedPrevious");
        Button nextButton = new Button("Next ->");
        nextButton.onClick(this, "clickedNext");
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        //NORTH BUTTONS
        buttonArray[0] = prevButton;
        buttonArray[1] = artistButton;
        buttonArray[2] = titleButton;
        buttonArray[3] = yearButton;
        buttonArray[4] = genreButton;
        buttonArray[5] = nextButton;
        //SOUTH BUTTONS
        buttonArray[6] = hobbyButton;
        buttonArray[7] = majorButton;
        buttonArray[8] = regionButton;
        buttonArray[9] = quitButton;
        
        for (int i = 0 ; i < 10 ; i++)
        {
            if (i < 6) 
            {
                window.addButton(buttonArray[i], WindowSide.NORTH);
            }
            else
            {
                window.addButton(buttonArray[i], WindowSide.SOUTH);
            }
        }
        hobbies = this.solver.getHobbies();
        regions = this.solver.getRegions();
        majors = this.solver.getMajors();
        
        legendText = new TextShape[3][5];
        //HEADERS +25
        legendText[0][0] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10, "Hobby Legend", Color.BLACK);
        legendText[1][0] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10, "Major Legend", Color.BLACK);
        legendText[2][0] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10, "Region Legend", Color.BLACK);
        //HOBBIES
        legendText[0][1] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 20, hobbies[0], Color.PINK);
        legendText[0][2] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 35, hobbies[1], Color.BLUE);
        legendText[0][3] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 50, hobbies[2], Color.YELLOW);
        legendText[0][4] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 65, hobbies[3], Color.GREEN);
        //MAJORS
        legendText[1][1] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 20, majors[0], Color.PINK);
        legendText[1][2] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 35, majors[1], Color.BLUE);
        legendText[1][3] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 50, majors[2], Color.YELLOW);
        legendText[1][4] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 65, majors[3], Color.GREEN);
        //REGIONS
        legendText[2][1] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 20, regions[0], Color.PINK);
        legendText[2][2] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 35, regions[1], Color.BLUE);
        legendText[2][3] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 50, regions[2], Color.YELLOW);
        legendText[2][4] = new TextShape(window.getGraphPanelWidth() * 8/10+45, window.getGraphPanelHeight()*5/10 + 65, regions[3], Color.GREEN);
        
        TextShape title = new TextShape(window.getGraphPanelWidth() * 8/10 + 25, window.getGraphPanelHeight()*5/10 + 85, "Song Title", Color.BLACK);
        title.setBackgroundColor(null);
        
        this.solver = solve; 
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                legendText[i][j].setBackgroundColor(null);
            }
        }
        
    }
        
    public void updateLegend(String repr)
    {
        TextShape h1 = new TextShape(window.getGraphPanelWidth() * 8/10 + 35, window.getGraphPanelHeight()*5/10 + 117, "Heard", Color.BLACK);
        h1.setBackgroundColor(null);
        window.addShape(h1);
        TextShape h2 = new TextShape(window.getGraphPanelWidth() * 8/10 + 95, window.getGraphPanelHeight()*5/10 + 117, "Likes", Color.BLACK);
        h2.setBackgroundColor(null);
        window.addShape(h2);
        Shape line = new Shape(window.getGraphPanelWidth() * 8/10 + 85, window.getGraphPanelHeight()*5/10 + 105, 5, 40, Color.BLACK);
        window.addShape(line);
        
        if (repr == "hobby")
        {
            window.addShape(legendText[0][0]);
            window.addShape(legendText[0][1]);
            window.addShape(legendText[0][2]);
            window.addShape(legendText[0][3]);
            window.addShape(legendText[0][4]);
        }
        if (repr == "major")
        {
            window.addShape(legendText[1][0]);
            window.addShape(legendText[1][1]);
            window.addShape(legendText[1][2]);
            window.addShape(legendText[1][3]);
            window.addShape(legendText[1][4]);
        }
        if (repr == "region")
        {
            window.addShape(legendText[2][0]);
            window.addShape(legendText[2][1]);
            window.addShape(legendText[2][2]);
            window.addShape(legendText[2][3]);
            window.addShape(legendText[2][4]);
        }
        
    }

    public void updateGlyphs(String repr)
    {
        
        //BARS IN GLYPHS
        Shape tl = new Shape(window.getGraphPanelWidth() *15/100, window.getGraphPanelHeight() * 1/5, 5, 40, Color.BLACK);
        window.addShape(tl);
        Shape tm = new Shape(window.getGraphPanelWidth() *45/100, window.getGraphPanelHeight() * 1/5, 5, 40, Color.BLACK);
        window.addShape(tm);
        Shape tr = new Shape(window.getGraphPanelWidth() *75/100, window.getGraphPanelHeight() * 1/5, 5, 40, Color.BLACK);
        window.addShape(tr);
        
        Shape cl = new Shape(window.getGraphPanelWidth() *15/100, window.getGraphPanelHeight() * 1/2, 5, 40, Color.BLACK);
        window.addShape(cl);
        Shape cm = new Shape(window.getGraphPanelWidth() *45/100, window.getGraphPanelHeight() * 1/2, 5, 40, Color.BLACK);
        window.addShape(cm);
        Shape cr = new Shape(window.getGraphPanelWidth() *75/100, window.getGraphPanelHeight() * 1/2, 5, 40, Color.BLACK);
        window.addShape(cr);

        Shape bl = new Shape(window.getGraphPanelWidth() *15/100, window.getGraphPanelHeight() * 4/5, 5, 40, Color.BLACK);
        window.addShape(bl);
        Shape bm = new Shape(window.getGraphPanelWidth() *45/100, window.getGraphPanelHeight() * 4/5, 5, 40, Color.BLACK);
        window.addShape(bm);
        Shape br = new Shape(window.getGraphPanelWidth() *75/100, window.getGraphPanelHeight() * 4/5, 5, 40, Color.BLACK);
        window.addShape(br);
        
    }
    

    public void clickedNext(Button button)
    {
    }
    public void clickedPrevious(Button button)
    {
        
    }
    
    public void clickedHobby(Button button)
    {
        window.removeAllShapes();
        this.updateLegend("hobby");
        this.updateGlyphs("hobby");
    }
    public void clickedMajor(Button button)
    {
        window.removeAllShapes();
        this.updateGlyphs("major");
        this.updateLegend("major");
    }
    public void clickedRegion(Button button)
    {
        window.removeAllShapes();
        this.updateGlyphs("region");
        this.updateLegend("region");
    }
    
    public void clickedArtist(Button button)
    {
    }
    public void clickedTitle(Button button)
    {
        
    }
    public void clickedYear(Button button)
    {
        
    }
    public void clickedGenre(Button button)
    {
        
    }
    public void clickedQuit(Button button)
    {
        
    }
    
}
