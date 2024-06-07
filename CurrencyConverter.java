import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class CurrencyConverter { 

    private static final double CONVERSION_RATE = 83.46; 

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel labelRupees = new JLabel("Rupees:");
        labelRupees.setBounds(20, 40, 60, 30);
        frame.add(labelRupees);

        JTextField textRupees = new JTextField("0");
        textRupees.setBounds(80, 40, 100, 30);
        frame.add(textRupees);

        JLabel labelDollars = new JLabel("Dollars:");
        labelDollars.setBounds(200, 40, 60, 30);
        frame.add(labelDollars);

        JTextField textDollars = new JTextField("0");
        textDollars.setBounds(260, 40, 100, 30);
        frame.add(textDollars);

        JButton buttonConvertToUSD = new JButton("Convert to USD");
        buttonConvertToUSD.setBounds(50, 100, 140, 30);
        frame.add(buttonConvertToUSD);

        JButton buttonConvertToINR = new JButton("Convert to INR");
        buttonConvertToINR.setBounds(200, 100, 140, 30);
        frame.add(buttonConvertToINR);

        JButton buttonClose = new JButton("Close");
        buttonClose.setBounds(150, 180, 100, 30);
        frame.add(buttonClose);

        buttonConvertToUSD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double rupees = Double.parseDouble(textRupees.getText());
                    double dollars = rupees / CONVERSION_RATE;
                    textDollars.setText(String.format("%.2f", dollars));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonConvertToINR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double dollars = Double.parseDouble(textDollars.getText());
                    double rupees = dollars * CONVERSION_RATE;
                    textRupees.setText(String.format("%.2f", rupees));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
