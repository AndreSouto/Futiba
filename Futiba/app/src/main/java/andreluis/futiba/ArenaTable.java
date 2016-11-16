package andreluis.futiba;

/**
 * Created by duducalil on 06/11/16.
 */
public class ArenaTable {
    private static ArenaTable instance = null;
    private String id;
    public double latitude, longitude;
    private int nota_media;
    private boolean agua_perto, banheiro, arena_paga, arena_iluminada;
    private String tipo;

    protected ArenaTable(String id, int nota_media, double latitude, double longitude,
                         boolean agua_perto, boolean banheiro, String tipo, boolean arena_paga,
                         boolean arena_iluminada) {

        this.id = id;
        this.nota_media = nota_media;
        this.latitude = latitude;
        this.longitude = longitude;
        this.agua_perto = agua_perto;
        this.banheiro = banheiro;
        this.tipo = tipo;
        this.arena_iluminada = arena_iluminada;
        this.arena_paga = arena_paga;
    }
    public static ArenaTable getInstance(String id, int nota_media, double latitude, double longitude,
                                         boolean agua_perto, boolean banheiro, String tipo, boolean arena_paga,
                                         boolean arena_iluminada) {

        if(instance == null) {
            instance = new ArenaTable(id, nota_media, latitude, longitude,
                                       agua_perto, banheiro, tipo, arena_paga, arena_iluminada);
        }
        return instance;
    }
}
