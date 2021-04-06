    private void deleteEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ehdokas_id = Integer.parseInt(request.getParameter("ehdokas_id"));
 
        Ehdokkaat ehdokkaat = new Ehdokkaat(ehdokas_id);
        electionDAO.deleteEhdokkaat(ehdokkaat);
        response.sendRedirect("list");
 
    }
