package view;

import controller.ProjectController;
import controller.TaskController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Project;
import model.Task;
import util.ButtonColumnCellRederer;
import util.StatusDeadlineColumnCellRenderer;
import util.TaskTableModel;

public final class MainScreen extends javax.swing.JFrame {

    private ProjectController projectController;
    private TaskController taskController;

    private DefaultListModel projectsModel;
    private TaskTableModel taskModel;

    public MainScreen() {
        // A ordem de chamada das funções aqui importa pq decorateTableTask esta mudando a cor da segunda coluna da tabela
        initComponents();
        initDataController();
        initComponetsModel();
        decorateTableTask();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEmptyList = new javax.swing.JPanel();
        jLabelEmptyListIcon = new javax.swing.JLabel();
        jLabelEmptyListTitle = new javax.swing.JLabel();
        jLabelEmptyListSubTitle = new javax.swing.JLabel();
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        jLabelToolBarSubTitle = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsAdd = new javax.swing.JLabel();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jLabelTasksAdd = new javax.swing.JLabel();
        jPanelProjectsList = new javax.swing.JPanel();
        jScrollPaneProjects = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTask = new javax.swing.JTable();

        jPanelEmptyList.setBackground(java.awt.Color.white);

        jLabelEmptyListIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list/xxhdpi-lists.png"))); // NOI18N

        jLabelEmptyListTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelEmptyListTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelEmptyListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListTitle.setText("No task registered");

        jLabelEmptyListSubTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmptyListSubTitle.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEmptyListSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListSubTitle.setText("Click \"+\" button to add new task");

        javax.swing.GroupLayout jPanelEmptyListLayout = new javax.swing.GroupLayout(jPanelEmptyList);
        jPanelEmptyList.setLayout(jPanelEmptyListLayout);
        jPanelEmptyListLayout.setHorizontalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmptyListLayout.createSequentialGroup()
                .addGroup(jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelEmptyListSubTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmptyListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmptyListIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEmptyListLayout.setVerticalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabelEmptyListIcon)
                .addGap(18, 18, 18)
                .addComponent(jLabelEmptyListTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelEmptyListSubTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 800));

        jPanelToolBar.setBackground(new java.awt.Color(0, 153, 102));

        jLabelToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick/tick (3).png"))); // NOI18N
        jLabelToolBarTitle.setText(" Task app");

        jLabelToolBarSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelToolBarSubTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarSubTitle.setText("Never forget your appointments again");

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelToolBarSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelToolBarTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelToolBarSubTitle)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelProjects.setBackground(java.awt.Color.white);
        jPanelProjects.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelProjectsTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelProjectsTitle.setText("Projects");

        jLabelProjectsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add/add (5).png"))); // NOI18N
        jLabelProjectsAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelProjectsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jLabelProjectsAdd)
                .addContainerGap())
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelProjectsAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelTasks.setBackground(java.awt.Color.white);
        jPanelTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelTasksTitle.setText("Tasks");

        jLabelTasksAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add/add (5).png"))); // NOI18N
        jLabelTasksAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelTasksAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTasksAdd)
                .addContainerGap())
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTasksAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelProjectsList.setBackground(java.awt.Color.white);
        jPanelProjectsList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListProjects.setBackground(java.awt.Color.white);
        jListProjects.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jListProjects.setForeground(java.awt.Color.black);
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setFixedCellHeight(50);
        jListProjects.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
        });
        jScrollPaneProjects.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectsListLayout = new javax.swing.GroupLayout(jPanelProjectsList);
        jPanelProjectsList.setLayout(jPanelProjectsListLayout);
        jPanelProjectsListLayout.setHorizontalGroup(
            jPanelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelProjectsListLayout.setVerticalGroup(
            jPanelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
        );

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTableTask.setBackground(java.awt.Color.white);
        jTableTask.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableTask.setForeground(java.awt.Color.black);
        jTableTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Description", "Deadline", "Task completed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTask.setGridColor(java.awt.Color.white);
        jTableTask.setRowHeight(50);
        jTableTask.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jTableTask.setSelectionForeground(java.awt.Color.black);
        jTableTask.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTask.setShowHorizontalLines(true);
        jTableTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTaskMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTask);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProjectsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectsAddMouseClicked
        // Cria um objeto do tipo ProjectDialogScreen e faz ele aparecer na tela quando clica no botão de + do projects       
        final ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen(this, rootPaneCheckingEnabled);
        projectDialogScreen.setVisible(true);

        // Atualiza a lista de projetos quando a janela de cadastrar novo projeto é fechada
        projectDialogScreen.addWindowListener(new WindowAdapter() {
            @Override
            public final void windowClosed(WindowEvent e) {
                loadProjects();
            }
        });
    }//GEN-LAST:event_jLabelProjectsAddMouseClicked

    private void jLabelTasksAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTasksAddMouseClicked
        // TODO add your handling code here:
        final TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, rootPaneCheckingEnabled);
        final int projectIndex = jListProjects.getSelectedIndex();
        final Project Project = (Project) projectsModel.get(projectIndex);

        taskDialogScreen.setProject(Project);

        taskDialogScreen.setVisible(true);

        // Atualiza a lista de projetos quando a janela de cadastrar novo projeto é fechada
        taskDialogScreen.addWindowListener(new WindowAdapter() {
            @Override
            public final void windowClosed(WindowEvent e) {
                final int projectIndex = jListProjects.getSelectedIndex();
                Project project = (Project) projectsModel.get(projectIndex);
                loadTasks(project.getId());
            }
        });
    }//GEN-LAST:event_jLabelTasksAddMouseClicked

    private void jTableTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTaskMouseClicked
        // TODO add your handling code here:
        final int rowIndex = jTableTask.rowAtPoint(evt.getPoint());
        final int columnIndex = jTableTask.columnAtPoint(evt.getPoint());
        final Task task = taskModel.getTasks().get(rowIndex);

        switch (columnIndex) {
            case 3:
                taskController.update(task);
                break;
            case 4:
                break;
            case 5:
                taskController.removeById(task.getId());
                taskModel.getTasks().remove(task);
                final int projectIndex = jListProjects.getSelectedIndex();
                Project project = (Project) projectsModel.get(projectIndex);
                loadTasks(project.getId());
                break;
        }
    }//GEN-LAST:event_jTableTaskMouseClicked

    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseClicked
        // TODO add your handling code here:
        int projectIndex = jListProjects.getSelectedIndex();
        final Project project = (Project) projectsModel.get(projectIndex);
        loadTasks(project.getId());
    }//GEN-LAST:event_jListProjectsMouseClicked

    public final static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public final void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEmptyListIcon;
    private javax.swing.JLabel jLabelEmptyListSubTitle;
    private javax.swing.JLabel jLabelEmptyListTitle;
    private javax.swing.JLabel jLabelProjectsAdd;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTasksAdd;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JLabel jLabelToolBarSubTitle;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelEmptyList;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelProjectsList;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneProjects;
    private javax.swing.JTable jTableTask;
    // End of variables declaration//GEN-END:variables

    private void initDataController() {
        projectController = new ProjectController();
        taskController = new TaskController();
    }

    private void initComponetsModel() {
        projectsModel = new DefaultListModel<>();
        taskModel = new TaskTableModel();
        loadProjects();
        jTableTask.setModel(taskModel);

        if (!projectsModel.isEmpty()) {
            jListProjects.setSelectedIndex(0);
            final int projectIndex = jListProjects.getSelectedIndex();
            final Project project = (Project) projectsModel.get(projectIndex);
            loadTasks(project.getId());
        }
    }

    private void decorateTableTask() {

        // Customizando header da table de tarefas
        jTableTask.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTableTask.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTask.getTableHeader().setForeground(new Color(255, 255, 255));

        // Personalizando a segunda coluna da table com a minha class de customiza��o 
        jTableTask.getColumnModel().getColumn(2).setCellRenderer(new StatusDeadlineColumnCellRenderer());

        // Personalizando a coluna 4 e 5 da table com minha class de customiza��o 
        jTableTask.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnCellRederer("edit"));
        jTableTask.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnCellRederer("delete"));

        // Permite clicar nos cabeçalhos da tabela e ordenar automaticamente os dados
        jTableTask.setAutoCreateRowSorter(true);
    }

    private void loadTasks(int idProject) {
        final List<Task> tasks = taskController.getByProjectId(idProject);
        taskModel.setTasks(tasks);
        showJTableTasks(!tasks.isEmpty());
    }

    private void loadProjects() {
        final List<Project> projects = projectController.getAll();
        projectsModel.clear();

        for (Project project : projects) {
            projectsModel.addElement(project);
        }
        jListProjects.setModel(projectsModel);
    }

    private void showJTableTasks(boolean isEmptyTable) {
        if (isEmptyTable) {
            // Existem tarefas
            if (jPanelEmptyList.isVisible()) {
                jPanelEmptyList.setVisible(false);
                jPanel5.remove(jPanelEmptyList);
            }

            jPanel5.add(jScrollPane1);
            jScrollPane1.setVisible(true);
            jScrollPane1.setSize(jPanel5.getWidth(), jPanel5.getHeight());
        } else {
            if (jScrollPane1.isVisible()) {
                jScrollPane1.setVisible(false);
                jPanel5.remove(jScrollPane1);
            }

            jPanel5.add(jPanelEmptyList);
            jPanelEmptyList.setVisible(true);
            jPanelEmptyList.setSize(jPanel5.getWidth(), jPanel5.getHeight());
        }
    }

}
