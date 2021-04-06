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