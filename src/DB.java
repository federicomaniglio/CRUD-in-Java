import java.sql.*;

public class DB {

    /**
     * Represents a connection to a database.
     *
     * The conn variable is used to establish a connection to a database and execute SQL queries.
     *
     * Methods in the DB class utilize the conn variable to execute queries such as SELECT, INSERT, UPDATE, and DELETE.
     *
     * This variable should be initialized with a valid Connection object before using any of the database-related methods.
     */
    private Connection conn;


    /**
     * Represents a connection to a database.
     */
    public DB(String address, String port, String databaseName, String username, String password) {
        //stringa di connessione -> jdbc:mysql://127.0.0.1:3306/nomeDB
        String dbConnectionString = "jdbc:mysql://" + address + ":" + port + "/" + databaseName;
        try {
            conn = DriverManager.getConnection(dbConnectionString, username, password);
            if (conn != null)
                System.out.println("connessione avvenuta");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * Executes a SELECT query on the database.
     *
     * @param what   the column(s) to select
     * @param from   the table(s) to select from
     * @param where  the condition to filter the result
     * @param is     the value to compare in the WHERE clause
     * @return a string representation of the selected data, formatted as tab-separated values
     * @throws SQLException if an SQL exception occurs while executing the query
     */
    public String select(String what, String from, String where, String is) {
        String result = "";
        try {
            if (!conn.isValid(5)) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        String query = "SELECT " + what + " FROM " + from + " WHERE " + where + " = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, is);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    result += rs.getString(i) + "\t";
                    if (rs.getString(i).length() < 8) result += "\t";
                }
                result += "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    /**
     * Executes a SELECT query on the database to retrieve all records from a specified table.
     *
     * @param from the name of the table to select from
     * @return a string representation of the selected data, formatted as tab-separated values
     * @throws SQLException if an SQL exception occurs while executing the query
     */
    public String selectALL(String from) {
        String result = "";
        try {
            if (!conn.isValid(5)) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM " + from;

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    result += rs.getString(i) + "\t";
                    //if the record is too short this if add a new tabulation
                    if (rs.getString(i).length() < 8) result += "\t";
                }
                result += "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    /**
     * Inserts a new record into the "persone" table in the database.
     *
     * @param nome    the name of the person
     * @param cognome the surname of the person
     * @param eta     the age of the person
     * @param sesso   the gender of the person
     * @return true if the insert operation was successful, false otherwise
     */
    public boolean insertIntoPersone(String nome, String cognome, int eta, String sesso) {
        try {
            if (!conn.isValid(5)) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        String query = "INSERT INTO persone (nome, cognome, eta, sesso) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nome);
            statement.setString(2, cognome);
            statement.setInt(3, eta);
            statement.setString(4, sesso);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Deletes a record from the "persone" table in the database by name.
     *
     * @param nome the name of the record to delete
     * @return true if the record is successfully deleted, false otherwise
     */
    public boolean deleteIntoPersoneByName(String nome) {
        try {
            if (!conn.isValid(5)) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        String query = "DELETE FROM persone WHERE Nome = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nome);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Updates a record in the "persone" table in the database with the specified ID.
     *
     * @param id      the ID of the record to update
     * @param nome    the new value for the "nome" column
     * @param cognome the new value for the "cognome" column
     * @param eta     the new value for the "eta" column
     * @param sesso   the new value for the "sesso" column
     * @return true if the record is successfully updated, false otherwise
     */
    public boolean updateIntoPersonabyID(int id, String nome, String cognome, Integer eta, String sesso) {
        try {
            if (!conn.isValid(5)) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        String query = "UPDATE persone SET nome = ?, Cognome = ?, eta = ?, Sesso = ? WHERE ID = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nome);
            statement.setString(2, cognome);
            statement.setInt(3, eta);
            statement.setString(4, sesso);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}