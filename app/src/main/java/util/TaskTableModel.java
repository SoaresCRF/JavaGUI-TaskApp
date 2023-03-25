package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

public final class TaskTableModel extends AbstractTableModel {

    private final String[] columns = {"Name", "Description", "Deadline", "Task completed", "Edit", "Delete"};
    private List<Task> tasks = new ArrayList<>();

    // Quantas linhas vai ter na tabela
    @Override
    public final int getRowCount() {
        return tasks.size();
    }

    // Quantas colunas vai ter na tabela
    @Override
    public final int getColumnCount() {
        return columns.length;
    }

    @Override
    public final Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();

            case 1:
                return tasks.get(rowIndex).getDescription();

            case 2:
                final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());

            case 3:
                return tasks.get(rowIndex).isIsCompleted();

            case 4:
                return "";

            case 5:
                return "";

            default:
                return "Data not found";
        }
    }

    @Override
    public final boolean isCellEditable(int rowIndex, int colmnIndex) {
        return colmnIndex == 3;
    }

    @Override
    public final Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public final void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);
    }

    @Override
    public final String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    public final String[] getColumns() {
        return columns;
    }

    public final List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
