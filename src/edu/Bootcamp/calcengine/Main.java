package edu.Bootcamp.calcengine;

public class Main {

    public static void main(String[] args) {
//      Calculating engine! Takes two values and returns a result.
        double value1 = 100.0d;
        double value2 = 0.0d;
        double result = 0.0d;
        char opCode = 'd';

//      This first operator code uses 'a' for 'adding'
        if (opCode == 'a')
            result = value1 + value2;
//      's' for subtract
        else if (opCode == 's') result = value1 - value2;
//      'm' for multiplying
        else if (opCode == 'm') result = value1 * value2;
//      'd' for dividing
        else if (opCode == 'd')
            {if (value2 != 0)
                result = value1 / value2; // this extra if statement is because numbers can't be divided by 0, it messes with the code. So we're just returning 0 when that happens:
            else result = 0d;
            }
        else {
            System.out.println("Invalid opCode: " + opCode);
            result = 0.0d;
        }

        System.out.println(result);
    }
}
