package Classes;

public class Turno {
    private int idTurno;
    private char tipo;
    private int tiempoEstimado;

    public Turno(int idTurno, char tipo, int tiempoEstimado) {
        this.idTurno = idTurno;
        this.tipo = tipo;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
}
