package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public final class ProjectController {

    public final void save(Project project) {
        final String sql = "INSERT INTO projects(name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Cria uma conex�o com o banco
            connection = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));

            //Executa a sql para inser��o dos dados
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Error saving project in database ", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public final void update(Project project) {

        final String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Cria uma conex�o com o banco
            connection = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());

            //Executa a sql para inser��o dos dados
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Error updating project in database ", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public final List<Project> getAll() {
        final String sql = "SELECT * FROM projects";

        final List<Project> projects = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            //Enquanto existir dados no banco de dados, fa�a
            while (resultSet.next()) {

                final Project project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setCreatedAt(resultSet.getDate("updatedAt"));

                projects.add(project);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error searching all projects in database ", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return projects;
    }

    public final void removeById(int idProject) {

        final String sql = "DELETE FROM projects WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(sql);

            statement.setInt(1, idProject);

            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Error deleting project in database ", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
