package exam;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Exam05 {
    public static class KeyEventFrame extends JFrame implements KeyListener {

        public KeyEventFrame() {
            this.setSize(200, 100);

            this.addKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("key type : " +  e.getKeyChar());
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed : " + e.getKeyChar());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released: " + e.getKeyChar());
        }
    }
    public static void main(String[] args) {
        KeyEventFrame frame = new KeyEventFrame();

        frame.setVisible(true);
    }
}
