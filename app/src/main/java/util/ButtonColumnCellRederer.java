package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public final class ButtonColumnCellRederer extends DefaultTableCellRenderer {

    private final String buttonType;

    public ButtonColumnCellRederer(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        //Cells are by default rendered as a JLabel.
        final JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/" + buttonType + "/" + buttonType + " (4).png")));

        //Return the JLabel which renders the cell.
        return label;
    }
}
