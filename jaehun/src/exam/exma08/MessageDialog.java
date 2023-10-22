package exam.exma08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageDialog extends JFrame {
    private JDialog dialog;

    public MessageDialog(Frame parent) {
        super();

        dialog = new JDialog(this, "설정 오류", Dialog.ModalityType.DOCUMENT_MODAL);

        dialog.setSize(200, 150);
        dialog.setLocation( (int)(parent.getLocation().getX() + (parent.getSize().width - dialog.getSize().width) / 2), (int)(parent.getLocation().getY() + (parent.getSize().height / 2 - dialog.getSize().height) / 2));

        dialog.setResizable(false);
        dialog.setModal(true);

        Container cp = dialog.getContentPane();

        cp.setLayout(new BorderLayout());

        cp.add(new JLabel("허용 값의 범위를 벗어났습니다.", JLabel.CENTER), BorderLayout.PAGE_START);
        cp.add(new JLabel("[0 ~ 100]", JLabel.CENTER), BorderLayout.CENTER);
        JButton button = new JButton("확인");
        cp.add(button, BorderLayout.PAGE_END);

        button.addActionListener(e -> {
            this.setVisible(false);
        });
    }

    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }

}
