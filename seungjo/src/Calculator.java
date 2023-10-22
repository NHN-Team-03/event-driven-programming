import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Calculator {

    public static void main(String[] args) {
        Frame frame = new Frame();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // 제목 설정
        frame.setTitle("Calculator");

        // 크기 설정
        frame.setSize(400, 200);

        // Layout 종류 지정
        frame.setLayout(new GridBagLayout());

        JTextField textField = new JTextField("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.GRAY);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        frame.add(textField, constraints);

        JButton button = new JButton("7");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("8");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("9");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("+");
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("4");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("5");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("6");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("-");
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("1");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("2");
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("3");
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("*");
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("0");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("/");
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("=");
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        button = new JButton("AC");
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button, constraints);

        frame.setVisible(true);
    }
}