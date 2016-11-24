package andreluis.futiba;

/**
 * Created by duducalil on 04/11/16.
 */
public class AtletaTable {
    private static AtletaTable instance = null;
    private int id, gente_boa, bom_de_bola;
    private String nome_completo;
    private String username;
    private String email;
    private boolean status;
    private String data_nascimento;
    private String senha;
    private boolean joga_gol;
    private String filosofia;
    private String posicao_futsal;
    private String posicao_campo;

    protected AtletaTable(int id, String nome_completo, String username, String email,
                          boolean status, int gente_boa,
                          int bom_de_bola, boolean joga_gol, String filosofia,
                          String posicao_futsal, String posicao_campo, String data_nascimento,
                          String senha) {

        this.id = id;
        this.nome_completo = nome_completo;
        this.username = username;
        this.email = email;
        this.status = status;
        this.data_nascimento = data_nascimento;
        this.senha = senha;
        this.gente_boa = gente_boa;
        this.bom_de_bola = bom_de_bola;
        this.joga_gol = joga_gol;
        this.filosofia = filosofia;
        this.posicao_futsal = posicao_futsal;
        this.posicao_campo = posicao_campo;

    }
    public static AtletaTable getInstance(int id, String nome_completo, String username, String email,
                                          boolean status, int gente_boa,
                                          int bom_de_bola, boolean joga_gol, String filosofia,
                                          String posicao_futsal, String posicao_campo, String data_nascimento,
                                          String senha) {
        if(instance == null) {
            instance = new AtletaTable(id, nome_completo, username, email, status, gente_boa,
                    bom_de_bola, joga_gol, filosofia, posicao_futsal,
                    posicao_campo, data_nascimento, senha);
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int isGente_boa() {
        return gente_boa;
    }

    public void setGente_boa(int gente_boa) {
        this.gente_boa = gente_boa;
    }

    public void addGente_boa() {this.gente_boa++; }

    public int isBom_de_bola() {
        return bom_de_bola;
    }

    public void setBom_de_bola(int bom_de_bola) {
        this.bom_de_bola = bom_de_bola;
    }

    public void addBom_de_bola() { this.bom_de_bola++; }

    public boolean isJoga_gol() {
        return joga_gol;
    }

    public void setJoga_gol(boolean joga_gol) {
        this.joga_gol = joga_gol;
    }

    public String getFilosofia() {
        return filosofia;
    }

    public void setFilosofia(String filosofia) {
        this.filosofia = filosofia;
    }

    public String getPosicao_futsal() {
        return posicao_futsal;
    }

    public void setPosicao_futsal(String posicao_futsal) {
        this.posicao_futsal = posicao_futsal;
    }

    public String getPosicao_campo() {
        return posicao_campo;
    }

    public void setPosicao_campo(String posicao_campo) {
        this.posicao_campo = posicao_campo;
    }
}