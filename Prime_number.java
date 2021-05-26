// Hawzhin Hassan Mohammed
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Prime_number extends JFrame implements ActionListener {

    JPanel p;
    JLabel txt, result, result_1, result_2, result_3;
    JButton bt;
    JTextField input;

    int iteration_1 = 0;
    int iteration_2 = 0;

    String factors = "";

    Prime_number() {
        p = new JPanel();
        p.setBackground(Color.GRAY);
        p.setLayout(null);

        txt = new JLabel("Please give a number:");
        txt.setForeground(Color.white);
        txt.setBounds(50, 10, 400, 50);
        txt.setFont(new Font("Arial", 1, 20));

        input = new JTextField();
        input.setBounds(50, 70, 300, 50);
        input.setFont(new Font("Arial", 1, 20));

        bt = new JButton("Check the Number");
        bt.setBounds(50, 130, 300, 50);
        bt.setFont(new Font("Arial", 1, 20));
        bt.addActionListener(this);

        result = new JLabel("Result:");
        result.setForeground(Color.white);
        result.setBounds(50, 180, 400, 50);
        result.setFont(new Font("Arial", 1, 20));

        result_1 = new JLabel("");
        result_1.setForeground(Color.white);
        result_1.setBounds(50, 210, 700, 50);
        result_1.setFont(new Font("Arial", 1, 20));

        result_2 = new JLabel("");
        result_2.setForeground(Color.white);
        result_2.setBounds(50, 240, 700, 50);
        result_2.setFont(new Font("Arial", 1, 20));

        result_3 = new JLabel("");
        result_3.setForeground(Color.white);
        result_3.setBounds(50, 270, 700, 50);
        result_3.setFont(new Font("Arial", 1, 20));

        p.add(txt);
        p.add(input);
        p.add(bt);
        p.add(result);
        p.add(result_1);
        p.add(result_2);
        p.add(result_3);

        add(p);
        setTitle("Hawzin Hassan Mohammed");
        setSize(800, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean first_method(int n) {
        int counter = 0;
        for (int num = n; num >= 1; num--) {
            iteration_1++;
            if (n % num == 0) {
                counter = counter + 1;
                if (num != 1 && num != n) {
                    factors += num + ",";
                }

            }
        }

        iteration_1 -= 2;
        if (counter == 2) {
            return true;
        } else {
            return false;
        }

    }

    public boolean second_method(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            iteration_2++;
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt) {

            iteration_1 = 0;
            iteration_2 = 0;
            factors = "";
            String num = input.getText();
            if (!num.equals("")) {
                int x = Integer.parseInt(num);

                if (first_method(x)) {

                    result_1.setText(x + " is a prime number");
                    result_2.setText("With 1st method number of iteration  is:" + iteration_1);
                } else {
                    result_1.setText(x + " is composite number and factors are -> " + factors);
                    result_2.setText("With 1st method number of iteration  is:" + iteration_1);

                }

                //////////////////////////////////////////
                if (second_method(x)) {
                    //  if (first_method(x)) {
                    result_3.setText("With 2nd method number of iteration  is:" + iteration_2);
                } else {
                    result_3.setText("With 2nd method number of iteration  is:" + iteration_2);

                }

                input.setText("");
            }

        }

    }

    public static void main(String[] args) {
        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    Prime_number window = new Prime_number();
                    window.setLocationRelativeTo(null);
                    window.setVisible(true);
                }
            });
        } catch (Exception e) {
            System.out.println(" Look & Feel error :" + e.getMessage());
        }
    }

}
