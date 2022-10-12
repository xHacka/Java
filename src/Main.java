import java.util.Scanner;

public class Main {
    public static void testFraction() {
        int n = 5;

        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        double res1 = f1.result(), res2 = f2.result();

        System.out.printf("Fraction 1: (%s)\tResult: %f \n", f1, res1);
        System.out.printf("Fraction 2: (%s)\tResult: %f\n", f2, res2);

        Fraction f3 = f1.add(f2);
        System.out.printf("(%s) + (%s) = (%s)\n", f1, f2, f3);
        Fraction f3_2 = f1.add(n);
        System.out.printf("(%s) + (%d) = (%s)\n", f1, n, f3_2);

        Fraction f4 = f1.sub(f2);
        System.out.printf("(%s) - (%s) = (%s)\n", f1, f2, f4);
        Fraction f4_2 = f1.sub(n);
        System.out.printf("(%s) - (%d) = (%s)\n", f1, n, f4_2);

        Fraction f5 = f1.mul(f2);
        System.out.printf("(%s) * (%s) = (%s)\n", f1, f2, f5);
        Fraction f5_2 = f1.mul(n);
        System.out.printf("(%s) * (%d) = (%s)\n", f1, n, f5_2);

        Fraction f6 = f1.div(f2);
        System.out.printf("(%s) / (%s) = (%s)\n", f1, f2, f6);
        Fraction f6_2 = f1.div(n);
        System.out.printf("(%s) / (%d) = (%s)\n", f1, n, f6_2);

        f3_2.truncate();
        System.out.printf("22/4 Truncated To %s\n", f3_2);

        Fraction f4_2_truncated = f4_2.truncates();
        System.out.printf("%s Truncated To %s\n", f4_2, f4_2_truncated);

        double f1d = 1. / 2, f2d = 1. / 3;
        assert (f3.result()   == (f1d + f2d));
        assert (f3_2.result() == (f1d + n));
        assert (f4.result()   == (f1d - f2d));
        assert (f4_2.result() == (f1d - n));
        assert (f5.result()   == (f1d * f2d));
        assert (f5_2.result() == (f1d * n));
        assert (f6.result()   == (f1d / f2d));
        assert (f6_2.result() == (f1d / n));
    }

    public static void testDiscriminant() {
        int a, b, c;

        a = 3;
        b = 4;
        c = 1;

//        Scanner input = new Scanner(System.in);
//        System.out.print("a: "); a = input.nextInt();
//        System.out.print("b: "); b = input.nextInt();
//        System.out.print("c: "); c = input.nextInt();

        System.out.printf("Discriminant = %f\n", Meth.discriminant(a, b,c));
        Meth.quadratic(a, b, c);
    }

    public static void testLongestString() {
        String[] strings = {
                "A", "priest", "is", "being", "chased", "through", "the", "woods", "by", "a", "hungry", "bear",
                "As", "the", "priest", "is", "running", "he", "makes", "an", "impassioned", "plea", "to", "God:",
                "Oh", "please", "God", "in", "your", "infinite", "wisdom", "and", "mercy", "turn", "this", "bear",
                "into", "a", "good", "Christian!", "Before", "he", "can", "get", "another", "word", "out", "he",
                "trips", "over", "a", "log", "and", "goes", "sprawling", "The", "bear", "catches", "up", "and",
                "approaches", "the", "terrified", "priest", "Rising", "up", "on", "its", "hind", "legs", "it",
                "puts", "its", "paws", "together", "and", "says", "Lord", "thank", "you", "for", "this", "meal",
                "that", "I", "am", "about", "to", "receive"
        };
        System.out.printf("Smallest String: %s", Stringz.longestStr(strings));
    }

    public static void main(String[] args) {
        testFraction();
        System.out.println();
        testDiscriminant();
        System.out.println();
        testLongestString();
    }
}