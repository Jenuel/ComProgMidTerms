package prog2.prelimgroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField fraction1TF = new JTextField(6);
    private JTextField fraction2TF = new JTextField(6);
    private JTextField reduceFractionTF = new JTextField(6);
    static JTextArea operationsTA = new JTextArea(6,6);
    static JTextArea reduceTA = new JTextArea(6,6);
    public static String outStr = "";
    private JComboBox boxOperator;
    private char selectedOperator;
    private JPanel content;
    private ButtonsHandler btnHandler = new ButtonsHandler();
    private JButton calculateBtn, clrButton, toOperations, toReduce, calculateBtn2, clrButton2;
    private CardLayout cl = new CardLayout();

    public Calculator() {

        /**
         * Create content pane and set layout
         */

        // text area
        operationsTA.setEditable(false);
        reduceTA.setEditable(false);

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

        content = new JPanel();
        content.setLayout(cl);

        /**
         * Add components to the first panel (operations)
         */
        firstPanel.add(operationsPanel, "North");
        firstPanel.add(buttonsPanel1, "Center");
        firstPanel.add(operationsTA, "South");

        /**
         * Add components to the second panel (reduce fractions)
         */
        secondPanel.add(reducePanel, "North");
        secondPanel.add(buttonsPanel2, "Center");
        secondPanel.add(reduceTA, "South");

        content.add(firstPanel, "1");
        content.add(secondPanel, "2");
        cl.show(content, "1");

        /**
         * Set window's attributes
         */
        setContentPane(content);
        pack();
        setTitle("Mixed Fractions Calculator");
        setSize(550, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        Calculator test = new Calculator();
    }

    /**
     * Set operation panel which includes the text fields for fraction 1 and 2, combo box for operations and labels
     */
    public void setOperationPanel(JPanel panel){

        // Combo box
        Character[] operators = {'+', '-', '*', '/'};
        boxOperator = new JComboBox<>(operators);
        boxOperator.addActionListener(btnHandler);

        panel.add(new JLabel("Fraction 1: "));
        panel.add(fraction1TF);
        panel.add(boxOperator);
        panel.add(new JLabel("Fraction 2: "));
        panel.add(fraction2TF);
        panel.add(new JLabel(" = ?"));

    }

    /**
     * Set button panel for the first panel which includes a calculate button, clear button, and toReduce button
     * to switch to the second panel
     */
    public void setButtonPanel(JPanel panel){

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
    }

    /**
     * Set reduce panel which includes a JLabel, and reduce fraction text field
     */
    public void setReducePanel (JPanel panel){
        panel.add(new JLabel("Reduce Fraction: "));
        panel.add(reduceFractionTF);
    }

    /**
     * Set button panel for the second panel which include a calculate button, clear button, and toOperations
     * button to switch to the first panel
     */
    public void setButtonPanel2(JPanel panel){
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
    }

    /**
     * ButtonsHandler class
     */
    private class ButtonsHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == boxOperator){
                selectedOperator = (char) boxOperator.getSelectedItem();
            }

            if (e.getSource() == calculateBtn){
                String fraction1Str = fraction1TF.getText();
                String fraction2Str = fraction2TF.getText();

                MixedFraction mixedFrac1 = new MixedFraction();
                MixedFraction mixedFrac2 = new MixedFraction();

                mixedFrac1 = parseFraction(fraction1Str);
                mixedFrac2 = parseFraction(fraction2Str);

                switch (selectedOperator) {
                    case '-':
                        MixedFraction answer = mixedFrac1.subtract(mixedFrac2);
                        System.out.println(answer);
                        break;
                    case '*':
                        MixedFraction answer2 = mixedFrac1.multiply(mixedFrac2);
                        System.out.println(answer2);
                        break;
                    case '/':
                        MixedFraction answer3 = mixedFrac1.divide(mixedFrac2);
                        System.out.println(answer3);
                        break;
                    default:
                        MixedFraction answer1 = mixedFrac1.add(mixedFrac2);
                        System.out.println(answer1);
                        break;
                }
            }

            if (e.getSource() == calculateBtn2){
                String fraction3Str = reduceFractionTF.getText();

                MixedFraction mixedFrac3 = new MixedFraction();

                mixedFrac3 = parseFraction(fraction3Str);

                Fraction fraction3  = mixedFrac3.mixedToImproper();
                fraction3 = fraction3.reduceFraction();

                MixedFraction answer4 = fraction3.improperToMixed();
                System.out.println(answer4);
            }

            if (e.getSource() == clrButton || e.getSource() == clrButton2){
                fraction1TF.setText("");
                fraction2TF.setText("");
                operationsTA.setText("");
                reduceFractionTF.setText("");
                reduceTA.setText("");
            }

            if (e.getSource() == toReduce){
                cl.show(content, "2");
            }

            if (e.getSource() == toOperations){
                cl.show(content, "1");
            }
        }
    }

    /**
     * parseFraction method to read the input
     */
    public MixedFraction parseFraction(String fraction) {
        String[] input = fraction.split("[ /]");
        MixedFraction inputMixedFraction = new MixedFraction();

        switch (input.length) {
            case 1: //e.g "1"
                int wholeNumber = Integer.parseInt(input[0]);
                inputMixedFraction = new MixedFraction(0, 1, wholeNumber);
                return inputMixedFraction;

            case 2: // e.g "1/2"
                int numerator = Integer.parseInt(input[0]);
                int denominator = Integer.parseInt(input[1]);
                Fraction inputFraction = new Fraction(numerator, denominator);
                inputMixedFraction = inputFraction.improperToMixed();
                return inputMixedFraction;

            case 3: //e.g "1 2/3"
                inputMixedFraction = new MixedFraction(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[0]));
                return inputMixedFraction;
        }
        return inputMixedFraction;
    }//end of parseFraction method
}//end of Calculator class
