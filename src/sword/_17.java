package sword;

/**
 * @author Radon Freedom
 * created at 2019.01.27 18:20
 */

public class _17 {

    public double Power(double base, int exponent) {

        double result = 1;

        if (exponent >= 0) {
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
        }
        else {
            for (int i = 0; i < -exponent; i++) {
                result = result / base;
            }
        }

            return result;
    }
}
