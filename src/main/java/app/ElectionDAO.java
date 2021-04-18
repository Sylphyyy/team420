package app;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class ElectionDAO {
   
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
// Declare variables to connect to DB 
public ElectionDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     // The connect() method of Java Socket class connects the specified socket to the server.
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
     // This method is used to disconnect the server.
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     // Inserts candidate into Ehdokkaat table
    public boolean insertEhdokkaat(Ehdokkaat ehdokkaat) throws SQLException {
        String sql = "INSERT INTO ehdokkaat (sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     // Lists all candidates
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
            String kotipaikkakunta = resultSet.getString("kotipaikkakunta");
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
     // Deletes candidate from table
    public boolean deleteEhdokkaat(Ehdokkaat ehdokkaat) throws SQLException {
        String sql = "DELETE FROM ehdokkaat where ehdokas_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, ehdokkaat.getEhdokas_id());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     // Updates candidate
    public boolean updateEhdokkaat(Ehdokkaat ehdokkaat) throws SQLException {
        String sql = "UPDATE ehdokkaat SET sukunimi = ?, etunimi = ?, puolue = ?, kotipaikkakunta = ?, ika = ?, miksi_eduskuntaan = ?, mita_asioita_haluat_edistaa = ?, ammatti = ?";
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
        statement.setInt(9, ehdokkaat.getEhdokas_id());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     // Gets info from Ehdokkaat table and shows it
    public Ehdokkaat getEhdokkaat(int ehdokas_id) throws SQLException {
        Ehdokkaat ehdokkaat = null;
        String sql = "SELECT * FROM ehdokkaat WHERE ehdokas_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, ehdokas_id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String sukunimi = resultSet.getString("sukunimi");
            String etunimi = resultSet.getString("etunimi");
            String puolue = resultSet.getString("puolue");
            String kotipaikkakunta = resultSet.getString("kotipaikkakunta");
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
    // Insert new question
    public boolean insertKysymykset(Kysymykset kysymykset) throws SQLException {
        String sql = "INSERT INTO kysymykset (KYSYMYS_ID, KYSYMYS) VALUES (?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, kysymykset.getKysymys_id());
        statement.setString(2, kysymykset.getKysymys());

         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     // Shows all questions
   public List<Kysymykset> listAllKysymykset() throws SQLException {
      List<Kysymykset> listKysymykset = new ArrayList<>();
       
     String sql = "SELECT * FROM kysymykset";
      
    connect();
       
    Statement statement = jdbcConnection.createStatement();
     ResultSet resultSet = statement.executeQuery(sql);
       
      while (resultSet.next()) {
          int kysymys_id = resultSet.getInt("kysymys_id");
          String kysymys = resultSet.getString("kysymys");

           Kysymykset kysymykset = new Kysymykset(kysymys_id, kysymys);
          listKysymykset.add(kysymykset);
      }
        
      resultSet.close();
      statement.close();
        
      disconnect();
       
      return listKysymykset;
  }
   
   // Delete question
    public boolean deleteKysymykset(Kysymykset kysymykset) throws SQLException {
        String sql = "DELETE FROM kysymykset where KYSYMYS_ID = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, kysymykset.getKysymys_id());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    
    // Update question
    public boolean updateKysymykset(Kysymykset kysymykset) throws SQLException {
        String sql = "UPDATE kysymykset SET kysymys_id = ?, kysymys = ?";
        sql += " WHERE KYSYMYS_ID = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setInt(1, kysymykset.getKysymys_id());
        statement.setString(2, kysymykset.getKysymys());
 
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    // Shows all questions
	public Kysymykset getKysymykset(int kysymys_id)
		throws SQLException {
	        Kysymykset kysymykset = null;
	        int number = 1;
	        String sql = "SELECT * FROM kysymykset WHERE kysymys_id = "+number;;
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, kysymys_id);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {

	            String kysymys = resultSet.getString("kysymys");

	             
	            kysymykset = new Kysymykset(kysymys_id, kysymys);
	        }
	      
	         
	        resultSet.close();
	        statement.close();
	         
	        return kysymykset;
	}



}