package com.mycompany.jcalc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by okhoruzhenko on 1/3/17.
 */
public class Calculate {
    public static void CalculateExpression(LinkedList<ExpressionItem> expressionOperationList) {
        if (expressionOperationList.size() == 1) return;
        ExpressionItem maxWeightOperation = expressionOperationList.get(0);
        for (ExpressionItem item: expressionOperationList) {
            if (item.isOperation() && (maxWeightOperation.getWeight() < item.getWeight())) maxWeightOperation = item;
        }
        Collapse(expressionOperationList, maxWeightOperation);
        CalculateExpression(expressionOperationList);

    }
    private static void Collapse(LinkedList<ExpressionItem> expressionOperationList, ExpressionItem operation) {
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

    public static void ApplyPriorities(LinkedList<ExpressionItem> expressionOperationList) {
        expressionOperationList.forEach((item) -> {
            if (item.operation.equals(Operation.WUP) || item.operation.equals(Operation.WDOWN)) {
                ListIterator<ExpressionItem> list = expressionOperationList.listIterator(expressionOperationList.indexOf(item)+1);
                while (list.hasNext()) item.perform(list.next());
            }
        });
        expressionOperationList.removeIf(item -> (item.operation.equals(Operation.WUP) || item.operation.equals(Operation.WDOWN)));
    }
}
