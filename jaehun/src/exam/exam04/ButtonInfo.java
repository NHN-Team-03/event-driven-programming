package exam.exam04;

import java.awt.event.ActionListener;

public class ButtonInfo {
    private String title;
    private int gridx;
    private int gridy;
    private int gridWidth;
    private ActionListener acitonListener;

    public ButtonInfo(String title, int gridx, int gridy, int gridWidth) {
        this.title = title;
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridWidth = gridWidth;
    }

    public ButtonInfo(String title, int gridx, int gridy, int gridWidth, ActionListener acitonListener) {
        this(title, gridx, gridy, gridWidth);
        this.acitonListener = acitonListener;
    }

    public String getTitle() {
        return title;
    }

    public int getGridx() {
        return gridx;
    }

    public int getGridy() {
        return gridy;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public ActionListener getAcitonListener() {
        return acitonListener;
    }
}
