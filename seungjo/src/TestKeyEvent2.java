import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

public class TestKeyEvent2 {

    public static class KeyEventFrame extends JFrame implements KeyListener {

        Map<Integer, Boolean> keyStatus;

        public KeyEventFrame() {
            // 키 상태를 저장하기 위한 맵
            keyStatus = new HashMap<>();

            // 테스트 프레임 크기 : 200 x 100
            this.setSize(200, 100);

            // ActionEvent에 리스너를 등록
            addKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // 키 누름이 감지되면 출력
            System.out.println("key typed : " + e.getKeyChar());
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // 키 누름이 감지되면 출력
            if (!keyStatus.containsKey(e.getKeyCode())) {
                keyStatus.put(e.getKeyCode(), false);
            }
            if (!keyStatus.get(e.getKeyCode())) {
                keyStatus.put(e.getKeyCode(), true);
                System.out.println("key pressed : " + e.getKeyChar());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // 키 누름이 해제되면 출력
            if (keyStatus.containsKey(e.getKeyCode())) {
                keyStatus.put(e.getKeyCode(), false);
                System.out.println("key released : " + e.getKeyChar());
            }
        }

    }

    public static void main(String[] args) throws Exception {
        KeyEventFrame frame = new KeyEventFrame();

        frame.setVisible(true);
    }
}
