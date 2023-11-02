package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.User;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOJdbc implements UserDAO {
  private PsqlConnector psqlConnector;
  private Logger logger;

  @Autowired
  public UserDAOJdbc(PsqlConnector psqlConnector, Logger logger) {
    this.psqlConnector = psqlConnector;
    this.logger = logger;
  }

  @Override
  public List<User> getAll() {
    List<User> users = new ArrayList<>();

    String sql =
      """
        SELECT
          *
        FROM
          users;
      """;

    try (
      Connection conn = psqlConnector.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery(sql)) {

      while (rs.next()) {
        int id = rs.getInt(1);
        String userName = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);

        users.add(new User(id, userName, password, email));
      }
    } catch (SQLException exception) {
      logger.logError(exception.getMessage());
    }


    return users;
  }
}
