import java.sql.*;

public class DB {

    private Connection conn;


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