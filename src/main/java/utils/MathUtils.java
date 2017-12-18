package utils;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public final class MathUtils {

    /**
     * Evaluates any valid mathematical expression.
     * ex. (3 + 10) * 14
     *
     * @param expressionStr string representing a mathematical expression.
     * @return a @{@link Double} representing the result of this expression.
     * @throws Exception if it fails to evaluate the supplied expression.
     */
    public static Double eval(String expressionStr) throws Exception {
        Expression expression = new ExpressionBuilder(expressionStr)
                .build();

        return expression.evaluate();
    }


    static long f[];
    public static void prepareFact(int MX){
        f = new long[MX + 1];
        f[0] = 1;
        for(int i = 1; i <= MX; ++i) f[i] = f[i - 1] * i;
    }

    //O(1) factorial query
    public static long fact(int x){
        return f[x];
    }

    //Binary exponentiation O(log2(exponent)) runtime
    public static double pow(double base, int exponent){

        double res = 1;

        boolean reversed = false;

        if(exponent < 0){
            reversed = true;
            exponent *= -1;
        }

        while(exponent != 0){
            if((exponent & 1) == 1) res = res * base;
            exponent /= 2;
            base = base * base;
        }

        return reversed ? 1 / res : res;
    }
}
