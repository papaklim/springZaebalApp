package ru.aklementev.springzaebalapp.repository;

import ru.aklementev.springzaebalapp.db.ZaebatorJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    Connection connection = ZaebatorJDBC.getConnection();

    public TableCreator() throws SQLException {
    }

    public void createTable(String sql, String description) throws SQLException{
        executeSqlStatement(sql, description);
    }

    public void executeSqlStatement(String sql, String description) throws SQLException {
        Statement statement = connection.createStatement();  // Создаем statement для выполнения sql-команд
        statement.execute(sql); // Выполняем statement - sql команду
        statement.close();      // Закрываем statement для фиксации изменений в СУБД
        if (description != null)
            System.out.println(description);
    }

    public void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }

}
