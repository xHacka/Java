public class Fraction {
    private int numerator, denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction fraction) {
        return new Fraction(
                (this.numerator * fraction.denominator) + (fraction.numerator * this.denominator),
                this.denominator * fraction.denominator
        );
    }

    public Fraction add(int n) {
        Fraction fraction = new Fraction(n * this.denominator, this.denominator);
        return this.add(fraction);
    }

    public Fraction sub(Fraction fraction) {
        return new Fraction(
                (this.numerator * fraction.denominator) - (fraction.numerator * this.denominator),
                this.denominator * fraction.denominator
        );
    }

    public Fraction sub(int n) {
        Fraction fraction = new Fraction(n * this.denominator, this.denominator);
        return this.sub(fraction);
    }

    public Fraction mul(Fraction fraction) {
        return new Fraction(
                this.numerator * fraction.numerator,
                this.denominator * fraction.denominator
        );
    }

    public Fraction mul(int n) {
        return this.mul(new Fraction(this.numerator * n, 1));
    }

    public Fraction div(Fraction fraction) {
        return this.mul(new Fraction(fraction.denominator, fraction.numerator));
    }

    public Fraction div(int n) {
        return this.div(new Fraction(n, 1));
    }

    public double result() {
        return (double)this.numerator / this.denominator;
    }

    public void truncate() {
        for (int i = 1; i <= Math.max(this.numerator, this.denominator); i++) {
                 if (this.numerator   % i != 0) continue;
            else if (this.denominator % i != 0) continue;

            this.numerator /= i;
            this.denominator /= i;
        }
    }

    public Fraction truncates() {
        int numerator = this.numerator;
        int denominator = this.denominator;

        for (int i = 1; i <= Math.max(this.numerator, this.denominator); i++) {
                 if (this.numerator   % i != 0) continue;
            else if (this.denominator % i != 0) continue;

            numerator   /= i;
            denominator /= i;
        }

        return new Fraction(numerator, denominator);
    }



    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
