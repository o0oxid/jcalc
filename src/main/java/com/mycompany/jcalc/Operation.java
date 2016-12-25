package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/23/16.
 */
public enum Operation implements OperationInterface {
    ADD ('+', 1) {
        @Override
        public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
            return new ExpressionConstant(a.perform() + b.perform());
        }
    },
    SUB ('-', 1) {
        @Override
        public ExpressionItem perform(ExpressionItem a) {
            return new ExpressionConstant(a.perform() * -1 );
        }
        @Override
        public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
            return new ExpressionConstant(a.perform() - b.perform());
        }
    },
    DIV ('/', 5) {
        @Override
        public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
            return new ExpressionConstant(a.perform() / b.perform());
        }
    },
    MUL ('*', 5) {
        @Override
        public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
            return new ExpressionConstant(a.perform() * b.perform());
        }
    },
    WUP ('(', 1000) {
        @Override
        public ExpressionItem perform(ExpressionItem a) {
            a.setWeight(a.getWeight()  + getWeight());
            return a;
        }
    },
    WDOWN(')', 1000) {
        @Override
        public ExpressionItem perform(ExpressionItem a) {
            a.setWeight(a.getWeight()  - getWeight());
            return a;
        }
    };


    private char sign;
    private int weight;

    Operation(char sign, int weight) {
        this.sign = sign;
        this.weight = weight;
    }

    public ExpressionItem perform(ExpressionItem a) {
        throw new RuntimeException("Unary operation isn't supported.");
    }

    public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
        throw new RuntimeException("Binary operation isn't supported.");
    }

    public String toString() {return ""+sign;}
    public char getSign() {return sign;}
    public int getWeight() {return weight;}
}
