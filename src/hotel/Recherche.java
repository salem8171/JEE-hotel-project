package hotel;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/bdhotel";
			Connection c = (Connection) DriverManager.getConnection(url, "root", "");
			
			Statement st = (Statement) c.createStatement();
			String ville=request.getParameter("ville");
			int nbrEtoile = Integer.parseInt(request.getParameter("nbrEtoile"));
			String query="select * from hotel where upper(ville)='"+ville.toUpperCase()+" 'and nbre_etoiles='"+nbrEtoile+"'";
			
			ResultSet rs = st.executeQuery(query);
			Vector <BeanHotel> vh = new Vector<>();
			while(rs.next())
			{
				BeanHotel h = new BeanHotel(rs.getString("ville"), 
						rs.getString("nom"), rs.getInt("nbre_etoiles"),rs.getDouble("prix_single"), 
						rs.getDouble("prix_double")); 
				
				vh.add(h);
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("hotel", vh);
			
			response.sendRedirect("http://localhost:8070/HotelProject/ListeHotels.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
