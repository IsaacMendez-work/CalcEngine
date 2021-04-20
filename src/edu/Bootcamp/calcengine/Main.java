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



/*
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
*/



/*
//      To improve the calculator engine, we will be breaking the switch out to its own method, so the code is cleaner, more reusable, and more coder-friendly.
//      The first thing to do it declare the arrays again.
        double[] leftVal = {100, 25, 225, 11, 5};
        double[] rightVal = {50, 92, 17, 3, 999};
        char[] opCode = {'d', 'a', 's', 'm', 'q'};
        double[] result = new double[opCode.length];

        for (int i = 0; i < opCode.length; i++) {
            result[i] = execute(opCode[i], leftVal[i], rightVal[i]);
        }
        for(double currentResult : result) System.out.println(currentResult);
    }

//      In its own class, we will have the switch statement.
    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = (rightVal != 0) ? leftVal / rightVal : 0.0d;
                break;
            case 'q':
                result = leftVal * leftVal;
                break;
            default:
                System.out.println(opCode + " is an invalid input.");
                result = 0.0d;
                break;
        }
        return result;
*/




//      Now we will set the CalcEngine to run in the command line, and to accept arguments (if provided).
//      First, we declare our arrays again.
        double[] leftVal = {100, 25, 225, 11};
        double[] rightVal = {50, 92, 17, 3};
        char[] opCode = {'d', 'a', 's', 'm'};
        double[] result = new double[opCode.length];

//      Next, we will have the code that was running in the above example run only if there are no arguments present. To do this, we will check the number of arguments, as declared in the "public static void main(String[] args) {...}" part of the program.
        if (args.length == 0) {
            for (int i = 0; i < opCode.length; i++) {
                result[i] = execute(opCode[i], leftVal[i], rightVal[i]);
        }
            for (double currentResult : result) System.out.println(currentResult);
        } else if (args.length == 3) handleCommandLine(args);
//      Here, we will be using a method we'll create below called handleCommandLine to run the app by opCode.
        else System.out.println("Please provide an operation code and 2 numeric values.\nNOTE: Operation codes are a for addition, s for subtraction, m for multiplication, and d for division.");
    }

//      Here we have the method for handling inputs in the command line.
    private static void handleCommandLine(String[] args) {
//      Since this method accepts an array of strings as defined by the String[] above, we will have to take the inputs, change them from strings to a char and two doubles so that the execute method below can use the switch statement to calculate the result.
        char opCode = args[0].charAt(0);
//      Here we are changing the first argument from the command line from a string to a char, then assigning that value to opCode.
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
//      This is one of Java's built-in functions. It changes the string into a double, and this will be for second and third arguments.

        double result = execute(opCode, leftVal, rightVal);
//      Here we are using the method below to assign the arguments and return a result. Lastly, we just print the result:
        System.out.println(result);
    }

//      TO USE THIS APPLICATION FROM THE COMMAND LINE:
//      First, be sure the calcengine has built. (In IntelliJ the shortcut is Ctrl F9, or Ctrl Fn F9 if your settings have Fn permanently on.
//      Second, open a terminal and navigate to your CalcEngine directory.
//      Third, change directories to the out folder, the production folder, and the CalcEngine folder.
//      Fourth, run: java edu.Bootcamp.calcengine.Main
//      To add args, just include them after the package name! try java edu.Bootcamp.calcengine.Main s 55 20 or java edu.Bootcamp.calcengine.Main d 99 3


//      Here we have the method for the switch that we'll be using to calculate.
    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = (rightVal != 0) ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println(opCode + " is an invalid input.");
                result = 0.0d;
                break;
        }
        return result;

    }
}
