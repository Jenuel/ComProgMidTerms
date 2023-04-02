

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField fraction1TF = new JTextField(6);
    private JTextField fraction2TF = new JTextField(6);
    private JTextField reduceFractionTF = new JTextField(6);
    static JTextArea operationsTA = new JTextArea();
    static JTextArea reduceTA = new JTextArea();
    public static String outStr = "";
    private JComboBox boxOperator;
    private char selectedOperator;
    private CardLayout cl = new CardLayout();
    private JPanel content;

    public Calculator() {

        /**
         * Create/Initialize Components
         */
        // Combo box
        Character[] operators = {'+', '-', '*', '/'};
        boxOperator = new JComboBox<>(operators);
        operationsBoxHandler operationsHandler = new operationsBoxHandler();
        boxOperator.addActionListener(operationsHandler);

        // calculate button
        JButton calculateBtn1 = new JButton("Calculate");
        calculateButtonHandler calculateHandler = new calculateButtonHandler();
        calculateBtn1.addActionListener(calculateHandler);

        JButton calculateBtn2 = new JButton("Calculate");
        calculateHandler = new calculateButtonHandler();
        calculateBtn2.addActionListener(calculateHandler);

        // clear button
        JButton clrBtn1 = new JButton("Clear");
        clrButtonHandler clrHandler = new clrButtonHandler();
        clrBtn1.addActionListener(clrHandler);

        JButton clrBtn2 = new JButton("Clear");
        clrHandler = new clrButtonHandler();
        clrBtn2.addActionListener(clrHandler);

        // text area
        operationsTA.setEditable(false);
        reduceTA.setEditable(false);

        // to secondPanel panel button
        JButton toReduce = new JButton("Switch to reduce fraction calculator");
        toReduceButtonHandler toReduceHandler = new toReduceButtonHandler();
        toReduce.addActionListener(toReduceHandler);

        // to operations panel button
        JButton toOperations = new JButton("Switch to operations calculator");
        toOperationsButtonHandler toOperationsHandler = new toOperationsButtonHandler();
        toOperations.addActionListener(toOperationsHandler);

        /**
         * Create content pane and set layout
         */
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());

        JPanel operationsPanel = new JPanel();
        operationsPanel.setLayout(new FlowLayout());

        JPanel buttonsPanel1 = new JPanel();
        buttonsPanel1.setLayout(new FlowLayout());

        JPanel buttonsPanel2 = new JPanel();
        buttonsPanel2.setLayout(new FlowLayout());

        JPanel reducePanel = new JPanel();
        reducePanel.setLayout(new FlowLayout());

        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());

        content = new JPanel();
        content.setLayout(cl);

        /**
         * Add components to the first panel (operations)
         */
        operationsPanel.add(new JLabel("Fraction 1: "));
        operationsPanel.add(fraction1TF);
        operationsPanel.add(boxOperator);
        operationsPanel.add(new JLabel("Fraction 2: "));
        operationsPanel.add(fraction2TF);
        operationsPanel.add(new JLabel(" = ?"));

        buttonsPanel1.add(clrBtn1);
        buttonsPanel1.add(calculateBtn1);
        buttonsPanel1.add(toReduce);

        firstPanel.add(operationsPanel, "North");
        firstPanel.add(buttonsPanel1, "Center");
        firstPanel.add(operationsTA, "South");

        /**
         * Add components to the second panel (reduce fractions)
         */
        reducePanel.add(new JLabel("Reduce Fraction: "));
        reducePanel.add(reduceFractionTF);

        buttonsPanel2.add(clrBtn2);
        buttonsPanel2.add(calculateBtn2);
        buttonsPanel2.add(toOperations);

        secondPanel.add(reducePanel, "North");
        secondPanel.add(buttonsPanel2, "Center");
        secondPanel.add(reduceTA, "South");

        content.add(firstPanel, "1");
        content.add(secondPanel, "2");
        cl.show(content, "1");

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        Calculator test = new Calculator();

    }

    private class operationsBoxHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            selectedOperator = (char) boxOperator.getSelectedItem();
        }
    }

    private class calculateButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

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
    }

    private class clrButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fraction1TF.setText("");
            fraction2TF.setText("");
            operationsTA.setText("");
            reduceFractionTF.setText("");
            reduceTA.setText("");
        }

    }

    private class toReduceButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(content, "2");
        }
    }

    private class toOperationsButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(content, "1");
        }
    }

    public static MixedFraction parseFraction(String fraction) {
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
                inputMixedFraction = new MixedFraction(new Fraction(numerator, denominator));
                return inputMixedFraction;

            case 3: //e.g "1 2/3"
                inputMixedFraction = new MixedFraction(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[0]));
                return inputMixedFraction;

        }
        return inputMixedFraction;
    }//end of parseFraction method
}//end of Calculator class
