package andreluis.futiba;

/**
 * Created by duducalil on 06/11/16.
 */
public class ArenaTable {
    private static ArenaTable instance = null;
    private int id;
    private float latitude, longitude;
    private int nota_media;
    private boolean agua_perto, coberta;
    private String tipo;

    protected ArenaTable(int id, int nota_media, float latitude, float longitude,
                         boolean agua_perto, boolean coberta, String tipo) {

        this.id = id;
        this.nota_media = nota_media;
        this.latitude = latitude;
        this.longitude = longitude;
        this.agua_perto = agua_perto;
        this.coberta = coberta;
        this.tipo = tipo;
    }
    public static ArenaTable getInstance(int id, int nota_media, float latitude, float longitude,
                                         boolean agua_perto, boolean coberta, String tipo) {
        if(instance == null) {
            instance = new ArenaTable(id, nota_media, latitude, longitude,
                                       agua_perto, coberta, tipo);
        }
        return instance;
    }
}
