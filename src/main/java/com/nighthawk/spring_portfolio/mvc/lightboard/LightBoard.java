package com.nighthawk.spring_portfolio.mvc.lightboard;
import java.util.Scanner;
import lombok.Data;

@Data  // Annotations to simplify writing code (ie constructors, setters)
public class LightBoard {
    private Light[][] lights;

    /* Initialize LightBoard and Lights */
    public LightBoard(int numRows, int numCols) {
        this.lights = new Light[numRows][numCols];
        // 2D array nested loops, used for initialization
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                lights[row][col] = new Light();  // each cell needs to be constructed
            }
        }

    }

    /* Output is intended for API key/values */
    public String toString() { 
        String outString = "[";
        // 2D array nested loops, used for reference
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString += 
                // data
                "{" + 
                "\"row\": " + row + "," +
                "\"column\": " + col + "," +
                "\"light\": " + lights[row][col] +   // extract toString data
                "}," ;
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString = outString.substring(0,outString.length() - 1) + "]";
		return outString;
    }

    /* Output is intended for Terminal, effects added to output */
    public String toTerminal() { 
        String outString = "[";
        // 2D array nested loops, used for reference
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString += 
                // reset
                "\033[m" +
                
                // color
                "\033[38;2;" + 
                lights[row][col].getRed() + ";" +  // set color using getters
                lights[row][col].getGreen() + ";" +
                lights[row][col].getBlue() + ";" +
                lights[row][col].getEffect() + "m" +
                // data, extract custom getters
                "{" +
                "\"" + "isOn\": " + lights[row][col].isOn() +
                "," +
                "\"" + "RGB\": " + "\"" + lights[row][col].getRGB() + "\"" +
                "," +
                "\"" + "Effect\": " + "\"" + lights[row][col].getEffectTitle() + "\"" +
                "}," +
                // newline
                "\n" ;
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString = outString.substring(0,outString.length() - 2) + "\033[m" + "]";
		return outString;
    }

    /* Output is intended for Terminal, draws color palette */
    public String toColorPalette(int bHeight, int bLength) {
        // block sizes
        final int ROWS = bHeight;
        final int COLS = bLength;

        // Build large string for entire color palette
        String outString = "";
        // find each row
        for (int row = 0; row < lights.length; row++) {
            // repeat each row for block size
            for (int i = 0; i < ROWS; i++) {
                // find each column
                for (int col = 0; col < lights[row].length; col++) {
                    // repeat each column for block size
                    for (int j = 0; j < COLS; j++) {
                        // print single character, except at midpoint print color code
                        if (lights[row][col].isOn()) {
                            String c = (i == (int) (ROWS / 2) && j == (int) (COLS / 2) ) 
                            ? lights[row][col].getRGB()
                            : (j == (int) (COLS / 2))  // nested ternary
                            ? " ".repeat(lights[row][col].getRGB().length())
                            : " ";

                        outString += 
                        // reset
                        "\033[m" +
                        
                        // color
                        "\033[38;2;" + 
                        lights[row][col].getRed() + ";" +
                        lights[row][col].getGreen() + ";" +
                        lights[row][col].getBlue() + ";" +
                        "7m" +

                        // color code or blank character
                        c +

                        // reset
                        "\033[m";
                        }
                        
                    }
                }
                outString += "\n";
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString += "\033[m";
		return outString;
    }
    
    public void flag(String flag) {
        if(flag == "Belgium") {
            short rv = 45;
            short gv = 41;
            short bv = 38;

            for (int rowz = 0; rowz < 5; rowz++) {
                for (int colz = 0; colz < 3; colz++) {
                    lights[rowz][colz].RGBset(rv,gv,bv);
                }
            } 
            short rva = 255;
            short gva = 205;
            short bva = 0;

            for (int rowz = 0; rowz < 5; rowz++) {
                for (int colz = 3; colz < 6; colz++) {
                    lights[rowz][colz].RGBset(rva,gva,bva);
                }
            } 
            short rvb = 200;
            short gvb = 16;
            short bvb = 46;

            for (int rowz = 0; rowz < 5; rowz++) {
                for (int colz = 6; colz < 9; colz++) {
                    lights[rowz][colz].RGBset(rvb,gvb,bvb);
                }
            } 
        }

        if(flag == "Russia") {
            short rv = 255;
            short gv = 255;
            short bv = 255;

            for (int rowz = 0; rowz < 2; rowz++) {
                for (int colz = 0; colz < 9; colz++) {
                    lights[rowz][colz].RGBset(rv,gv,bv);
                }
            } 
            short ru = 28;
            short gu = 53;
            short bu = 120;
            for (int rowz = 2; rowz < 4; rowz++) {
                for (int colz = 0; colz < 9; colz++) {
                    lights[rowz][colz].RGBset(ru,gu,bu);
                }
            } 
            short rr = 255;
            short gr = 0;
            short br = 0;
            for (int rowz = 4; rowz < 5; rowz++) {
                for (int colz = 0; colz < 9; colz++) {
                    lights[rowz][colz].RGBset(rr,gr,br);
                }
            }
        }

        if(flag == "Japan") {
            short rx = 255;
            short gx = 255;
            short bx = 255;

            for (int rowz = 0; rowz < 5; rowz++) {
                for (int colz = 0; colz < 9; colz++) {
                    lights[rowz][colz].RGBset(rx,gx,bx);
                }
            } 
            short r = 255;
            short g = 0;
            short b = 0;
            for (int rowz = 1; rowz < 4; rowz++) {
                for (int colz = 3; colz < 6; colz++) {
                    lights[rowz][colz].RGBset(r,g,b);
                }
            }
        } 

    }

    public void turnOff(int zrow, int zcol) {
        lights[zrow][zcol].setOn(false);
    }

    static public void main(String[] args) {
        // create and display LightBoard
        Scanner scan = new Scanner(System.in);
        System.out.println("Rows");
        int bRows = scan.nextInt();
        System.out.println("Columns");
        int bCols = scan.nextInt();
        System.out.println("Height");
        int bHeight = scan.nextInt();
        System.out.println("Length");
        int bLength = scan.nextInt();
        LightBoard lightBoard = new LightBoard(bRows, bCols);
        
        System.out.println(lightBoard);  // use toString() method
        System.out.println(lightBoard.toTerminal());
        System.out.println(lightBoard.toColorPalette(bHeight, bLength));
        lightBoard.turnOff(0, 0);
        System.out.println(lightBoard.toTerminal());
        System.out.println(lightBoard.toColorPalette(bHeight, bLength));
        
        LightBoard flagBoard = new LightBoard(5, 9);
        flagBoard.flag("Belgium");
        System.out.println(flagBoard.toColorPalette(4, 4));
        flagBoard.flag("Russia");
        System.out.println(flagBoard.toColorPalette(4, 4));
        flagBoard.flag("Japan");
        System.out.println(flagBoard.toColorPalette(4, 4));

    }
}