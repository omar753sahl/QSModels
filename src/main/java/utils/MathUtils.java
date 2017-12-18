package utils;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


/**
 * Created by Omar
 * Date: 17-Dec-17.
 */
public final class MathUtils {

    public static Double eval(String expressionStr) throws Exception {
        Expression expression = new ExpressionBuilder(expressionStr)
                .build();

        return expression.evaluate();
    }
}
