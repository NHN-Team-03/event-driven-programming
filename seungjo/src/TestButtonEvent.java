import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestButtonEvent {

    public static class ButtonEventFrame extends Frame implements ActionListener {

        public ButtonEventFrame() {
            // 테스트 프레임 크기 : 200 x 100
            this.setSize(200, 100);

            Button button = new Button();
            button.setBounds(getWidth() / 2 - 50, 30, 100, 40);
            button.setLabel("Click!!!");

            // ActionEvent 리스너를 등록
            button.addActionListener(this);

            add(button);
            setLayout(null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // 버튼 클릭시 아래의 메시지 출력
            System.out.println("Button : " + e);
        }
    }

    public static void main(String[] args) {
        ButtonEventFrame frame = new ButtonEventFrame();

        frame.setVisible(true);
    }
}
