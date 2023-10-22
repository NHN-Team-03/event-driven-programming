package exam.exam04;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Calculator extends Frame {
    private JTextField textField;
    private int[] operand;
    private int operandIndex;
    private String operator = "";

    public Calculator() {
        this.operand = new int[] {0, 0};
        this.operandIndex = 0;

        ButtonInfo[] buttonInfo = new ButtonInfo[] {
                new ButtonInfo("7", 0, 1, 1, action -> inputDigit.accept("7")),
                new ButtonInfo("8", 1, 1, 1, action -> inputDigit.accept("8")),
                new ButtonInfo("9", 2, 1, 1, action -> inputDigit.accept("9")),
                new ButtonInfo("+", 3, 1, 1, action -> inputOperator.accept("+")),
                new ButtonInfo("4", 0, 2, 1, action -> inputDigit.accept("4")),
                new ButtonInfo("5", 1, 2, 1, action -> inputDigit.accept("5")),
                new ButtonInfo("6", 2, 2, 1, action -> inputDigit.accept("6")),
                new ButtonInfo("-", 3, 2, 1, action -> inputOperator.accept("-")),
                new ButtonInfo("1", 0, 3, 1, action -> inputDigit.accept("1")),
                new ButtonInfo("2", 1, 3, 1, action -> inputDigit.accept("2")),
                new ButtonInfo("3", 2, 3, 1, action -> inputDigit.accept("3")),
                new ButtonInfo("*", 3, 3, 1, action -> inputOperator.accept("*")),
                new ButtonInfo("0", 0, 4, 1, action -> inputDigit.accept("0")),
                new ButtonInfo("/", 3, 4, 1, action -> inputOperator.accept("/")),
                new ButtonInfo("=", 1, 5, 2, action -> calculation.accept("=")),
                new ButtonInfo("AC", 3, 5, 1, action -> this.init()),
        };

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill =GridBagConstraints.HORIZONTAL;

        this.setTitle("Calculator");
        this.setSize(400, 200);
        this.setLayout(new GridBagLayout());

        this.textField = new JTextField("0");
        this.textField.setHorizontalAlignment(JTextField.RIGHT);
        this.textField.setForeground(Color.WHITE);
        this.textField.setBackground(Color.GRAY);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;

        this.add(textField, constraints);


        for (ButtonInfo info : buttonInfo) {
            JButton button = new JButton(info.getTitle());
            constraints.gridx = info.getGridx();
            constraints.gridy = info.getGridy();
            constraints.gridwidth = info.getGridWidth();
            constraints.gridheight = 1;

            if(info.getAcitonListener() != null) {
                button.addActionListener(info.getAcitonListener());
            }

            this.add(button, constraints);
        }

    }

    private void init() {
        this.operand[0] = 0;
        this.operand[1] = 0;
        this.operandIndex = 0;
        this.operator = "";

        this.output(String.valueOf("0"));
    }

    private void output(String text) {
        if(text.length() == 0) {
            this.textField.setText("0");
        } else {
            this.textField.setText(text);
        }
    }

    Consumer<String> inputDigit = (digit) -> {
        this.operand[this.operandIndex] = this.operand[this.operandIndex] * 10 + Integer.valueOf(digit);
        this.output(String.valueOf(this.operand[this.operandIndex]));
    };

    Consumer<String> inputOperator = (operator) -> {
        if (this.operandIndex == 0) {
            this.operator = operator;
            this.operandIndex = 1;
        }
    };

    Consumer<String> calculation = (operator) -> {
        if(this.operandIndex == 1) {
            int value = 0;
            switch (this.operator) {
                case "+":
                    value = this.operand[0] + this.operand[1];
                    break;
                case "-":
                    value = this.operand[0] - this.operand[1];
                    break;
                case "*":
                    value = this.operand[0] * this.operand[1];
                    break;
                case "/":
                    value = this.operand[0] / this.operand[1];
                    break;
            }

            init();
            output(String.valueOf(value));
        }
    };


}
