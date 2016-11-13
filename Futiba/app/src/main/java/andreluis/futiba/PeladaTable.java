package andreluis.futiba;

/**
 * Created by duducalil on 04/11/16.
 */
public class PeladaTable {
    private static PeladaTable instance = null;
    private int id;
    private int capacidade;
    private int confirmados;
    private int criador;
    private String horario;
    private String data;
    private String nome;
    private String tipo;
    private String preco;
    private String restricao;
    private String descricao;
    private float latitude, longitude;
    private boolean paga;
    private boolean apostada;

    protected PeladaTable(int id, int capacidade, int confirmados, int criador, String horario,
                          String data, String nome, String tipo, String preco, String restricao,
                          String descricao, float latitude, float longitude, boolean paga,
                          boolean apostada) {

        this.id = id;
        this.capacidade = capacidade;
        this.confirmados = confirmados;
        this.criador = criador;
        this.horario = horario;
        this.data = data;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.restricao = restricao;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.paga = paga;
        this.apostada = apostada;

    }
    public static PeladaTable getInstance(int id, int capacidade, int confirmados, int criador, String horario,
                                          String data, String nome, String tipo, String preco, String restricao,
                                          String descricao, float latitude, float longitude, boolean paga,
                                          boolean apostada) {
        if(instance == null) {
            instance = new PeladaTable(id, capacidade, confirmados, criador, horario,
                                       data, nome, tipo, preco, restricao, descricao,
                                       latitude, longitude, paga, apostada);
        }
        return instance;
    }

    public boolean isApostada() {
        return apostada;
    }

    public void setApostada(boolean apostada) {
        this.apostada = apostada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getConfirmados() {
        return confirmados;
    }

    public void setConfirmados(int confirmados) {
        this.confirmados = confirmados;
    }

    public int getCriador() {
        return criador;
    }

    public void setCriador(int criador) {
        this.criador = criador;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getRestricao() {
        return restricao;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

}
