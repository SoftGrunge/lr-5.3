public class Main {

    public static void main(String[] args) {
        Func1_1 f1 = new F11();
        System.out.println("Inner class: " + math(f1, 1, 3, 1, 3));

        Func1_1 f2 = new Func1_1() {
            public double f(double x, double y) {
                return (x*x+x)*(2*y+1);
            }
        };
        System.out.println("Anon class: " + math(f2, 3, 4, 7, 10));

        Func1_1 f3 = Func1_1::staticMeth;      // статический метод
        System.out.println("Static method: "+ math(f3, 0.01, 2, 0.5, 4));

        Func1 func4 = new Func1();    // ссылка на метод экземпляра
        Func1_1 f4 = func4::xy;
        System.out.println("Method reference: " + math(f4, 1, 3, 1, 2));



    }

    private static final int p = 100;

    public static double math(Func1_1 func1, double lX, double rX, double lY, double rY){
        double v = 0;


        double sX = (rX - lX)/100;
        double sY = (rY - lY)/100;
        for(int i = 0; i< p; i++) {
            lX += sX;
            double temp =lY;
            for(int j = 0; j< p; j++) {
                temp += sY;
                double s = sX*sY* func1.f(lX - sX/2 , temp - sY/2);
                v += s;
            }
        }return v;

    }


    private static class F11 implements Func1_1 {
        @Override
        public double f(double x, double y) {
            return x*y;
        }
    }
}