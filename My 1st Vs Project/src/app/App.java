package app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class App implements MouseMotionListener, ActionListener {
    public static JFrame j;
    public static JLabel title;
    public static JLabel calcmode;
    public static JTextField textfield;
    public static JLabel basefield;
    public static JLabel tradfield;
    public static JButton closeButton = new JButton("Close the app");
    public static JButton calcButton = new JButton("Translate");
    public static JComboBox<String> choicebasedegree;
    public static JComboBox<String> choicetraddegreedegree;
    static String[] itemsincombobox = new String[] { ("C" + "\u00B0"), ("F" + "\u00B0"), ("K" + "\u00B0") };
    public static boolean canCalc;


    public static void main(String[] args) {
        //JFrame
        j = new JFrame("Degree Translator");
        
        //BaseDegreeForm
        choicebasedegree = new JComboBox<>(itemsincombobox);
        choicebasedegree.setBounds(225, 300, 50, 20);
        j.add(choicebasedegree);
        
        //TradDegreeForm
        choicetraddegreedegree = new JComboBox<>(itemsincombobox);
        choicetraddegreedegree.setBounds(225, 260, 50, 20);
        j.add(choicetraddegreedegree);

        //Title
        title = new JLabel("Degree Translator  (C" + "\u00B0" + "; F" + "\u00B0" + "and K" + "\u00B0" + ")", SwingConstants.CENTER);
        title.setFont(new Font("Sherif", Font.CENTER_BASELINE, 18));
        title.setBounds(100, 50, 300, 50);
        j.add(title);

        //1st TextField
        textfield = new JTextField();
        textfield.setBounds(200, 150, 100, 50);
        textfield.setFont(new Font("Sherif", Font.CENTER_BASELINE, 40));
        j.add(textfield);
        

        //2nd Label
        basefield = new JLabel("Original degree");
        basefield.setBounds(105, 300, 150, 20);
        basefield.setFont(new Font("Sherif", Font.CENTER_BASELINE, 12));
        j.add(basefield);
        
        //3rd Label
        tradfield = new JLabel("Translated degree");
        tradfield.setBounds(105, 260, 150, 20);
        tradfield.setFont(new Font("Sherif", Font.CENTER_BASELINE, 12));
        j.add(tradfield);
        
        //JFrame Settings
        j.setSize(500, 500);
        j.setLayout(null);
        j.setUndecorated(true);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);

        //closeButton Settings and ActionListener for close
        closeButton.setBounds(150, 440, 200, 50);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        j.add(closeButton);
        
        //calcButton Settings and ActionListener
        calcButton.setBounds(150, 350, 200, 50);
        calcButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    String textfieldtext = textfield.getText();   
                    try{
                            int calcstart = Integer.parseInt(textfieldtext);
                                canCalc = true;
                                Calc.calcdegree(calcstart);
                        } catch (NumberFormatException nfe){
                            JOptionPane.showMessageDialog(j,"Degree shoud be numbers, not what you just put up there", "Error", JOptionPane.ERROR_MESSAGE);
                        }
            }
        });
        j.add(calcButton);

        };

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

   