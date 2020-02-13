package app;

import javax.swing.JOptionPane;
import static app.App.*;

public class Calc{ 
    
    public static int calcstart = 0;    
    public static String degreetradform;
    public static Boolean part1 = false;
    public static Boolean part2 = false;
    public static Boolean part3 = false;
    public static Boolean part4 = false;
    static boolean can1;
    static boolean can2;
    static boolean can3;
    static boolean can4;
    static boolean can5;

    public static void calcdegree(int i){
        if(App.canCalc == true){
            calcstart = i;
            degreetradform = (String)App.choicetraddegreedegree.getSelectedItem();
            if((degreetradform.equals("C°") && App.choicebasedegree.getSelectedItem().equals("C°"))){
                JOptionPane.showMessageDialog(j, "Can't turn Celsius into Celsius!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                part1 = true;
            }

            if(part1 && (degreetradform.equals("F°") && App.choicebasedegree.getSelectedItem().equals("F°"))){
                JOptionPane.showMessageDialog(j, "Can't turn Farhenheit into Farhenheit!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                part2 = true;
            }

            if(part2 && (degreetradform.equals("K°") && App.choicebasedegree.getSelectedItem().equals("K°"))){
                JOptionPane.showMessageDialog(j, "Can't turn Kelvin into Kelvin!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                part3 = true;
            }

            if(part1 && part2 && part3){
                title.setText("Converting into " + choicetraddegreedegree.getSelectedItem() + "...");
                calc(((String)choicebasedegree.getSelectedItem()), (String)choicetraddegreedegree.getSelectedItem());
            } else if(!part1 && !part2 && !part3){
                System.out.println("There is a problem");
                JOptionPane.showMessageDialog(j, "There happend to be a unknown problem", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    
    //To translate and show the results
    public static void calc(String degreebase, String degreetrad){
        
        if(degreebase.equals("C°") && degreetrad.equals("F°")){
            double ctofcalce1 =  calcstart * 1.8;
            double ctofcalce2 = ctofcalce1 + 32;

            double result = ctofcalce2;
            title.setBounds(50, 50, 400, 50);
            title.setText(calcstart + "C" + "\u00B0" + " In Farhenheit is equal to " + Double.toString(result) + "F" + "\u00B0");
        } else {
            can1 = true;
        }

        if(can1 && degreebase.equals("F°") && degreetrad.equals("C°")){
            double ftoccalce1 = calcstart - 32; 
            double ftoccalce2 = ftoccalce1 / 5/9; 

            double result = ftoccalce2;
            title.setBounds(50, 50, 400, 50);
            title.setText(calcstart + "F" + "\u00B0" + " In Celsius is equal to " + Double.toString(result) + "C" + "\u00B0");
        } else {
            can2 = true;
        }


        if(can2 && degreebase.equals("K°") && degreetrad.equals("C°")){
            double ktoc = calcstart + 273.15;

            double result = ktoc;
            title.setBounds(50, 50, 400, 50);
            title.setText(calcstart + "K" + "\u00B0" + " In Celsius is equal to " + Double.toString(result) + "C" + "\u00B0");
        } else {
            can3 = true;
        }

        if(can3 && degreebase.equals("C°") && degreetrad.equals("K°")){
            double ctok = calcstart - 273.15;

            double result = ctok;
            title.setBounds(50, 50, 400, 50);
            title.setText(calcstart + "C" + "\u00B0" + " In Kelvin is equal to " + Double.toString(result) + "K" + "\u00B0");
        } else {
            can4 = true;
        }

        if(can4 && degreebase.equals("F°") && degreetrad.equals("K°")){
            double ftok = calcstart - 32;
            double ftoke2 = ftok * 5/9 + 273.15;

            double result = ftoke2;
            title.setBounds(50, 50, 400, 50);
            title.setText(calcstart +  "F" + "\u00B0" + " In Kelvin is equal to " + Double.toString(result) + "K" + "\u00B0");
        } else {
            can5 = true;
        }

        if(can5 && degreebase.equals("K°") && degreetrad.equals("F°")){
            double ktof = calcstart - 273.15;
            double ktofe2 = ktof * 9/5 + 32;

            double result = ktofe2;
            title.setBounds(50, 50, 400, 50);
            title.setText(calcstart + "K" + "\u00B0" + " In Farhenheit is equal to " + Double.toString(result) + "F" + "\u00B0");
        }

    }
}

