import java.util.ArrayList;

public class Equilatero extends Triangulo{
    static ArrayList<Triangulo> equilateros = new ArrayList<>();

    public Equilatero(double perimetro, double area){
        super(area, perimetro);
    }
}
