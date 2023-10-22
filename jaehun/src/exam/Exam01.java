package exam;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 버튼을 이용해 카운터를 증가시켜라.
public class Exam01 {
    public static int count = 0;


    public static class ButtonEventFrame extends Frame implements ActionListener {
        public ButtonEventFrame() {
            this.setSize(200, 100);

            Button button = new Button();
            button.setBounds(getWidth() / 2 - 50, 30, 100, 40);
            button.setLabel("Click!!");

            button.addActionListener(this);

            add(button);
            setLayout(null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button : " + e);
            System.out.println("count : " + count++);
        }
    }
    public static void main(String[] args) {
        ButtonEventFrame frame = new ButtonEventFrame();

        frame.setVisible(true);
    }
}
