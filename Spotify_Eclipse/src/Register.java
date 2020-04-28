

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
	    /*
	    String album = request.getParameter("Album");
        String artist = request.getParameter("Artist");
        String genre = request.getParameter("Genre");
        String playlist = request.getParameter("Playlist");
        String popularity = request.getParameter("Popularity");
        String tracks = request.getParameter("Tracks");
        String user = request.getParameter("User");
        
	    
        String albumId = request.getParameter("Album_ID");
        String albumTitle = request.getParameter("Title");
        String artistName = request.getParameter("Artist_Name");
        String albumTrack = request.getParameter("Album_Track");
        String albumRelease = request.getParameter("Release_Date");
        String albgenreId = request.getParameter("Genre_ID");
        */
	    
        String genreId = request.getParameter("Genre_ID");
        String type = request.getParameter("Type");
        
        
        //Music music = new Music(album, artist, genre, playlist, popularity, tracks, user);
        //Album album = new Album(albumId, albumTitle, artistName, albumTrack, albumRelease, albgenreId);
        Genre genre = new Genre(genreId, type);
        RegisterDao rDao = new RegisterDao();
        
        //String result = rDao.insert(music);
        //String result = rDao.insertAlbum(album);
        String result = rDao.insertGenre(genre);
        
        response.getWriter().print(result);
	}

}
