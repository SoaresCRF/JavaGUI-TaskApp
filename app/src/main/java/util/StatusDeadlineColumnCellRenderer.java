package util;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.Task;

public final class StatusDeadlineColumnCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        //Cells are by default rendered as a JLabel.
        final JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        label.setHorizontalAlignment(JLabel.CENTER);

        //Get the status for the current row.
        final TaskTableModel taskModel = (TaskTableModel) table.getModel();
        final Task task = taskModel.getTasks().get(row);

        if (deadlineDateHasPassed(task) < 0) {
            label.setBackground(Color.RED);
        } else if (deadlineDateHasPassed(task) == 0) {
            label.setBackground(Color.YELLOW);
        } else {
            label.setBackground(Color.GREEN);
        }

        //Return the JLabel which renders the cell.
        return label;
    }

    private int deadlineDateHasPassed(Task task) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        final Calendar today = Calendar.getInstance();
        final Calendar deadline = Calendar.getInstance();

        try {
            deadline.setTime(dateFormat.parse(dateFormat.format(task.getDeadline().getTime())));
            today.setTime(dateFormat.parse(dateFormat.format(today.getTime())));
        } catch (ParseException e) {
            throw new RuntimeException("Error converting date ", e);
        }

        return deadline.compareTo(today);
    }
}
