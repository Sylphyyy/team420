import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.Ehdokkaat;
import app.ElectionDAO;
 import app.Kysymykset;

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private ElectionDAO electionDAO;
 
	
//  Gets all necessary information to authorize in MySQL
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        electionDAO = new ElectionDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
//  Called by the server (via the service method)to allow a servlet to handle a POST request.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
//  Called by the server (via the service method) to allow a servlet to handle a GET request.
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
            	// Shows new form to user
                showNewForm(request, response);
                break;
            case "/insert":
            	// Inserts new candidate
                insertEhdokkaat(request, response);
                break;
            case "/delete":
            	// Delete a candidate
                deleteEhdokkaat(request, response);
                break;
            case "/edit":
            	// Edit record in form
                showEditForm(request, response);
                break;
            case "/update":
            	// Updates candidate info
                updateEhdokkaat(request, response);
                break;
            case "/list":
            	// Lists candidates
                listEhdokkaat(request, response);      
                break;
            case "/lista":
            	listKysymykset(request, response);
            	insertKysymykset(request, response);
            	break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    
/** 
 * Extends the javax.servlet.ServletRequest interface to provide request information for HTTP servlets. 
 * The servlet container creates an HttpServletRequest object and passes it as an argument to the servlet's servicemethods (doGet, doPost, etc).
 */
    
    @SuppressWarnings("unused")
    // This method inserts the data into a substring of this StringBuffer.
	private void insertKysymykset(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String kysymys = request.getParameter("kysymys");
        
        int kysymys_id = 0;
        		
      try {
    	  Integer.parseInt(request.getParameter("kysymys_id"));
      }
      catch (Exception ex) { 
      }
       Kysymykset newKysymykset = new Kysymykset(kysymys_id, kysymys);
        electionDAO.insertKysymykset(newKysymykset);
        response.sendRedirect("lista");
    }
    // Java List is an interface that extends Collection interface. Java List provides control over the position where you can insert an element. You can access elements by their index and also search elements in the list.
	private void listKysymykset(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Kysymykset> listKysymykset = electionDAO.listAllKysymykset();
        request.setAttribute("listKysymykset", listKysymykset);
        RequestDispatcher dispatcher = request.getRequestDispatcher("questionsList.jsp");
        dispatcher.forward(request, response);
    }

	// Java List is an interface that extends Collection interface. Java List provides control over the position where you can insert an element. You can access elements by their index and also search elements in the list.
	private void listEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Ehdokkaat> listEhdokkaat = electionDAO.listAllEhdokkaat();
        request.setAttribute("listEhdokkaat", listEhdokkaat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("candidateList.jsp");
        dispatcher.forward(request, response);
    }
	
	// Shows a form where user can add new candidates
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("candidateForm.jsp");
        dispatcher.forward(request, response);
    }
 
    // Shows a form where user can edit candidates
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int ehdokas_id = Integer.parseInt(request.getParameter("ehdokas_id"));
        Ehdokkaat existingEhdokkaat = electionDAO.getEhdokkaat(ehdokas_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("candidateForm.jsp");
        request.setAttribute("ehdokkaat", existingEhdokkaat);
        dispatcher.forward(request, response);
 
    }
    
    // This method inserts the data into a substring of this StringBuffer.
    private void insertEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String sukunimi = request.getParameter("sukunimi");
        String etunimi = request.getParameter("etunimi");
        String puolue = request.getParameter("puolue");
        String kotipaikkakunta = request.getParameter("kotipaikkakunta");
        int ika = Integer.parseInt(request.getParameter("ika"));
        String miksi_eduskuntaan = request.getParameter("miksi_eduskuntaan");
        String mita_asioita_haluat_edistaa = request.getParameter("mita_asioita_haluat_edistaa");
        String ammatti = request.getParameter("ammatti");
 
        Ehdokkaat newEhdokkaat = new Ehdokkaat(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
        electionDAO.insertEhdokkaat(newEhdokkaat);
        response.sendRedirect("list");
    }
    
    // Sends update request to Candidates table
    private void updateEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ehdokas_id = Integer.parseInt(request.getParameter("ehdokas_id"));
        String sukunimi = request.getParameter("sukunimi");
        String etunimi = request.getParameter("etunimi");
        String puolue = request.getParameter("puolue");
        String kotipaikkakunta = request.getParameter("kotipaikkakunta");
        int ika = Integer.parseInt(request.getParameter("ika"));
        String miksi_eduskuntaan = request.getParameter("miksi_eduskuntaan");
        String mita_asioita_haluat_edistaa = request.getParameter("mita_asioita_haluat_edistaa");
        String ammatti = request.getParameter("ammatti");
 
        Ehdokkaat ehdokkaat = new Ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
        electionDAO.updateEhdokkaat(ehdokkaat);
        response.sendRedirect("list");
    }
    
    // Sends delete request to Candidates table
    private void deleteEhdokkaat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ehdokas_id = Integer.parseInt(request.getParameter("ehdokas_id"));
 
        Ehdokkaat ehdokkaat = new Ehdokkaat(ehdokas_id);
        electionDAO.deleteEhdokkaat(ehdokkaat);
        response.sendRedirect("list");
 
    }
}