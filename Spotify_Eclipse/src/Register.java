

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String album = request.getParameter("Album");
        String artist = request.getParameter("Artist");
        String genre = request.getParameter("Genre");
        String playlist = request.getParameter("Playlist");
        String popularity = request.getParameter("Popularity");
        String tracks = request.getParameter("Tracks");
        String user = request.getParameter("User");
        
        Music music = new Music(album, artist, genre, playlist, popularity, tracks, user);
        RegisterDao rDao = new RegisterDao();
        
        String result = rDao.insert(music);
        response.getWriter().print(result);
	}

}
