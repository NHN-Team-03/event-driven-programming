import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestMouseEvent {
    public static class MouseEventFrame extends Frame implements MouseListener {

        public MouseEventFrame() {
            // 테스트 프레임 크기 : 200 x 100
            this.setSize(200, 100);

            // ActionEvent 리스너를 등록
            this.addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // 마우스 클릭시 아래의 메시지 출력
            System.out.println("Clicked : " + e.getPoint());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // 마우스 누를 때 아래의 메시지 출력
            System.out.println("Pressed : " + e.getPoint());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // 마우스를 떼면 아래의 메시지 출력
            System.out.println("Released : " + e.getPoint());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // 마우스가 프레임 안으로 들어오면 아래의 메시지 출력
            System.out.println("Entered : " + e.getPoint());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // 마우스가 프레임 밖으로 나가면 아래의 메시지 출력
            System.out.println("Exited : " + e.getPoint());
        }
    }

    public static void main(String[] args) {
        MouseEventFrame frame = new MouseEventFrame();

        frame.setVisible(true);
    }
}
