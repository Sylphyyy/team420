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
    statement.setInt(9, ehdokkaat.getEhdokas_id());
     
    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;     
}


// servlet part 
private void updateEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ehdokas_id; = Integer.parseInt(request.getParameter("ehdokas_id"));
        String sukunimi = request.getParameter("sukunimi");
        String etunimi = request.getParameter("etunimi");
        String puolue = request.getParameter("puolue");
        String kotipaikkakunta = request.getParameter("kotipaikkakunta");
        int ika; = Integer.parseInt(request.getParameter("ika"));
        String miksi_eduskuntaan = request.getParameter("miksi_eduskuntaan");
        String mita_asioita_haluat_edistaa = request.getParameter("mita_asioita_haluat_edistaa");
        String ammatti = request.getParameter("ammatti");
 
        Ehdokkaat ehdokkaat = new ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
        ehdokkaatDAO.updateEhdokkaat(ehdokkaat);
        response.sendRedirect("list");
}