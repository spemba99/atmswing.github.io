import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class atm extends JFrame {
    private JTextField amountTextField;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton checkBalanceButton;
    private JLabel amountLabel;
    private JLabel balanceLabel;
    private double balance = 0;

    public atm() {
        setLayout(new FlowLayout());

        amountLabel = new JLabel("Enter amount: ");
        add(amountLabel);

        amountTextField = new JTextField(10);
        add(amountTextField);

        withdrawButton = new JButton("Withdraw");
        add(withdrawButton);

        depositButton = new JButton("Deposit");
        add(depositButton);

        checkBalanceButton = new JButton("Check Balance");
        add(checkBalanceButton);

        balanceLabel = new JLabel("Balance: $" + balance);
        add(balanceLabel);

        ButtonHandler handler = new ButtonHandler();
        withdrawButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        checkBalanceButton.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == withdrawButton) {
                double amount = Double.parseDouble(amountTextField.getText());
                if (amount > balance) {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                } else {
                    balance -= amount;
                    balanceLabel.setText("Balance: $" + balance);
                }
            } else if (event.getSource() == depositButton) {
                double amount = Double.parseDouble(amountTextField.getText());
                balance += amount;
                balanceLabel.setText("Balance: $" + balance);
            } else if (event.getSource() == checkBalanceButton) {
                JOptionPane.showMessageDialog(null, "Current balance: $" + balance);
            }
        }
    }

    public static void main(String[] args) {
        atm atm = new atm();
        atm.setTitle("ATM");
        atm.setSize(300, 150);
        atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atm.setVisible(true);
    }
}
