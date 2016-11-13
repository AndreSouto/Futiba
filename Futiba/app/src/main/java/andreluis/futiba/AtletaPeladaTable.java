package andreluis.futiba;

/**
 * Created by duducalil on 04/11/16.
 */
public class AtletaPeladaTable {
    private static AtletaPeladaTable instance = null;
    private int id;
    private int atleta;
    private int pelada;
    private boolean agua;
    private boolean bola;
    private boolean carona;
    private boolean compareceu;

    protected AtletaPeladaTable(int id, int atleta, int pelada, boolean agua, boolean bola,
                                boolean carona, boolean compareceu) {

        this.id = id;
        this.atleta = atleta;
        this.pelada = pelada;
        this.agua = agua;
        this.bola = bola;
        this.carona = carona;
        this.compareceu = compareceu;

    }
    public static AtletaPeladaTable getInstance(int id, int atleta, int pelada, boolean agua, boolean bola,
                                                boolean carona, boolean compareceu) {
        if(instance == null) {
            instance = new AtletaPeladaTable(id, atleta, pelada, agua, bola,
                                             carona, compareceu);
        }
        return instance;
    }

    public boolean isCompareceu() {
        return compareceu;
    }

    public void setCompareceu(boolean compareceu) {
        this.compareceu = compareceu;
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

    public int getPelada() {
        return pelada;
    }

    public void setPelada(int pelada) {
        this.pelada = pelada;
    }

    public boolean isAgua() {
        return agua;
    }

    public void setAgua(boolean agua) {
        this.agua = agua;
    }

    public boolean isBola() {
        return bola;
    }

    public void setBola(boolean bola) {
        this.bola = bola;
    }

    public boolean isCarona() {
        return carona;
    }

    public void setCarona(boolean carona) {
        this.carona = carona;
    }
}
