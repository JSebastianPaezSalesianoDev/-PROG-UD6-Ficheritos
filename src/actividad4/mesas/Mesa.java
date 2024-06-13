package actividad4.mesas;

import java.io.Serializable;

public class Mesa implements Serializable {
    private String color;
    private int numeroPatas;

    public Mesa(String color, int numeroPatas) {
        this.color = color;
        this.numeroPatas = numeroPatas;
    }

    public String getColor() {
        return this.color;
    }

    public int getNumeroPatas() {
        return this.numeroPatas;
    }

    @Override
    public String toString() {
        return "Mesa [color=" + color + ", numeroPatas=" + numeroPatas + "]";
    }

   
}