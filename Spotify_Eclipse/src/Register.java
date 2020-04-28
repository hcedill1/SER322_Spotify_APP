

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
        String albumId = request.getParameter("Album_ID");
        String albumTitle = request.getParameter("Title");
        String artistName = request.getParameter("Artist_Name");
        String albumTrack = request.getParameter("Album_Track");
        String albumRelease = request.getParameter("Release_Date");
        
        String genreId = request.getParameter("Genre_ID");
        String type = request.getParameter("Type");
        
        String trackName = request.getParameter("Track_Name");
        String trackDur = request.getParameter("Track_Duration");
        
        String artistN = request.getParameter("Artist_Name");
        String artistAlbum = request.getParameter("Album_Name");
        String fans = request.getParameter("Fans");
        
        String userId = request.getParameter("User_Playlist_ID");
        String userFollowers = request.getParameter("Followers");
        
        String playlistId = request.getParameter("Playlist_ID");
        String playlistTitle = request.getParameter("Playlist_Title");
        String playlistDur = request.getParameter("Playlist_Duration");
        String playlistAdded = request.getParameter("Date_Added");
        
        String popFollowers = request.getParameter("Followers");
        String popLikes = request.getParameter("Likes");
        
        Album album = new Album(albumId, albumTitle, artistName, albumTrack, albumRelease, genreId);
        Genre genre = new Genre(genreId, type);
        Tracks track = new Tracks(trackName, trackDur, albumId);
        Artist artist = new Artist(artistN, artistAlbum, trackName, fans);
        User user = new User(userId, userFollowers);
        Playlist playlist = new Playlist(playlistId, playlistTitle, playlistDur, playlistAdded, userId);
        Popularity popularity = new Popularity(popFollowers, popLikes, trackName);
        
        RegisterDao rDao = new RegisterDao();
        
        String resultAlbum = rDao.insertAlbum(album);
        String resultGenre = rDao.insertGenre(genre);
        String resultTracks = rDao.insertTracks(track);
        String resultArtist = rDao.insertArtist(artist);
        String resultUser = rDao.insertUser(user);
        String resultPlaylist = rDao.insertPlaylist(playlist);
        String resultPop = rDao.insertPopularity(popularity);
        
        response.getWriter().print(resultGenre);
        response.getWriter().print(resultAlbum);
        response.getWriter().print(resultTracks);
        response.getWriter().print(resultArtist);
        response.getWriter().print(resultUser);
        response.getWriter().print(resultPlaylist);
        response.getWriter().print(resultPop);
        
	}

}
