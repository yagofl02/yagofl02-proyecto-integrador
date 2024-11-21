package ColdWar;

public class Equipo {
    public int vidas = 200;
    public String nombre;
    public int numero;
    public int misilesAtaque = 0;
    public int misilesDefensa = 0;

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumero(int newNumero) {
        this.numero = newNumero;
    }

    public int getNumero() {
        return numero;
    }

    public void setVidas(int newVidas) {
        this.vidas = newVidas;
    }

    public int getVidas() {
        return vidas;
    }

    public void setMisilesAtaque(int newMisilesAtaque) {
        this.misilesAtaque = newMisilesAtaque;
    }

    public int getMisilesAtaque() {
        return misilesAtaque;
    }

    public void setMisilesDefensa(int newMisilesDefensa) {
        this.misilesDefensa = newMisilesDefensa;
    }

    public int getMisilesDefensa() {
        return misilesDefensa;
    }
}
