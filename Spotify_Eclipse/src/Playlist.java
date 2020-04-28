
public class Playlist {
    private String playlistId, playlistTitle, playlistDur, dateAdded, userPlaylistId;
    
    public Playlist() {
        super();
    }

    public Playlist(String playlistId, String playlistTitle, String playlistDur, String dateAdded,
            String userPlaylistId) {
        super();
        this.playlistId = playlistId;
        this.playlistTitle = playlistTitle;
        this.playlistDur = playlistDur;
        this.dateAdded = dateAdded;
        this.userPlaylistId = userPlaylistId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistTitle() {
        return playlistTitle;
    }

    public void setPlaylistTitle(String playlistTitle) {
        this.playlistTitle = playlistTitle;
    }

    public String getPlaylistDur() {
        return playlistDur;
    }

    public void setPlaylistDur(String playlistDur) {
        this.playlistDur = playlistDur;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getUserPlaylistId() {
        return userPlaylistId;
    }

    public void setUserPlaylistId(String userPlaylistId) {
        this.userPlaylistId = userPlaylistId;
    }
    
    
}
