/**
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 */

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

/**
 * GUIMusicWindow
 * 
 * @author Gautam Nair (g23)
 * @version 2019.11.19
 */
@SuppressWarnings("unused")
public class GUIMusicWindow {

    public Window window;
    private Solver solver;

    private TextShape[][] legendText;
    // BUTTONS
    private Button[] buttonArray; // probably don't need this

    private String[] hobbies = { "Read", "Art", "Sports", "Music" };
    private String[] majors = { "Comp Sci", "Other Eng", "Math/CMDA", "Other" };
    private String[] regions = { "Northeast", "Outside of United States",
        "United States (other than Southeast or Northwest)", "Southeast" };

    private int page;

    private String currentRep;

    @SuppressWarnings("rawtypes")
    private DLinkedSongs songs;


    /**
     * default constructor that initiaties the window
     * 
     * @param solve
     *            the solver object that the window depicts
     */
    public GUIMusicWindow(Solver solve) {
        window = new Window();

        page = 1;
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
        // NORTH BUTTONS
        buttonArray[0] = prevButton;
        buttonArray[1] = artistButton;
        buttonArray[2] = titleButton;
        buttonArray[3] = yearButton;
        buttonArray[4] = genreButton;
        buttonArray[5] = nextButton;
        // SOUTH BUTTONS
        buttonArray[6] = hobbyButton;
        buttonArray[7] = majorButton;
        buttonArray[8] = regionButton;
        buttonArray[9] = quitButton;
        buttonArray[0].disable();
        buttonArray[5].disable();

        for (int i = 0; i < 10; i++) {
            if (i < 6) {
                window.addButton(buttonArray[i], WindowSide.NORTH);
            }
            else {
                window.addButton(buttonArray[i], WindowSide.SOUTH);
            }
        }

//
        this.solver = solve;

        songs = solver.getSongs();

    }


    /**
     * change the legend of the window to represent how the songs are
     * represented
     * 
     * @param repr
     *            the word key that notifies which type
     */
    public void updateLegend(String repr) {
        TextShape h1 = new TextShape(window.getGraphPanelWidth() * 8 / 10 + 35,
            window.getGraphPanelHeight() * 5 / 10 + 117, "Heard", Color.BLACK);
        h1.setBackgroundColor(null);
        window.addShape(h1);
        TextShape h2 = new TextShape(window.getGraphPanelWidth() * 8 / 10 + 95,
            window.getGraphPanelHeight() * 5 / 10 + 117, "Likes", Color.BLACK);
        h2.setBackgroundColor(null);
        window.addShape(h2);
        Shape line = new Shape(window.getGraphPanelWidth() * 8 / 10 + 85, window
            .getGraphPanelHeight() * 5 / 10 + 105, 5, 40, Color.BLACK);
        window.addShape(line);
        legendText = new TextShape[3][5];
        // HEADERS +25
        legendText[0][0] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10, "Hobby Legend",
            Color.BLACK);
        legendText[1][0] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10, "Major Legend",
            Color.BLACK);
        legendText[2][0] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10, "Region Legend",
            Color.BLACK);
        // HOBBIES
        legendText[0][1] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 20, hobbies[0],
            Color.PINK);
        legendText[0][2] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 35, hobbies[1],
            Color.BLUE);
        legendText[0][3] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 50, hobbies[2],
            Color.YELLOW);
        legendText[0][4] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 65, hobbies[3],
            Color.GREEN);
        // MAJORS
        legendText[1][1] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 20, majors[0],
            Color.PINK);
        legendText[1][2] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 35, majors[1],
            Color.BLUE);
        legendText[1][3] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 50, majors[2],
            Color.YELLOW);
        legendText[1][4] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 65, majors[3],
            Color.GREEN);
        // REGIONS
        legendText[2][1] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 20, regions[0],
            Color.PINK);
        legendText[2][2] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 35, regions[1],
            Color.BLUE);
        legendText[2][3] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 50, regions[2],
            Color.YELLOW);
        legendText[2][4] = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 45, window.getGraphPanelHeight() * 5 / 10 + 65, regions[3],
            Color.GREEN);

        if (repr == "hobby") {
            window.addShape(legendText[0][0]);
            window.addShape(legendText[0][1]);
            window.addShape(legendText[0][2]);
            window.addShape(legendText[0][3]);
            window.addShape(legendText[0][4]);
        }
        if (repr == "major") {
            window.addShape(legendText[1][0]);
            window.addShape(legendText[1][1]);
            window.addShape(legendText[1][2]);
            window.addShape(legendText[1][3]);
            window.addShape(legendText[1][4]);
        }
        if (repr == "region") {
            window.addShape(legendText[2][0]);
            window.addShape(legendText[2][1]);
            window.addShape(legendText[2][2]);
            window.addShape(legendText[2][3]);
            window.addShape(legendText[2][4]);
        }

        TextShape title = new TextShape(window.getGraphPanelWidth() * 8 / 10
            + 25, window.getGraphPanelHeight() * 5 / 10 + 85, "Song Title",
            Color.BLACK);
        title.setBackgroundColor(null);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                legendText[i][j].setBackgroundColor(null);
            }
        }

    }


    /**
     * change all the glyphs on window
     * 
     * @param repr
     *            the type of representation
     */
    public void updateGlyphs(String repr) {
        currentRep = repr;
        if (page == 1) {
            buttonArray[0].disable();
        }
        else {
            buttonArray[0].enable();
        }

        if (page == this.songs.size() / 9 + 1) {
            buttonArray[5].disable();
        }
        else {
            buttonArray[5].enable();
        }
        // BARS IN GLYPHS
        Shape tl = new Shape(window.getGraphPanelWidth() * 15 / 100, window
            .getGraphPanelHeight() * 1 / 5, 5, 40, Color.BLACK);
        window.addShape(tl);
        Shape tm = new Shape(window.getGraphPanelWidth() * 45 / 100, window
            .getGraphPanelHeight() * 1 / 5, 5, 40, Color.BLACK);
        window.addShape(tm);
        Shape tr = new Shape(window.getGraphPanelWidth() * 75 / 100, window
            .getGraphPanelHeight() * 1 / 5, 5, 40, Color.BLACK);
        window.addShape(tr);

        Shape cl = new Shape(window.getGraphPanelWidth() * 15 / 100, window
            .getGraphPanelHeight() * 1 / 2, 5, 40, Color.BLACK);
        window.addShape(cl);
        Shape cm = new Shape(window.getGraphPanelWidth() * 45 / 100, window
            .getGraphPanelHeight() * 1 / 2, 5, 40, Color.BLACK);
        window.addShape(cm);
        Shape cr = new Shape(window.getGraphPanelWidth() * 75 / 100, window
            .getGraphPanelHeight() * 1 / 2, 5, 40, Color.BLACK);
        window.addShape(cr);

        Shape bl = new Shape(window.getGraphPanelWidth() * 15 / 100, window
            .getGraphPanelHeight() * 4 / 5, 5, 40, Color.BLACK);
        window.addShape(bl);
        Shape bm = new Shape(window.getGraphPanelWidth() * 45 / 100, window
            .getGraphPanelHeight() * 4 / 5, 5, 40, Color.BLACK);
        window.addShape(bm);
        Shape br = new Shape(window.getGraphPanelWidth() * 75 / 100, window
            .getGraphPanelHeight() * 4 / 5, 5, 40, Color.BLACK);
        window.addShape(br);

        addStuff(repr, page);

    }


    /**
     * adds like bars, hear bars and text boxes
     * 
     * @param repr
     *            of window
     * @param page
     *            number
     */
    public void addStuff(String repr, int page) {
        int pager = 9 * page - 1;
        if (page < songs.size() / 9 + 1) {
            this.addLikeBars((Song)songs.getData(pager - 8),
                GUIPositionEnum.topLeft, repr);
            this.addLikeBars((Song)songs.getData(pager - 7),
                GUIPositionEnum.topCenter, repr);
            this.addLikeBars((Song)songs.getData(pager - 6),
                GUIPositionEnum.topRight, repr);

            this.addLikeBars((Song)songs.getData(pager - 5),
                GUIPositionEnum.midLeft, repr);
            this.addLikeBars((Song)songs.getData(pager - 4),
                GUIPositionEnum.midCenter, repr);
            this.addLikeBars((Song)songs.getData(pager - 3),
                GUIPositionEnum.midRight, repr);

            this.addLikeBars((Song)songs.getData(pager - 2),
                GUIPositionEnum.bottomLeft, repr);
            this.addLikeBars((Song)songs.getData(pager - 1),
                GUIPositionEnum.bottomCenter, repr);
            this.addLikeBars((Song)songs.getData(pager),
                GUIPositionEnum.bottomRight, repr);

            this.addHearBars((Song)songs.getData(pager - 8),
                GUIPositionEnum.topLeft, repr);
            this.addHearBars((Song)songs.getData(pager - 7),
                GUIPositionEnum.topCenter, repr);
            this.addHearBars((Song)songs.getData(pager - 6),
                GUIPositionEnum.topRight, repr);

            this.addHearBars((Song)songs.getData(pager - 5),
                GUIPositionEnum.midLeft, repr);
            this.addHearBars((Song)songs.getData(pager - 4),
                GUIPositionEnum.midCenter, repr);
            this.addHearBars((Song)songs.getData(pager - 3),
                GUIPositionEnum.midRight, repr);

            this.addHearBars((Song)songs.getData(pager - 2),
                GUIPositionEnum.bottomLeft, repr);
            this.addHearBars((Song)songs.getData(pager - 1),
                GUIPositionEnum.bottomCenter, repr);
            this.addHearBars((Song)songs.getData(pager),
                GUIPositionEnum.bottomRight, repr);

            this.addSongText((Song)songs.getData(pager - 8),
                GUIPositionEnum.topLeft);
            this.addSongText((Song)songs.getData(pager - 7),
                GUIPositionEnum.topCenter);
            this.addSongText((Song)songs.getData(pager - 6),
                GUIPositionEnum.topRight);
            this.addSongText((Song)songs.getData(pager - 5),
                GUIPositionEnum.midLeft);
            this.addSongText((Song)songs.getData(pager - 4),
                GUIPositionEnum.midCenter);
            this.addSongText((Song)songs.getData(pager - 3),
                GUIPositionEnum.midRight);
            this.addSongText((Song)songs.getData(pager - 2),
                GUIPositionEnum.bottomLeft);
            this.addSongText((Song)songs.getData(pager - 1),
                GUIPositionEnum.bottomCenter);
            this.addSongText((Song)songs.getData(pager),
                GUIPositionEnum.bottomRight);
        }
        else {

            int currIndex = songs.size() - (songs.size() % 9);
            for (GUIPositionEnum en : GUIPositionEnum.values()) {
                if (currIndex <= songs.size() - 1) {
                    this.addHearBars((Song)songs.getData(currIndex), en, repr);
                    this.addLikeBars((Song)songs.getData(currIndex), en, repr);
                    this.addSongText((Song)songs.getData(currIndex), en);
                }
                currIndex++;
            }

        }

    }


    /**
     * clicked the next button method
     * 
     * @param button
     *            tag
     */
    public void clickedNext(Button button) {
        page++;
        window.removeAllShapes();
        this.updateLegend(currentRep);
        this.updateGlyphs(currentRep);
    }


    /**
     * clicked the previous button
     * 
     * @param button
     *            tag
     */
    public void clickedPrevious(Button button) {
        page--;
        window.removeAllShapes();
        this.updateLegend(currentRep);
        this.updateGlyphs(currentRep);
    }


    /**
     * add the hear bars
     * 
     * @param s
     *            song
     * @param pos
     *            position
     * @param repr
     *            the type of representation
     */
    private void addHearBars(Song s, GUIPositionEnum pos, String repr) {
        GUIGlyph glyph = new GUIGlyph(s, repr, pos);
        Shape[] bars = glyph.getBars();
        switch (pos) {
            case bottomCenter:
                bars[0].setX(window.getGraphPanelWidth() * 45 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 4 / 5);
                bars[1].setX(window.getGraphPanelWidth() * 45 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 4 / 5 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 45 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 4 / 5 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 45 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 4 / 5 + 30);
                break;
            case bottomLeft:
                bars[0].setX(window.getGraphPanelWidth() * 15 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 4 / 5);
                bars[1].setX(window.getGraphPanelWidth() * 15 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 4 / 5 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 15 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 4 / 5 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 15 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 4 / 5 + 30);
                break;
            case bottomRight:
                bars[0].setX(window.getGraphPanelWidth() * 75 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 4 / 5);
                bars[1].setX(window.getGraphPanelWidth() * 75 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 4 / 5 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 75 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 4 / 5 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 75 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 4 / 5 + 30);
                break;
            case midCenter:
                bars[0].setX(window.getGraphPanelWidth() * 45 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 1 / 2);
                bars[1].setX(window.getGraphPanelWidth() * 45 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 1 / 2 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 45 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 1 / 2 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 45 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 1 / 2 + 30);
                break;
            case midLeft:
                bars[0].setX(window.getGraphPanelWidth() * 15 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 1 / 2);
                bars[1].setX(window.getGraphPanelWidth() * 15 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 1 / 2 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 15 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 1 / 2 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 15 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 1 / 2 + 30);
                break;
            case midRight:
                bars[0].setX(window.getGraphPanelWidth() * 75 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 1 / 2);
                bars[1].setX(window.getGraphPanelWidth() * 75 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 1 / 2 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 75 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 1 / 2 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 75 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 1 / 2 + 30);
                break;
            case topCenter:
                bars[0].setX(window.getGraphPanelWidth() * 45 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 1 / 5);
                bars[1].setX(window.getGraphPanelWidth() * 45 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 1 / 5 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 45 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 1 / 5 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 45 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 1 / 5 + 30);
                break;
            case topLeft:
                bars[0].setX(window.getGraphPanelWidth() * 15 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 1 / 5);
                bars[1].setX(window.getGraphPanelWidth() * 15 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 1 / 5 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 15 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 1 / 5 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 15 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 1 / 5 + 30);
                break;
            case topRight:
                bars[0].setX(window.getGraphPanelWidth() * 75 / 100 - bars[0]
                    .getWidth());
                bars[0].setY(window.getGraphPanelHeight() * 1 / 5);
                bars[1].setX(window.getGraphPanelWidth() * 75 / 100 - bars[1]
                    .getWidth());
                bars[1].setY(window.getGraphPanelHeight() * 1 / 5 + 10);
                bars[2].setX(window.getGraphPanelWidth() * 75 / 100 - bars[2]
                    .getWidth());
                bars[2].setY(window.getGraphPanelHeight() * 1 / 5 + 20);
                bars[3].setX(window.getGraphPanelWidth() * 75 / 100 - bars[3]
                    .getWidth());
                bars[3].setY(window.getGraphPanelHeight() * 1 / 5 + 30);
                break;
            default:
                break;

        }
        window.addShape(bars[0]);
        window.addShape(bars[1]);
        window.addShape(bars[2]);
        window.addShape(bars[3]);

    }


    /**
     * add the like bars for each song
     * 
     * @param song
     *            to add for
     * @param pos
     *            of the glyph
     * @param repr
     *            of the window
     */
    private void addLikeBars(Song song, GUIPositionEnum pos, String repr) {
        GUIGlyph glyph = new GUIGlyph(song, repr, pos);
        Shape[] bars = glyph.getBars();
        switch (pos) {
            case bottomCenter:
                bars[4].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 4 / 5);
                bars[5].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 4 / 5 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 4 / 5 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 4 / 5 + 30);
                break;
            case bottomLeft:
                bars[4].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 4 / 5);
                bars[5].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 4 / 5 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 4 / 5 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 4 / 5 + 30);
                break;
            case bottomRight:
                bars[4].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 4 / 5);
                bars[5].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 4 / 5 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 4 / 5 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 4 / 5 + 30);
                break;
            case midCenter:
                bars[4].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 1 / 2);
                bars[5].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 1 / 2 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 1 / 2 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 1 / 2 + 30);
                break;
            case midLeft:
                bars[4].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 1 / 2);
                bars[5].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 1 / 2 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 1 / 2 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 1 / 2 + 30);
                break;
            case midRight:
                bars[4].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 1 / 2);
                bars[5].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 1 / 2 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 1 / 2 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 1 / 2 + 30);
                break;
            case topCenter:
                bars[4].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 1 / 5);
                bars[5].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 1 / 5 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 1 / 5 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 45 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 1 / 5 + 30);
                break;
            case topLeft:
                bars[4].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 1 / 5);
                bars[5].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 1 / 5 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 1 / 5 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 15 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 1 / 5 + 30);
                break;
            case topRight:
                bars[4].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[4].setY(window.getGraphPanelHeight() * 1 / 5);
                bars[5].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[5].setY(window.getGraphPanelHeight() * 1 / 5 + 10);
                bars[6].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[6].setY(window.getGraphPanelHeight() * 1 / 5 + 20);
                bars[7].setX(window.getGraphPanelWidth() * 75 / 100 + 5);
                bars[7].setY(window.getGraphPanelHeight() * 1 / 5 + 30);
                break;
            default:
                break;
        }
        window.addShape(bars[4]);
        window.addShape(bars[5]);
        window.addShape(bars[6]);
        window.addShape(bars[7]);
    }


    /**
     * add the textbox for each song
     * 
     * @param song
     *            to add for
     * @param pos
     *            of the glyph
     * @param repr
     *            of the window
     */
    private void addSongText(Song song, GUIPositionEnum pos) {
        String name = song.getTitle();
        String artist = song.getArtist();
        TextShape nameText = null;
        TextShape artistText = null;
        switch (pos) {
            case bottomCenter:
                nameText = new TextShape(window.getGraphPanelWidth() * 45 / 100
                    - 25, window.getGraphPanelHeight() * 4 / 5 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 45
                    / 100 - 25, window.getGraphPanelHeight() * 4 / 5 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);
                break;
            case bottomLeft:
                nameText = new TextShape(window.getGraphPanelWidth() * 15 / 100
                    - 25, window.getGraphPanelHeight() * 4 / 5 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 15
                    / 100 - 25, window.getGraphPanelHeight() * 4 / 5 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);
                break;
            case bottomRight:
                nameText = new TextShape(window.getGraphPanelWidth() * 75 / 100
                    - 25, window.getGraphPanelHeight() * 4 / 5 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 75
                    / 100 - 25, window.getGraphPanelHeight() * 4 / 5 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);
                break;

            case midCenter:
                nameText = new TextShape(window.getGraphPanelWidth() * 45 / 100
                    - 25, window.getGraphPanelHeight() * 1 / 2 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 45
                    / 100 - 25, window.getGraphPanelHeight() * 1 / 2 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);
                break;
            case midLeft:
                nameText = new TextShape(window.getGraphPanelWidth() * 15 / 100
                    - 25, window.getGraphPanelHeight() * 1 / 2 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 15
                    / 100 - 25, window.getGraphPanelHeight() * 1 / 2 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);
                break;
            case midRight:
                nameText = new TextShape(window.getGraphPanelWidth() * 75 / 100
                    - 25, window.getGraphPanelHeight() * 1 / 2 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 75
                    / 100 - 25, window.getGraphPanelHeight() * 1 / 2 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);
                break;
            case topCenter:
                nameText = new TextShape(window.getGraphPanelWidth() * 45 / 100
                    - 25, window.getGraphPanelHeight() * 1 / 5 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 45
                    / 100 - 25, window.getGraphPanelHeight() * 1 / 5 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);
                break;
            case topLeft:
                nameText = new TextShape(window.getGraphPanelWidth() * 15 / 100
                    - 25, window.getGraphPanelHeight() * 1 / 5 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 15
                    / 100 - 25, window.getGraphPanelHeight() * 1 / 5 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);

                break;
            case topRight:
                nameText = new TextShape(window.getGraphPanelWidth() * 75 / 100
                    - 25, window.getGraphPanelHeight() * 1 / 5 - 40, name,
                    Color.BLACK);
                nameText.setBackgroundColor(null);

                artistText = new TextShape(window.getGraphPanelWidth() * 75
                    / 100 - 25, window.getGraphPanelHeight() * 1 / 5 - 20, "by "
                        + artist, Color.BLACK);
                artistText.setBackgroundColor(null);
                break;
            default:
                break;

        }

        window.addShape(nameText);
        window.addShape(artistText);

    }


    /**
     * clicked the hobby button
     * 
     * @param button
     *            pressed
     */
    public void clickedHobby(Button button) {
        window.removeAllShapes();
        this.updateLegend("hobby");
        this.updateGlyphs("hobby");
    }


    /**
     * clicked the major button
     * 
     * @param button
     *            pressed
     */
    public void clickedMajor(Button button) {
        window.removeAllShapes();
        this.updateGlyphs("major");
        this.updateLegend("major");
    }


    /**
     * clicked the region button
     * 
     * @param button
     *            pressed
     */
    public void clickedRegion(Button button) {
        window.removeAllShapes();
        this.updateGlyphs("region");
        this.updateLegend("region");
    }


    /**
     * clicked the artist button
     * 
     * @param button
     *            pressed
     */
    public void clickedArtist(Button button) {

        this.window.removeAllShapes();
        this.solver.insertionSort(1);
        songs = this.solver.getSongs();
        this.updateLegend(currentRep);
        this.updateGlyphs(currentRep);
    }


    /**
     * clicked the title button
     * 
     * @param button
     *            pressed
     */
    public void clickedTitle(Button button) {
        this.window.removeAllShapes();
        this.solver.insertionSort(0);
        songs = this.solver.getSongs();
        this.updateGlyphs(currentRep);
        this.updateLegend(currentRep);

    }


    /**
     * clicked the year button
     * 
     * @param button
     *            pressed
     */
    public void clickedYear(Button button) {
        this.window.removeAllShapes();
        this.solver.insertionSort(3);
        songs = this.solver.getSongs();
        this.updateGlyphs(currentRep);
        this.updateLegend(currentRep);

    }


    /**
     * clicked the genre button
     * 
     * @param button
     *            pressed
     */
    public void clickedGenre(Button button) {
        this.window.removeAllShapes();
        this.solver.insertionSort(2);
        songs = this.solver.getSongs();
        this.updateGlyphs(currentRep);
        this.updateLegend(currentRep);

    }


    /**
     * clicked the quit button
     * 
     * @param button
     *            pressed
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

}
