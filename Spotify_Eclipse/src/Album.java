
public class Album {
    private String album_id, title, artist_name, album_track, release_date, genre_id;

    public Album() {
        super();
    }
    
    public Album(String album_id, String title, String artist_name, String album_track, String release_date,
            String genre_id) {
        super();
        this.album_id = album_id;
        this.title = title;
        this.artist_name = artist_name;
        this.album_track = album_track;
        this.release_date = release_date;
        this.genre_id = genre_id;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getAlbum_track() {
        return album_track;
    }

    public void setAlbum_track(String album_track) {
        this.album_track = album_track;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(String genre_id) {
        this.genre_id = genre_id;
    }
    
    
    

}
