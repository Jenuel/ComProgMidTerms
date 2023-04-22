/**
*
* Group Members:
* Alvarez, Maria Alexandra
* Balogo, Renuel Jeremi
* Cagulada, Sheryn Ann
* Lumanglas, Yenzy Hynna
* Palacay, Abigail
*
* Class Code and Schedule: 9315 CS122 MTh 9:00 - 10:30
*
* Summary of exception handling added to the MixedFraction project:
*
*  1. Added a try catch block in the slash button part of the ButtonsHandler class for the division of mixed fractions. 
* This is to handle exceptions such as ArithmeticException. The purpose of this exception is so that the denominator is not zero.
*       case '/' -> {
*                           MixedFraction answer3;
*                           try {
*                               answer3 = mixedFrac1.divide(mixedFrac2);
*                               operationsTF.setText(answer3 + " or " + answer3.toDouble());
*                           } catch (ArithmeticException ex1){
*                               problemDisplayer = "Divisor cannot be 0";
*                           }
*
*                           if (operationsTF.getText().equals("")){
*                               operationsTF.setText("Divisor cannot be 0");
*                               fraction1TF.setText("");
*                               fraction2TF.setText("");
*                               problemDisplayer = "";
*                           }
*                       }
*  2. Added a try catch block in the parseFraction method to handle exceptions for the input data entered. 
* For case 1 the exception that was added is NumberFormatException. And as for case 2 and 3, a NumberFormatException 
* and ArithmeticException was added. The purpose of NumberFormatException is so that the numerator is greater than or 
* equal to zero. While the purpose of the ArithmeticException is so that the denominator is not zero.
*       private MixedFraction parseFraction(String fraction) {
*
*           String[] input = fraction.split("[ /]", 3);
*
*           MixedFraction inputMixedFraction = new MixedFraction();
*
*           int wholeNumber = 0;
*           int numerator = 0;
*           int denominator = 1;
*
*           switch (input.length) {
*               case 1 -> { //e.g "1"
*
*                   try {
*                       wholeNumber = Integer.parseInt(input[0]);
*                   } catch (NumberFormatException nfe1) {
*                       problemDisplayer = "Make sure to enter a valid number.";
*                   }
*
*                   inputMixedFraction = new MixedFraction(0, 1, wholeNumber);
*                   return inputMixedFraction;
*               }
*               case 2 -> { // e.g "1/2"
*
*                   try {
*                       numerator = Integer.parseInt(input[0]);
*                       denominator = Integer.parseInt(input[1]);
*                   } catch (NumberFormatException nfe4) {
*                       problemDisplayer = "Make sure to enter a valid number.";
*                   }
*
*                   try {
*                       int test = numerator / denominator;
*                   } catch (ArithmeticException ae1) {
*                       problemDisplayer = "Make sure denominator is not 0";
*                   }
*
*                   inputMixedFraction = new MixedFraction(numerator, denominator, 0);
*                   return inputMixedFraction;
*               }
*               case 3 -> { //e.g "1 2/3"
*
*                   try {
*                       wholeNumber = Integer.parseInt(input[0]);
*                       numerator = Integer.parseInt(input[1]);
*                       denominator = Integer.parseInt(input[2]);
*                   } catch (NumberFormatException nfe4) {
*                       problemDisplayer = "Make sure to enter a valid number.";
*                   }
*
*                   try {
*                       int test = numerator/denominator;
*                   } catch (ArithmeticException ae2) {
*                       problemDisplayer = "Make sure denominator is not 0";
*                   }
*
*                   inputMixedFraction = new MixedFraction(numerator,denominator,wholeNumber);
*                   return inputMixedFraction;
*               }
*           }
*           return inputMixedFraction;
*       }//end of parseFraction method
*
*
**/
package prog2.prelimgroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Calculator represents a GUI class that can perform arithmetic
 * operations on mixed fractions.
 */
public class Calculator extends JFrame {
    private final JTextField fraction1TF = new JTextField(6);
    private final JTextField fraction2TF = new JTextField(6);
    private final JTextField reduceFractionTF = new JTextField(6);
    private final JTextField operationsTF = new JTextField(6);
    private final JTextField reduceTF = new JTextField( 6);
    private String problemDisplayer = "";
    private JComboBox<Character> boxOperator;
    private char selectedOperator;
    private final Container content;
    private final ButtonsHandler btnHandler = new ButtonsHandler();
    private JButton calculateBtn, clrButton, toOperations, toReduce, calculateBtn2, clrButton2;
    private final CardLayout cl = new CardLayout();

    /**
     * Creates no-argument constructor.
     * <p>Initializes the GUI components, and sets up the layout of
     * the calculator and attributes of the app's window.</p>
     */
    public Calculator() {

        operationsTF.setEditable(false);
        operationsTF.setHorizontalAlignment(SwingConstants.CENTER);

        reduceTF.setEditable(false);
        reduceTF.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel operationsPanel = new JPanel();
        setOperationPanel(operationsPanel);

        JPanel buttonsPanel1 = new JPanel();
        setButtonPanel(buttonsPanel1);

        JPanel buttonsPanel2 = new JPanel();
        setButtonPanel2(buttonsPanel2);

        JPanel reducePanel = new JPanel();
        setReducePanel(reducePanel);

        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());

        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());

        content = getContentPane();
        content.setLayout(cl);

        /*
          Add components to the first panel (operations)
         */
        firstPanel.add(operationsPanel, "North");
        firstPanel.add(buttonsPanel1, "Center");
        firstPanel.add(operationsTF, "South");

        /*
         * Add components to the second panel (reduce fractions)
         */
        secondPanel.add(reducePanel, "North");
        secondPanel.add(buttonsPanel2, "Center");
        secondPanel.add(reduceTF, "South");

        content.add(firstPanel, "1");
        content.add(secondPanel, "2");
        cl.show(content, "1");

        /*
         * Set window's attributes
         */
        setContentPane(content);
        pack();
        setTitle("Mixed Fractions Calculator");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    } //end of Calculator method

    
    /**
     * Runs the calculator program (main method).
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        Calculator test;
        try {
            test = new Calculator();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    } //end of main method

    /**
     * Sets operation panel. which includes the text fields for
     * fraction 1 and 2, combo box for operations and labels
     * <p>Initializes combo box for basic math operations, and labels
     * for fraction 1 and 2.</p>
     * <p>Appends components for fraction 1 and 2 text fields</p>
     * @param panel The operations panel
     */
    private void setOperationPanel(JPanel panel) {

        // Combo box
        Character[] operators = {'+', '-', '*', '/'};
        boxOperator = new JComboBox<>(operators);
        boxOperator.setSelectedItem('+');
        boxOperator.addActionListener(btnHandler);

        panel.add(new JLabel("Fraction 1: "));
        panel.add(fraction1TF);
        panel.add(boxOperator);
        panel.add(new JLabel("Fraction 2: "));
        panel.add(fraction2TF);
        panel.add(new JLabel(" = ?"));

    } //end of setOperationPanel method

    /**
     * Sets button panel for the first panel.
     * <p>Creates three buttons for operations panel: calculate
     * button, clear button, and reduce fraction button.</p>
     * @param panel The button panel for operations
     */
    private void setButtonPanel(JPanel panel) {

        // calculate button
        calculateBtn = new JButton("Calculate");
        calculateBtn.addActionListener(btnHandler);

        // clear button
        clrButton = new JButton("Clear");
        clrButton.addActionListener(btnHandler);

        // to reduce fraction panel button
        toReduce = new JButton("Reduce fraction");
        toReduce.addActionListener(btnHandler);

        panel.add(calculateBtn);
        panel.add(clrButton);
        panel.add(toReduce);
    } //end of setButtonPanel method

    /**
     * Sets reduce (second) panel.
     * <p>Appends components, JLabel and text field for reduce fraction</p>
     * @param panel The reduce panel
     */
    private void setReducePanel(JPanel panel) {
        panel.add(new JLabel("Reduce Fraction: "));
        panel.add(reduceFractionTF);
    } //end of setReducePanel method

    /**
     * Sets button panel for the second panel.
     * <p>Creates three buttons for reduce fraction panel: calculate
     * button, clear button, and perform operations button.</p>
     * @param panel The button panel for reduce fraction
     */
    private void setButtonPanel2(JPanel panel) {
        // calculate button
        calculateBtn2 = new JButton("Calculate");
        calculateBtn2.addActionListener(btnHandler);


        // clear button
        clrButton2 = new JButton("Clear");
        clrButton2.addActionListener(btnHandler);

        // to operations panel button
        toOperations = new JButton("Perform operations");
        toOperations.addActionListener(btnHandler);

        panel.add(calculateBtn2);
        panel.add(clrButton2);
        panel.add(toOperations);
    } //end of setButtonPanel2 method

    /**
     * ButtonsHandler class processes action events.
     */
    private class ButtonsHandler implements ActionListener {
    
        /**
         * <p>If source of event is combo box, then operator is based
         * on selected choice</p>
         * <p>If the calculate button on first panel is pressed:</p>
         * <p>- first checks if both text fields have fraction inputs, and
         * displays error message when incomplete.</p>
         * <p>- then performs appropriate arithmetic operation on the two
         * fractions by calling corresponding method, afterwards results
         * are displayed.</p>
         * <p>If the calculate button on second panel is pressed, works
         * similarly to the first one, but requires only one fraction input
         * and instead of performing operations, results from reducing a
         * fraction are displayed.</p>
         * <p>If the clear button is pressed, then all input and output
         * fields are removed.</p>
         * <p>If the reduce fraction button is pressed, then program
         * switches to show reduce fraction panel.</p>
         * <p>If the perform operations button is pressed, then program
         * switches back to show operations panel.</p>
         * @param e the event to be processed
         */    
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boxOperator) {
                selectedOperator = (char) boxOperator.getSelectedItem();
            }

            if (e.getSource() == calculateBtn) {
                MixedFraction mixedFrac1 = new MixedFraction();
                MixedFraction mixedFrac2 = new MixedFraction();

                String fraction1Str = fraction1TF.getText();
                String fraction2Str = fraction2TF.getText();

                if (fraction1Str.equals("") || fraction2Str.equals(""))
                    problemDisplayer = "Incomplete inputs";
                else {
                    mixedFrac1 = parseFraction(fraction1Str);
                    mixedFrac2 = parseFraction(fraction2Str);
                }

                if (problemDisplayer.equals("")) {
                    switch (selectedOperator) {
                        case '-' -> {
                            MixedFraction answer = mixedFrac1.subtract(mixedFrac2);
                            operationsTF.setText(answer + " or " + answer.toDouble());
                        }
                        case '*' -> {
                            MixedFraction answer2 = mixedFrac1.multiply(mixedFrac2);
                            operationsTF.setText(answer2 + " or " + answer2.toDouble());
                        }
                        case '/' -> {
                            MixedFraction answer3;
                            try {
                                answer3 = mixedFrac1.divide(mixedFrac2);
                                operationsTF.setText(answer3 + " or " + answer3.toDouble());
                            } catch (ArithmeticException ex1){
                                problemDisplayer = "Divisor cannot be 0";
                            }

                            if (operationsTF.getText().equals("")){
                                operationsTF.setText("Divisor cannot be 0");
                                fraction1TF.setText("");
                                fraction2TF.setText("");
                                problemDisplayer = "";
                            }
                        }
                        default -> {
                            MixedFraction answer1 = mixedFrac1.add(mixedFrac2);
                            operationsTF.setText(answer1 + " or " + answer1.toDouble());
                        }
                    }
                } else {
                    operationsTF.setText(problemDisplayer);
                    fraction1TF.setText("");
                    fraction2TF.setText("");
                    problemDisplayer = "";
                }
            }

            if (e.getSource() == calculateBtn2) {
                MixedFraction mixedFrac3 = new MixedFraction();

                String fraction3Str = reduceFractionTF.getText();

                if (fraction3Str.equals(""))
                    problemDisplayer = "Incomplete input";
                else {
                    mixedFrac3 = parseFraction(fraction3Str);
                }

                if (problemDisplayer.equals("")) {
                    Fraction fraction3 = mixedFrac3.mixedToImproper();
                    fraction3 = fraction3.reduceFraction();
                    MixedFraction answer4 = fraction3.improperToMixed();
                    reduceTF.setText(answer4 + " or " + answer4.toDouble());
                } else {
                    reduceTF.setText(problemDisplayer);
                    reduceFractionTF.setText("");
                    problemDisplayer = "";
                }
            }

            if (e.getSource() == clrButton || e.getSource() == clrButton2) {
                fraction1TF.setText("");
                fraction2TF.setText("");
                operationsTF.setText("");
                reduceFractionTF.setText("");
                reduceTF.setText("");
            }

            if (e.getSource() == toReduce) {
                cl.show(content, "2");
            }

            if (e.getSource() == toOperations) {
                cl.show(content, "1");
            }
        } //end of actionPerformed method


        /**
         * Reads input fraction and returns it as a Mixed Fraction.
         * <p>Splits the fraction string by spaces or slashes into an
         * array of String elements.</p>
         * <p>Initializes variables of a mixed fraction.</p>
         * <p>Initializes new Mixed Fraction for the parsed fraction
         * returned by the switch statement:</p>
         * <p>(Each cases checks invalid input, then displays appropriate
         * error message.)</p>
         * <p>- Case 1 if input only has one element, it represents a
         * whole number.</p>
         * <p>- Case 2 if input has two elements, represents a
         * fraction.</p>
         * <p>- Case 3 if input has three elements, represents a
         * mixed fraction.</p>
         * <p>Sets the Mixed Fraction what mixed fraction was represented</p>
         * @param fraction The input fraction
         * @return <code> MixedFraction </code> representing the new Mixed
         * Fraction that was converted input string fraction
         */
        private MixedFraction parseFraction(String fraction) {

            String[] input = fraction.split("[ /]", 3);

            MixedFraction inputMixedFraction = new MixedFraction();

            int wholeNumber = 0;
            int numerator = 0;
            int denominator = 1;

            switch (input.length) {
                case 1 -> { //e.g "1"

                    try {
                        wholeNumber = Integer.parseInt(input[0]);
                    } catch (NumberFormatException nfe1) {
                        problemDisplayer = "Make sure to enter a valid number.";
                    }

                    inputMixedFraction = new MixedFraction(0, 1, wholeNumber);
                    return inputMixedFraction;
                }
                case 2 -> { // e.g "1/2"

                    try {
                        numerator = Integer.parseInt(input[0]);
                        denominator = Integer.parseInt(input[1]);
                    } catch (NumberFormatException nfe4) {
                        problemDisplayer = "Make sure to enter a valid number.";
                    }

                    try {
                        int test = numerator / denominator;
                    } catch (ArithmeticException ae1) {
                        problemDisplayer = "Make sure denominator is not 0";
                    }

                    inputMixedFraction = new MixedFraction(numerator, denominator, 0);
                    return inputMixedFraction;
                }
                case 3 -> { //e.g "1 2/3"

                    try {
                        wholeNumber = Integer.parseInt(input[0]);
                        numerator = Integer.parseInt(input[1]);
                        denominator = Integer.parseInt(input[2]);
                    } catch (NumberFormatException nfe4) {
                        problemDisplayer = "Make sure to enter a valid number.";
                    }

                    try {
                        int test = numerator/denominator;
                    } catch (ArithmeticException ae2) {
                        problemDisplayer = "Make sure denominator is not 0";
                    }

                    inputMixedFraction = new MixedFraction(numerator,denominator,wholeNumber);
                    return inputMixedFraction;
                }
            }
            return inputMixedFraction;
        }//end of parseFraction method
    }//end of Calculator class
}
