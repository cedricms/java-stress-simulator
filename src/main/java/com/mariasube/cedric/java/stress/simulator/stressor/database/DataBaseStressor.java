package com.mariasube.cedric.java.stress.simulator.stressor.database;

import com.mariasube.cedric.java.stress.simulator.stressor.AbstractStressor;
import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.*;

@Slf4j
public class DataBaseStressor extends AbstractStressor {

    private static final int MAX_REQUESTS = 10 * 1000 * 1000;

    private static final int MAX_ACCOUNTS = 50;

    private static final String DATABASE = "JavaStressSimulatorDatabase";
    private static final String USER = "stressedOutUser";
    private static final String PASSWORD = "totallySecuredPasswordOrNot";

    @Override
    public void stress() {
        JdbcDatabaseContainer jdbcDatabaseContainer = createJdbcDatabaseContainer();

        if (jdbcDatabaseContainer != null) {
            Connection connection = null;
            try {
                connection = createDatabaseConnection(jdbcDatabaseContainer);
            } catch (SQLException sqle) {
                log.error("Unable to create a database connection.", sqle);
            }

            setupDatabaseStructure(connection);

            stressTheDatabase(connection);

            if (connection != null) {
                try {
                    connection.close();

                    jdbcDatabaseContainer.stop();
                } catch (SQLException sqle) {
                    log.error("Unable to close the database connection.", sqle);
                }
            } else {
                log.info("No database to close.");
            }
        } else {
            log.error("Unable to create a database container.");
        }
    }

    private void stressTheDatabase(Connection connection) {
        for (int i = 0; i < MAX_REQUESTS; i++) {
            int scenario = (int) (2 * Math.random());
            switch (scenario) {
                case 0:
                    stressListAccounts(connection);
                    break;
                default:
                    stressFindAccount(connection);
            }
        }
    }

    private void stressFindAccount(Connection connection) {
        PreparedStatement accountStatement = null;
        try {
            accountStatement = connection.prepareStatement("SELECT id, firstname, lastname FROM account WHERE id = ?");
        } catch (SQLException sqle) {
            log.error("Unable to create a statement to find an account.", sqle);
        }

        if (accountStatement != null) {
            ResultSet resultSet = null;
            try {
                int randomId = (int) (MAX_ACCOUNTS * Math.random()) + 1;
                accountStatement.setInt(1, randomId);

                resultSet = accountStatement.executeQuery();
            } catch (SQLException sqle) {
                log.error("Unable to execute account request.", sqle);
            }

            readAccount(resultSet);
        }

        try {
            accountStatement.close();
        } catch (SQLException sqle) {
            log.error("Unable to close the statement that finds an account.", sqle);
        }
    }

    private void readAccount(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);

                log.info("Account : id = " + id + ", firstname = " + firstname + ", lastname = " + lastname);
            }
        } catch (SQLException sqle) {
            log.error("Unable to get account information.", sqle);
        }
    }

    private void stressListAccounts(Connection connection) {
        Statement listAccountsStatement = null;
        try {
            listAccountsStatement = connection.createStatement();
        } catch (SQLException sqle) {
            log.error("Unable to create a statement to list accounts.", sqle);
        }

        if (listAccountsStatement != null) {
            ResultSet resultSet = null;
            try {
                resultSet = listAccountsStatement.executeQuery("SELECT id, firstname, lastname FROM account");
            } catch (SQLException sqle) {
                log.error("Unable to execute account request.", sqle);
            }

            readAccount(resultSet);
        }

        try {
            listAccountsStatement.close();
        } catch (SQLException sqle) {
            log.error("Unable to close the statement that lists accounts.", sqle);
        }
    }

    private void setupDatabaseStructure(Connection connection) {
        createUserStructure(connection);
        insertUserData(connection);
    }

    private void insertUserData(Connection connection) {
        PreparedStatement insertUser = null;
        try {
            insertUser = connection.prepareStatement("INSERT INTO account (id, firstname, lastname)" +
                " VALUES (?, ?, ?)");
        } catch (SQLException sqle) {
            log.error("Unable to create user insert statement.", sqle);
        }

        if (insertUser != null) {
            for (int i = 1; i <= MAX_ACCOUNTS; i++) {
                try {
                    insertUser.setInt(1, i);
                    insertUser.setString(2, "firstname_" + i);
                    insertUser.setString(3, "lastname_" + i);

                    insertUser.executeUpdate();
                } catch (SQLException sqle) {
                    log.error("Unable to insert user.", sqle);
                }
            }

            try {
                connection.commit();

                insertUser.close();
            } catch (SQLException sqle) {
                log.error("Unable to commit user inserts.", sqle);
            }
        }
    }

    private void createUserStructure(Connection connection) {
        Statement createUser = null;
        try {
            createUser = connection.createStatement();
        } catch (SQLException sqle) {
            log.error("Unable to create user statement.", sqle);
        }

        if (createUser != null) {
            try {
                createUser.executeUpdate("CREATE TABLE account (id serial PRIMARY KEY, firstname VARCHAR (50) NOT NULL, lastname VARCHAR (50) NOT NULL)");

                createUser.close();
            } catch (SQLException sqle) {
                log.error("Unable to execute table user creation statement.", sqle);
            }
        }
    }

    private JdbcDatabaseContainer createJdbcDatabaseContainer() {
        JdbcDatabaseContainer jdbcDatabaseContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName(DATABASE)
            .withUsername(USER)
            .withPassword(PASSWORD);
        jdbcDatabaseContainer.start();

        return jdbcDatabaseContainer;
    }

    private Connection createDatabaseConnection(JdbcDatabaseContainer jdbcDatabaseContainer) throws SQLException {
        String jdbcUrl = jdbcDatabaseContainer.getJdbcUrl();
        String username = jdbcDatabaseContainer.getUsername();
        String password = jdbcDatabaseContainer.getPassword();

        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
