package exam;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Exam07 {

    public static void main(String[] args) {
        OpacityFrameEx1 frame = new OpacityFrameEx1();

        frame.setUndecorated(true);

        frame.setLocation(500, 300);

        frame.setVisible(true);
    }

    private static class OpacityFrameEx1 extends JFrame implements ChangeListener {
        private JSlider slider;
        private JLabel label;

        public OpacityFrameEx1() {
            this.slider = new JSlider(0, 100, 100);
            this.label = new JLabel();

            this.setSize(300, 100);

            this.slider.setPaintTrack(true);
            this.slider.setPaintTicks(true);
            this.slider.setPaintLabels(true);

            this.slider.setMajorTickSpacing(20);
            this.slider.setMinorTickSpacing(5);

            this.slider.addChangeListener(this);

            JPanel panel = new JPanel();
            panel.add(this.slider);
            panel.add(this.label);

            this.add(panel);

            this.stateChanged(null);
        }
        @Override
        public void stateChanged(ChangeEvent e) {
            this.label.setText("Opacity value is =" + this.slider.getValue());

            this.setOpacity(this.slider.getValue() * 0.01f);
        }
    }
}
