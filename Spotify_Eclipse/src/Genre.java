
public class Genre {
    private String genreId, type;
    
    public Genre() {
        super();
    }

    public Genre(String genreId, String type) {
        super();
        this.genreId = genreId;
        this.type = type;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
