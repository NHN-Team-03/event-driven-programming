package exam;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

public class Exam06 {
    public static class KeyEventFrame extends JFrame implements KeyListener {
        Map<Integer, Boolean> keyStatus;

        public KeyEventFrame() {
            keyStatus = new HashMap<>();

            this.setSize(200, 100);
            this.addKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("key typed : " + e.getKeyChar());
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (!this.keyStatus.containsKey(e.getKeyCode())){
                this.keyStatus.put(e.getKeyCode(), false);
            }

            if (!this.keyStatus.get(e.getKeyCode())) {
                this.keyStatus.put(e.getKeyCode(), true);
                System.out.println("key pressed : " +  e.getKeyChar());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(this.keyStatus.containsKey(e.getKeyCode())) {
                this.keyStatus.put(e.getKeyCode(), false);
                System.out.println("key released : " + e.getKeyChar());
            }
        }
    }

    public static void main(String[] args) {
        KeyEventFrame frame = new KeyEventFrame();

        frame.setVisible(true);
    }
}
