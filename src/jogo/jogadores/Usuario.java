package jogo.jogadores;

public class Usuario {

    private Integer usuario;

    private int pontosUsuario = 0;

    public Integer getUsuario() {
        return usuario;
    }

    public Integer setUsuario(Integer usuario) {
        this.usuario = usuario;
        return usuario;
    }

    public int getPontosUsuario() {
        return pontosUsuario;
    }

    public int setPontosUsuario(int pontosUsuario) {
        this.pontosUsuario = pontosUsuario;
        return pontosUsuario;
    }
}
