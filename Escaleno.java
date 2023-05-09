import java.util.ArrayList;

public class Escaleno extends Triangulo{

    double semiperimetro;

    static ArrayList<Triangulo> Tescalenos = new ArrayList<>();


    public Escaleno(double semiperimetro, double perimetro, double area){
        super(area, perimetro);
        this.semiperimetro = semiperimetro;
    }
}
