import java.util.ArrayList;

public class Isóceles extends Triangulo {

    double altura;
    double ladoDiferente;

    static ArrayList<Triangulo> Tisoceles = new ArrayList<>();

    public Isóceles(double altura, double perimetro, double area, double ladoDiferente){
        super(area, perimetro);
        this.altura = altura;
        this.ladoDiferente = ladoDiferente;
    }
}
