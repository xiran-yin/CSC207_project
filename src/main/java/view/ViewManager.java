package view;

import javax.swing.*;

public class ViewManager {

    private JFrame mainFrame;

    public ViewManager(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void showView(JPanel view) {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(view);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
