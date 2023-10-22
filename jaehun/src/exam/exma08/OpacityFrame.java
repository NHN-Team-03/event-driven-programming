package exam.exma08;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OpacityFrame extends JFrame implements ChangeListener, ActionListener {
    private JSlider slider;
    private JLabel label;
    private JButton button;
    private JTextField textField;

    public OpacityFrame() {
        // 불투명도 설정 슬라이드 (0 ~ 100)
        this.slider = new JSlider(0, 100, 100);
        // 값 출력용 레이블
        this.label = new JLabel();
        // 설정 버튼
        this.button = new JButton("설정");
        // 입력
        this.textField = new JTextField("Value");
        this.textField.setHorizontalAlignment(SwingConstants.RIGHT);

        // 프레임을 불투명도로 제어하기 위해서는 타이틀바 등의 장식이 없어야 한다.
        this.setUndecorated(true);
        // 프레임 크기 설정
        this.setSize(300,200);

        // 슬라이드에 트랙, 틱,  표시
        this.slider.setPaintTrack(true);
        this.slider.setPaintTicks(true);
        this.slider.setPaintLabels(true);

        // 슬라이드 눈금을 표시(작은 눈금 5, 큰 눈금 20)
        this.slider.setMajorTickSpacing(20);
        this.slider.setMinorTickSpacing(5);

        // 슬라이드 값이 변경될때 마다 호출
        this.slider.addChangeListener(this);
        // 설정 버튼을 누를 경우 호출
        this.button.addActionListener(this);

        // 패널 구성
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        this.setLayout(new BorderLayout(100, 100));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(00,30,0,30);  // 위쪽 공간
        constraints.gridy = 0;
        panel.add(this.slider, constraints);
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(00,0,0,0);  // 위쪽 공간
        constraints.gridy = 1;
        panel.add(this.label, constraints);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.weightx = 1;
        constraints.insets = new Insets(10,100,0,0);  // 위쪽 공간
        constraints.gridy = 2;
        panel.add(this.textField, constraints);
        constraints.fill = GridBagConstraints.EAST;
        constraints.gridx = 2;
        constraints.gridwidth = 1;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(10,0,0,0);  // 위쪽 공간
        constraints.gridy = 2;
        panel.add(this.button, constraints);

        this.setLayout(new BorderLayout(100, 100));
        this.add(panel);

        // 초기 표시
        this.stateChanged(null);
    }

    @Override
    public void stateChanged(ChangeEvent event) {
        // 불투명도 출력
        this.label.setText("Opacity value is =" + this.slider.getValue());
        this.textField.setText("" + this.slider.getValue());
        // 불투명도 설정
        this.setOpacity(this.slider.getValue() * 0.01f);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Integer value = Integer.parseInt(this.textField.getText());
            if (value < 0 || 100 < value ) {
                // 허용 값의 범위를 벗어난 경우
                MessageDialog dialog = new MessageDialog(this);
                dialog.setVisible(true);
                // 잘못 입력된 값을 돌려 놓는다
                this.textField.setText(""+this.slider.getValue());
            } else {
                this.slider.setValue(value);
                // 불투명도 출력
                this.label.setText("Opacity value is =" + this.slider.getValue());
                // 불투명도 설정
                this.setOpacity(this.slider.getValue() * 0.01f);
            }
        } catch(Exception exception) {
            this.textField.setText(""+this.slider.getValue());
        }
    }
}
