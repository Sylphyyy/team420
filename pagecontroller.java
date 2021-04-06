package net.codejava.javaee.electionmachine;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ElectionDAO electionDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        electionDAO = new ElectionDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertEhdokkaat(request, response);
                break;
            case "/delete":
                deleteEhdokkaat(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateEhdokkaat(request, response);
                break;
            default:
                listEhdokkaat(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Ehdokkaat> listEhdokkaat = electionDAO.listAllEhdokkaat();
        request.setAttribute("listEhdokkaat", listEhdokkaat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("candidateList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("candidateForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ehdokas_id"));
        Ehdokkaat existingEhdokkaat = electionDAO.getEhdokkaat(ehdokas_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("candidateForm.jsp");
        request.setAttribute("ehdokkaat", existingEhdokkaat);
        dispatcher.forward(request, response);
 
    }
 
    private void insertEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String sukunimi = request.getParameter("sukunimi");
        String etunimi = request.getParameter("etunimi");
        float puolue = Float.parseFloat(request.getParameter("puolue"));
 
        Ehdokkaat newEhdokkaat = new Ehdokkaat(sukunimi, etunimi, puolue);
        electionDAO.insertEhdokkaat(newEhdokkaat);
        response.sendRedirect("list");
    }
 
    private void updateEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ehdokas_id = Integer.parseInt(request.getParameter("ehdokas_id"));
        String sukunimi = request.getParameter("sukunimi");
        String etunimi = request.getParameter("etunimi");
        String puolue = request.getParameter("puolue");
        String kotipaikkakunta = request.getParameter("kotipaikkakunta");
        int ika = int.parseInt(request.getParameter("ika"));
        String miksi_eduskuntaan = request.getParameter("miksi_eduskuntaan");
        String mita_asioita_haluat_edistaa = request.getParameter("mita_asioita_haluat_edistaa");
        String ammatti = request.getParameter("ammatti");
 
        Ehdokkaat ehdokkaat = new Ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
        electionDAO.updateEhdokkaat(ehdokkaat);
        response.sendRedirect("list");
    }
 
    private void deleteEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ehdokas_id = Integer.parseInt(request.getParameter("ehdokas_id"));
 
        Ehdokkaat ehdokkaat = new Ehdokkaat(ehdokas_id);
        electionDAO.deleteEhdokkaat(ehdokkaat);
        response.sendRedirect("list");
 
    }
}