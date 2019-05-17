package hotel;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import hotel.*;

/**
 * Servlet implementation class Reserver
 */
@WebServlet("/Reserver")
public class Reserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		BeanHotel b= (BeanHotel) session.getAttribute("nomHotel");
		
		session.setAttribute("de", request.getParameter("enter"));
		session.setAttribute("ds", request.getParameter("quit"));
		session.setAttribute("room", request.getParameter("room"));
		session.setAttribute("nbn", request.getParameter("nbnuit"));
		session.setAttribute("nbp", request.getParameter("nbpersonne"));
		session.setAttribute("hotel", b);
		
		RequestDispatcher rd;
		rd=getServletContext().getRequestDispatcher("/payment.jsp");
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
