package andreluis.futiba;

/**
 * Created by duducalil on 04/11/16.
 */
public class AtletaHashTagTable {
    private static AtletaHashTagTable instance = null;
    private int id;
    private int atleta;
    private int hashtag;

    protected AtletaHashTagTable(int id, int atleta, int hashtag) {

        this.id = id;
        this.atleta = atleta;
        this.hashtag = hashtag;

    }
    public static AtletaHashTagTable getInstance(int id, int atleta, int hashtag) {
        if(instance == null) {
            instance = new AtletaHashTagTable(id, atleta, hashtag);
        }
        return instance;
    }

    public int getHashtag() {
        return hashtag;
    }

    public void setHashtag(int hashtag) {
        this.hashtag = hashtag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtleta() {
        return atleta;
    }

    public void setAtleta(int atleta) {
        this.atleta = atleta;
    }
}
