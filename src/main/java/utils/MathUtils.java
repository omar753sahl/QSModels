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
}
