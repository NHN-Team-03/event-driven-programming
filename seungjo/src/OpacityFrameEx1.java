import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OpacityFrameEx1 extends JFrame implements ChangeListener {
    JSlider slider;
    JLabel label;

    public OpacityFrameEx1() {
        // 불투명도 설정 슬라이드 (0 ~ 100)
        this.slider = new JSlider(0, 100, 100);

        // 값 출력용 레이블
        this.label = new JLabel();

        // 프레임 크기 설정
        this.setSize(300, 100);

        // 슬라이드에 트랙, 틱 표시
        this.slider.setPaintTrack(true);
        this.slider.setPaintTicks(true);
        this.slider.setPaintLabels(true);

        // 슬라이드 눈금을 표시 (작은 눈금 5, 큰 눈금 20)
        this.slider.setMajorTickSpacing(20);
        this.slider.setMinorTickSpacing(5);

        // 슬라이드 값이 변경될 때 마다 호출
        this.slider.addChangeListener(this);

        // 패널 구성
        JPanel panel = new JPanel();
        panel.add(this.slider);
        panel.add(this.label);

        this.add(panel);

        // 초기 표시
        this.stateChanged(null);
    }
    @Override
    public void stateChanged(ChangeEvent e) {

        // 불투명도 출력
        this.label.setText("Opacity value is = " + this.slider.getValue());

        // 불투명도 설정
        this.setOpacity(this.slider.getValue() * 0.01f);
    }

    public static void main(String[] args) {
        OpacityFrameEx1 frame = new OpacityFrameEx1();

        // 프레임을 불투명도로 제어하기 위해서는 장식이 없어야 함.
        frame.setUndecorated(true);

        // 타이틀바가 없어 이동할 수 없음. 생성시 특정 위치에 생성
        frame.setLocation(500, 300);

        frame.setVisible(true);
    }
}
