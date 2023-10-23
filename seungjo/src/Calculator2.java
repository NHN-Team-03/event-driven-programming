import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Calculator2 extends Frame {
    private JTextField textField;
    private int operand[];
    private int operandIndex;
    private String operator = "";

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
        if (this.operandIndex == 1) {
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
            this.operand[0] = 0;
            this.operand[1] = 0;
            this.operandIndex = 0;
            this.operator = "";
            this.output(String.valueOf(value));
        }
    };


    static public class ButtonInfo {
        public String title;
        public int gridx;
        public int gridy;
        public int gridwidth;
        public ActionListener actionListener;

        public ButtonInfo(String title, int gridx, int gridy, int gridwidth) {
            this.title = title;
            this.gridx = gridx;
            this.gridy = gridy;
            this.gridwidth = gridwidth;
        }

        public ButtonInfo(String title, int gridx, int gridy, int gridwidth, ActionListener actionListener) {
            this(title, gridx, gridy, gridwidth);
            this.actionListener = actionListener;
        }
    }

    public Calculator2() throws InterruptedException {
        this.operand = new int[] {0, 0};
        this.operandIndex = 0;

        ButtonInfo[] buttonInfos = new ButtonInfo[] {
                new ButtonInfo("0", 0, 4, 1, action -> {
                    inputDigit.accept("0");
                }),
                new ButtonInfo("1", 0, 3, 1, action -> {
                    inputDigit.accept("1");
                }),
                new ButtonInfo("2", 1, 3, 1, action -> {
                    inputDigit.accept("2");
                }),
                new ButtonInfo("3", 2, 3, 1, action -> {
                    inputDigit.accept("3");
                }),
                new ButtonInfo("4", 0, 2, 1, action -> {
                    inputDigit.accept("4");
                }),
                new ButtonInfo("5", 1, 2, 1, action -> {
                    inputDigit.accept("5");
                }),
                new ButtonInfo("6", 2, 2, 1, action -> {
                    inputDigit.accept("6");
                }),
                new ButtonInfo("7", 0, 1, 1, action -> {
                    inputDigit.accept("7");
                }),
                new ButtonInfo("8", 1, 1, 1, action -> {
                    inputDigit.accept("8");
                }),
                new ButtonInfo("9", 2, 1, 1, action -> {
                    inputDigit.accept("9");
                }),
                new ButtonInfo("+", 3, 1, 1, action -> {
                    inputOperator.accept("+");
                }),
                new ButtonInfo("-", 3, 2, 1, action -> {
                    inputOperator.accept("-");
                }),
                new ButtonInfo("*", 3, 3, 1, action -> {
                    inputOperator.accept("*");
                }),
                new ButtonInfo("/", 3, 4, 1, action -> {
                    inputOperator.accept("/");
                }),
                new ButtonInfo("=", 1, 5, 2, action -> {
                    calculation.accept("=");
                }),
                new ButtonInfo("AC", 0, 5, 1, action -> {
                    this.init();
                })
        };

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // 제목 설정
        this.setTitle("Calculator");
        // 크기 설정
        this.setSize(350, 200);
        // Layout 종류 지정
        this.setLayout(new GridBagLayout());

        // 초기 값 (0) 설정
        this.textField = new JTextField("0");
        this.textField.setHorizontalAlignment(JTextField.RIGHT);
        this.textField.setForeground(Color.WHITE);
        this.textField.setBackground(Color.GRAY);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        this.add(this.textField, constraints);

        for (ButtonInfo buttonInfo : buttonInfos) {
            JButton button = new JButton(buttonInfo.title);
            constraints.gridx = buttonInfo.gridx;
            constraints.gridy = buttonInfo.gridy;
            constraints.gridwidth = buttonInfo.gridwidth;
            constraints.gridheight = 1;
            if (buttonInfo.actionListener != null) {
                button.addActionListener(buttonInfo.actionListener);
            }
            this.add(button, constraints);
        }
    }

    public void init() {
        this.operand[0] = 0;
        this.operand[1] = 0;
        this.operandIndex = 0;
        this.operator = "";

        this.output(String.valueOf(0));
    }

    public void output(String text) {
        if (text.length() == 0) {
            this.textField.setText("0");
        } else {
            this.textField.setText(text);
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        Calculator2 calculator = new Calculator2();

        calculator.setVisible(true);
    }
}