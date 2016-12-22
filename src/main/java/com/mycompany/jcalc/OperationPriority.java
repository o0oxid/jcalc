package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public class OperationPriority extends OperationAbstract {
    public int priority = 1000;

    private int direction=1;
    public OperationPriority(boolean direction) {
        if (!direction) this.direction = -1;
    }

    public void perform(OperationAbstract operation) {
        operation.priority += 10 * this.direction;
    }

    public String toString() {
        if (direction == 1) {
            return "( " + this.priority;
        }
        else {
            return ") " + this.priority;
        }
    }

}
