package exam;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// 마우스의 움직임을 확인하라.
public class Exam02 {
    public static void main(String[] args) {
        MouseEventFrame frame = new MouseEventFrame();

        frame.setVisible(true);
    }

    private static class MouseEventFrame extends Frame implements MouseListener {

        public MouseEventFrame() {
            this.setSize(200, 100);
            this.addMouseListener(this);
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Clicked : " + e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Pressed : " + e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Release : " + e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("Entered : " + e);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("Exited : " + e);
        }
    }
}
