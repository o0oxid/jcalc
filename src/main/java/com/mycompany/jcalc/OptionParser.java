package com.mycompany.jcalc;

import java.util.LinkedList;

/**
 * Created by okhoruzhenko on 12/16/16.
 */
public class OptionParser {
    private LinkedList<ExpressionItem> expression;
    private String operationRegexp;

    OptionParser(String expressionString) {
        StringBuilder operationBuilder = new StringBuilder();
        operationBuilder.append("[");
        for (Operation o: Operation.values()) {
            operationBuilder.append("\\" + o.getSign());
        }
        operationBuilder.append("]");
        operationRegexp = "(?=" + operationBuilder.toString() + ")|(?<=" + operationBuilder.toString() +")";
        this.expression = stringToOperation(parse(expressionString));
    }

    public LinkedList<ExpressionItem> getExpression() {
        return expression;
    }

    private String[] parse(String options) {

        StringBuilder expressionBuilder = new StringBuilder();
        expressionBuilder.append("[");
        for (Operation o: Operation.values()) {
            expressionBuilder.append("\\" + o.getSign());
        }
        expressionBuilder.append("]");
        String operations = expressionBuilder.toString();

        // non-capturing special constructions.
        // http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        // http://stackoverflow.com/questions/19951850/split-string-with-regex-but-keep-delimeters-in-match-array
        //String regexp = "(?=[-\\+/\\*\\(\\)])|(?<=[-\\+/\\*\\(\\)])";
        String regexp = "(?=" + operations + ")|(?<=" + operations +")";

        return options.split(operationRegexp);
    }

    private boolean evaluateConstantFormat(String constant) {
        String regexp = "[0-9]{1,4}(\\.[0-9]{0,6})?";
        return constant.matches(regexp);
    }


    private LinkedList<ExpressionItem> stringToOperation (String[] expressionStringArray) {
        LinkedList<ExpressionItem> expressionOperationList = new LinkedList<>();
        for (String item: expressionStringArray) {
            Operation operation = Operation.getOperation(item);
            if (!operation.equals(Operation.DONOTHING)) {
                expressionOperationList.add(new ExpressionOperation(operation));
            } else {
                double constant;
                try {
                    constant = Double.parseDouble(item);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("No such operation '" + item.charAt(0) + "' for input string: " + item);
                }

                if (!evaluateConstantFormat(item)) {
                    throw new RuntimeException("Constant " + item + " doesn't comply with format 'xxxx.yyyyyyy'.");
                }
                expressionOperationList.add(new ExpressionConstant(constant));
            }
        }
        return expressionOperationList;
    }
}
