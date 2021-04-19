package edu.Bootcamp.calcengine;

public class Main {

    public static void main(String[] args) {
/*
//      This calculation engine will take two values and returns a result.
System.out.println("\nUsing an if-statement to run a calculation engine.\n");
//      Just declaring some variables to work with here. This is basically our input field.
        double value1 = 100.0d;
        double value2 = 0.0d;
        double result = 0.0d;
        char opCode = 'd';

//      This first operator code uses 'a' for 'adding'
        if (opCode == 'a')
            result = value1 + value2;
//      The next uses 's' for subtract
        else if (opCode == 's') result = value1 - value2;
//      'm' for multiplying
        else if (opCode == 'm') result = value1 * value2;
//      'd' for dividing
        else if (opCode == 'd')
            {if (value2 != 0)
                result = value1 / value2; // This extra if-statement is because numbers can't be divided by 0, it messes with the code. So we're just returning 0 when that happens:
            else result = 0d;
            }
//      'q' for squaring
        else if (opCode == 'q')
            result = value1 * value1;
        else {
            result = 0.0d; // This runs if a char other than 'a', 's', 'm', etc. defined above is used.
            System.out.println("Invalid opCode: " + opCode);
        }
        System.out.println(result);

 */


/*
//      This calculation engine will take two values and returns a result.
//      Since in the above example, the same variable is used to run the if-statement, we can convert the statement to a switch statement pretty easily.

System.out.println("\nUsing a switch-statement to run a calculation engine.\n");
//      Just declaring some variables to work with here. This is basically our input field.
        double value1 = 100.0d;
        double value2 = 3.0d;
        double result = 0.0d;
        char opCode = 'd';

//      The first thing we do is declare this is a switch statement with the parameter of opCode.
        switch (opCode) {
//          First, in the case that the opCode is 'a', we will set the value of the result variable equal to the sum of the value1 and value2 variables, then use break to stop using the switch-statement.
            case 'a': result = value1 + value2; break;
            case 's': result = value1 - value2;
                break;
            case 'm':
                result = value1 * value2;
                break;
            case 'd':
                result = (value2 != 0) ? value1 / value2 : 0.0d; // Here we're just using a conditional statement which follows (condition) ? true-action : false-action;
                break;
            case 'q':
                result = value1 * value1;
                break;
            default:
                System.out.println(opCode + " is an invalid input.");
                result = 0.0d;
                break;
        }

        System.out.println(result);
 */




//      This calculation engine will take a range of values and returns a result.
//      Here, we will be using arrays to allow us to pick from several different calculations.
        double[] leftValues = {100, 25, 225, 11, 44};
        double[] rightValues = {50, 92, 17, 3, 44};
        char[] opCodes = {'d', 'a', 's', 'm', 'q'};
        double[] results = new double[opCodes.length]; // Here, we don't want to give results a value right now, bc that's what the calculation is for.

        for (int i = 0; i < opCodes.length; i++) {
            switch (opCodes[i]) {
                case 'a':
                    results[i] = leftValues[i] + rightValues[i];
                    break;
                case 's':
                    results[i] = leftValues[i] - rightValues[i];
                    break;
                case 'm':
                    results[i] = leftValues[i] * rightValues[i];
                    break;
                case 'd':
                    results[i] = rightValues[i] != 0 ? leftValues[i] / rightValues[i]: 0.0d;
                    break;
                case 'q':
                    results[i] = leftValues[i] * leftValues[i];
                    break;
                default:
                    System.out.println(opCodes[i] + " is an invalid input.");
                    results[i] = 0.0d;
                    break;
            }
        }
        for (double currentResult : results)
        System.out.println(currentResult);
    }
}
