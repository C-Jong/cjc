package com.calculator;

public class Calculator {
    private String num1;
    private String num2;
    private String operator;

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
            this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double Result(){
        double result = 0.0;
        try {
            double first = Double.parseDouble(num1);
            double second = Double.parseDouble(num2);
                if ("+".equals(operator)) result = first + second;
                else if ("-".equals(operator)) result = first - second;
                else if ("*".equals(operator)) result = first * second;
                else if ("/".equals(operator)) result = first / second;
            } catch (Exception e) {

                return 0.0;

        }

        return result;
    }
}
