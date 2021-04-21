package HomeWork8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator v1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(150, 50, 400, 500);
        setLayout(new BorderLayout());

        JTextField inputField = new JTextField();
        add(inputField, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(5, 3));
        add(bottomPanel, BorderLayout.CENTER);

        DigitButtonActionListener digitButtonActionListener = new DigitButtonActionListener(inputField);
        for (int i = 0; i <= 9; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.addActionListener(digitButtonActionListener);
            bottomPanel.add(jButton);
        }
    }
}