package net.codejava.javaee.electionmachine;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class electionDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ElectionDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertEhdokkaat(Ehdokkaat ehdokkaat) throws SQLException {
        String sql = "INSERT INTO ehdokkaat (sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, ehdokkaat.getSukunimi());
        statement.setString(2, ehdokkaat.getEtunimi());
        statement.setFloat(3, ehdokkaat.getPuolue());
        statement.setFloat(4, ehdokkaat.getKotipaikkakunta());
        statement.setFloat(5, ehdokkaat.getIka());
        statement.setFloat(6, ehdokkaat.getMiksi_eduskuntaan());
        statement.setFloat(7, ehdokkaat.getMita_asioita_haluat_edistaa());
        statement.setFloat(8, ehdokkaat.getAmmatti());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Ehdokkaat> listAllEhdokkaat() throws SQLException {
        List<Ehdokkaat> listEhdokkaat = new ArrayList<>();
         
        String sql = "SELECT * FROM ehdokkaat";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int ehdokas_id = resultSet.getInt("ehdokas_id");
            String sukunimi = resultSet.getString("sukunimi");
            String etunimi = resultSet.getString("etunimi");
            String puolue = resultSet.getString("puolue");
            String kotipaikkakunta = resultSet.getInt("kotipaikkakunta");
            int ika = resultSet.getInt("ika");
            String miksi_eduskuntaan = resultSet.getString("miksi_eduskuntaan");
            String mita_asioita_haluat_edistaa = resultSet.getString("mita_asioita_haluat_edistaa");
            String ammatti = resultSet.getString("ammatti");
             
            Ehdokkaat ehdokkaat = new Ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
            listEhdokkaat.add(ehdokkaat);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listEhdokkaat;
    }
     
    public boolean deleteEhdokkaat(Ehdokkaat ehdokkaat) throws SQLException {
        String sql = "DELETE FROM ehdokkaat where ehdokas_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, ehdokkaat.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateEhdokkaat(Ehdokkaat ehdokkaat) throws SQLException {
        String sql = "UPDATE ehdokkaat SET sukunimi = ?, etunimi = ?, puolue = ? kotipaikkakunta = ?, ika = ?, miksi_eduskuntaan = ?, mita_asioita_haluat_edistaa = ?, ammatti = ?";
        sql += " WHERE ehdokas_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, ehdokkaat.getSukunimi());
        statement.setString(2, ehdokkaat.getEtunimi());
        statement.setString(3, ehdokkaat.getPuolue());
        statement.setString(4, ehdokkaat.getKotipaikkakunta());
        statement.setInt(5, ehdokkaat.getIka());
        statement.setString(6, ehdokkaat.getMiksi_eduskuntaan());
        statement.setString(7, ehdokkaat.getMita_asioita_haluat_edistaa());
        statement.setString(8, ehdokkaat.getAmmatti());
        statement.setInt(9, ehdokkaat.getehdokas_id());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Ehdokkaat getEhdokkaat(int ehdokas_id) throws SQLException {
        Ehdokkaat ehdokkaat = null;
        String sql = "SELECT * FROM ehdokkaat WHERE ehdokas_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, ehdokas_id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            int ehdokas_id = resultSet.getInt("ehdokas_id");
            String sukunimi = resultSet.getString("sukunimi");
            String etunimi = resultSet.getString("etunimi");
            String puolue = resultSet.getString("puolue");
            String kotipaikkakunta = resultSet.getInt("kotipaikkakunta");
            int ika = resultSet.getInt("ika");
            String miksi_eduskuntaan = resultSet.getString("miksi_eduskuntaan");
            String mita_asioita_haluat_edistaa = resultSet.getString("mita_asioita_haluat_edistaa");
            String ammatti = resultSet.getString("ammatti");
             
            ehdokkaat = new Ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
        }
         
        resultSet.close();
        statement.close();
         
        return ehdokkaat;
    }
}