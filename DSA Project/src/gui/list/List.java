package src.gui.list;

import javax.swing.*;

public class List extends JScrollPane {
    private final JPanel panel = new JPanel();

    public List() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setViewportView(panel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public void add(JComponent item) {
        panel.add(item);
    }

    public void remove(JComponent item) {
        panel.remove(item);
    }

    public void clear() {
        panel.removeAll();
    }
}
