import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        login();
    }

    private static void login() {
        for (int i = 3; i > 0; i--) {
            System.out.println("Digite sua senha: ");
            int senha = sc.nextInt();

            if(senha==123){
                menu1();
            }
            else {
                System.out.println("Senha incorreta, Tentativas restantes: "+i);
            }
        }
        System.exit(0);
    }

    private static void menu1() {
        int opcao=0;
        do{
            System.out.println("""
                ==== Cadastrar Formas ====
                [1] Círculo
                [2] Triangulo
                [3] Retangulo
                [4] Quadrado
                
                ==== Listar Formas ====
                [5] Listar Todas
                
                ==========================
                >""");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    int opcaoCirculo=0;
                    do{
                        System.out.println("""
                            ==== Circulo ====
                            [1] Inserir o Diametro
                                      ou
                            [2] Inserir o raio
                            =================
                            >""");
                        opcaoCirculo = sc.nextInt();
                    }while (opcaoCirculo!=1 && opcaoCirculo!=2);
                    double diametro=0;
                    double raio=0;
                    double area=0;
                    double perimetro=0;
                    if(opcaoCirculo==1){
                        System.out.println("Diametro: ");
                        diametro = sc.nextDouble();

                        raio = diametro/2;

                        area = 3.14*(raio*raio);

                        perimetro = 3.14*diametro*2*raio;
                    }
                    else {
                        System.out.println("Raio: ");
                        raio = sc.nextDouble();

                        diametro = raio*2;

                        area = 3.14*(raio*raio);

                        perimetro = 3.14*diametro*2*raio;
                    }

                    Circulo circulo = new Circulo(raio, diametro,perimetro, area);
                    Circulo.circulos.add(circulo);
                    break;
                case 2:
                    System.out.println("informe os tres lados do triangulo: ");
                    System.out.println("Lado 1: ");
                    double lado1 = sc.nextDouble();
                    System.out.println("Lado 2: ");
                    double lado2 = sc.nextDouble();
                    System.out.println("Lado 3: ");
                    double lado3 = sc.nextDouble();

                    if (lado1 < lado2 + lado3 && lado2 < lado1 + lado3 && lado3 < lado1 + lado2) {
                        area = 0;
                        perimetro=0;
                        double altura;
                        if (lado1 == lado2 && lado2 == lado3) {
                            String tipo = "equilátero";
                            area = (Math.sqrt(3)/4) * (lado2*lado2);
                            perimetro = 3*lado2;

                            Equilatero equilatero = new Equilatero(perimetro,area);
                            Equilatero.equilateros.add(equilatero);

                        } else if ((lado1 == lado2 && lado1 != lado3) || (lado1 == lado3 && lado1 != lado2) || (lado2 == lado3 && lado2 != lado1)) {

                            double ladoDiferente = 0;

                            double lado = lado1+lado2+lado3;

                            if (lado1 > lado2 && lado1 > lado3) {
                                ladoDiferente = lado1;
                                altura = Math.sqrt(lado2*lado2 - ((lado1-lado3)*(lado1-lado3))/4);
                                perimetro = ladoDiferente+ (2*lado2);

                            } else if (lado2 > lado1 && lado2 > lado3) {
                                ladoDiferente = lado2;
                                altura = Math.sqrt(lado1*lado1 - ((lado2-lado3)*(lado2-lado3))/4);
                                perimetro = ladoDiferente+ (2*lado1);

                            } else {
                                ladoDiferente = lado3;
                                altura = Math.sqrt(lado1*lado1 - ((lado3-lado2)*(lado3-lado2))/4);
                                perimetro = ladoDiferente+ (2*lado2);
                            }

                            area = ladoDiferente * altura / 2;

                            Isóceles isoceles = new Isóceles(altura,perimetro,area,ladoDiferente);
                            Isóceles.Tisoceles.add(isoceles);


                        } else {
                            String tipo = "escaleno";
                            perimetro = lado1+lado2+lado3;
                            double semiperimetro = perimetro/2;
                            area = Math.sqrt((semiperimetro*((semiperimetro-lado1)*(semiperimetro-lado2)*(semiperimetro-lado3))));

                            Escaleno escaleno = new Escaleno(semiperimetro,perimetro,area);
                            Escaleno.Tescalenos.add(escaleno);
                        }
                    } else {
                        System.out.println("Não é possível formar um triângulo com esses valores de lado.");
                        return;
                    }
                    break;
            }
        }while(opcao>0 && opcao<=5);

    }
}
