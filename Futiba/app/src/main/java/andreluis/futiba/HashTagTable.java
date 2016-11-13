package andreluis.futiba;

/**
 * Created by duducalil on 04/11/16.
 */
public class HashTagTable {
    private static HashTagTable instance = null;
    private int id;

    private String descricao;

    protected HashTagTable(int id, String descricao) {

        this.id = id;
        this.descricao = descricao;

    }
    public static HashTagTable getInstance(int id, String descricao) {
        if(instance == null) {
            instance = new HashTagTable(id, descricao);
        }
        return instance;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
