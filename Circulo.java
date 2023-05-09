import java.util.ArrayList;

public class Circulo  extends FormasGeometricas{
    private double diametro;
    private double raio;

    static ArrayList<Circulo> circulos = new ArrayList<>();


    public Circulo(double raio, double diametro, double perimetro, double area){
        super(perimetro,area);
        this.diametro = diametro;
        this.raio = raio;

    }
}
