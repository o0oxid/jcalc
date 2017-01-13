package com.mycompany.jcalc;

import java.util.LinkedList;

/**
 * Created by okhoruzhenko on 1/3/17.
 */
class Calculate {

    public void calculate(LinkedList<ExpressionItem> expressionOperationList) {
        applyPriorities(expressionOperationList);
        calculateExpression(expressionOperationList);
    }

    private void calculateExpression(LinkedList<ExpressionItem> expressionOperationList) {
        if (expressionOperationList.size() == 1) return;
        ExpressionItem maxWeightOperation = expressionOperationList.get(0);
        for (ExpressionItem item: expressionOperationList) {
            if (item.isOperation() && (maxWeightOperation.getWeight() < item.getWeight())) maxWeightOperation = item;
        }
        try {
            collapse(expressionOperationList, maxWeightOperation);
        } catch(RuntimeException e) {
            throw new IllegalArgumentException("Expression exception: '" + listToString(expressionOperationList) +
                    "' on operation '" + maxWeightOperation.toString() + "', " + e.getMessage());
        }
        calculateExpression(expressionOperationList);
    }

    private void collapse(LinkedList<ExpressionItem> expressionOperationList, ExpressionItem operation) {
        int index = expressionOperationList.indexOf(operation);
        if (index == 0) {
            expressionOperationList.add(index,operation.perform(expressionOperationList.get(index+1)));
            expressionOperationList.remove(index+1);
            expressionOperationList.remove(index+1);
        } else if (!expressionOperationList.get(index-1).operation.equals(Operation.DONOTHING)) {
            expressionOperationList.add(index,operation.perform(expressionOperationList.get(index+1)));
            expressionOperationList.remove(index+1);
            expressionOperationList.remove(index+1);
        } else {
            expressionOperationList.add(index-1,operation.perform(expressionOperationList.get(index-1),expressionOperationList.get(index+1)));
            expressionOperationList.remove(index);
            expressionOperationList.remove(index);
            expressionOperationList.remove(index);
        }

    }

    private void applyPriorities(LinkedList<ExpressionItem> expressionOperationList) {
        int bumpPriorityCounter = 0;
        for (ExpressionItem item: expressionOperationList) {
            if (item.operation.equals(Operation.WUP) ) {
               bumpPriorityCounter++;
            }
            else if (item.operation.equals(Operation.WDOWN)) {
                bumpPriorityCounter--;
            } else {
                for(int i = 0; i < bumpPriorityCounter; i++)  {
                    Operation.WUP.perform(item);
                }
            }
        }
        if (bumpPriorityCounter != 0) {
            throw new RuntimeException("Priority operations mismatch.");
        }
        expressionOperationList.removeIf(item -> (item.operation.equals(Operation.WUP) || item.operation.equals(Operation.WDOWN)));
    }

    private String listToString(LinkedList<ExpressionItem> expressionOperationList) {
        StringBuilder expression = new StringBuilder();
        expressionOperationList.forEach(item -> expression.append(item).append(" "));
        return expression.toString().trim();
    }
}
