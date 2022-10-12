public class Meth {
    public static double discriminant(int a, int b, int c) {
        double D = (b * b) - (4 * a * c);

        if (D < 0)  return -1;

        return D;
    }

    public static void quadratic(int a, int b, int c) {
        double D = discriminant(a, b, c);

             if (D == -1) System.out.println("Discriminant Negative, No Real Roots");
        else if (D ==  0) System.out.printf ("Discriminant = 0\nx = %f\n", (-b / (2. * a)));

        D = Math.sqrt(D);
        double x1 = (-b + D) / (2. * a);
        double x2 = (-b - D) / (2. * a);
        System.out.printf("Discriminant: %f\nx1 = %f\nx2 = %f\n", D, x1, x2);
    }
}
