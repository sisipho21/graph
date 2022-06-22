//Sisipho Tukushe
//Draw a straight line graph based on a formula provided by user
//22 June 2022

import java.util.Scanner;

/**
 * Class to draw a straight line graph based on a formula given by the user as input
 */
public class Graph {

    private int a,b;
    String line =" ";
    int[] xValues = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
    int[] yValues = new int[21];

    /**
     * Constructor of Graph class
     */
    public Graph(){
        a=1; b=1;
    }

    /**
     * Calculates the y values based on the input formula, populates the yValues array
     */
    private void calculations(){
        for (int i=0; i<21; i++){
            yValues[i]= (xValues[i]*a) +b+1;
        }
    }

    /**
     * Draws the graph based on all calculations
     */
    private void axes()
    {
        if (a>0)
            line = "/";
        else if (a<0)
            line = "\\";
        for (int rows=0; rows<21; rows++)
        {
            for (int col=0; col<21; col++) {

                 if (( rows == xValues[rows] + 10) && (col== (yValues[rows]*-1)+11 )){
                    System.out.print(line);
                }
                else if (col == 10 && rows == 10)
                    System.out.print("+");
                else if (col==10)
                    System.out.print("|");
                else if (rows==10)
                    System.out.print("-");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * Breaks down the given string formula into the 'a' and 'b' parameters
     * @param formula String formula to be broken down
     */
    private void formulaBreakDown(String formula){
        formula = formula.trim();

        if (formula.charAt(0) == '-'){ //look for negative a value
            a *=-1;
            formula = formula.substring(1);
        }
        int xLoc = formula.indexOf("x"); //locating index of x

        if (xLoc == 0)
            a *= 1;
        else {
            String aVal = formula.substring(0, xLoc); //extracting the value up to but excluding x
            a *= Integer.parseInt(aVal);//a value
        }

        if (formula.charAt(xLoc+1) == '-'){ //if b is negative
            b *= -1;
        }
        formula = formula.substring(xLoc+2); //starting after the math symbol to get b value
        b *= Integer.parseInt(formula); // b value
    }

    /**
     * Main method for Graph class. Calls on all Graph methods
     * @param args
     */
    public static void main (String[] args)
    {
        Graph gr = new Graph();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Type in a line graph in the form \'ax+b\':");
        String inFormula = keyboard.next();
        gr.formulaBreakDown(inFormula);
        gr.calculations();
        gr.axes();
    }
}
