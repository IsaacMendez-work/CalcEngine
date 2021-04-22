package edu.Bootcamp.CalcEngine;
import java.util.Scanner;

public class Main {

/*
    public static void main(String[] args) {
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
    public static void main(String[] args) {
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
    public static void main(String[] args) {
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
    public static void main(String[] args) {
//      To improve the calculator engine, we will be breaking the switch out to its own method, so the code is cleaner, more reusable, and more coder-friendly.
//      The first thing to do it declare the arrays again.
        double[] leftVal = {100, 25, 225, 11, 5};
        double[] rightVal = {50, 92, 17, 3, 999};
        char[] opCode = {'d', 'a', 's', 'm', 'q'};
        double[] result = new double[opCode.length];

        for (int i = 0; i < opCode.length; i++) {
            result[i] = executeUserInput(opCode[i], leftVal[i], rightVal[i]);
        }
        for(double currentResult : result) System.out.println(currentResult);
    }

//      In its own class, we will have the switch statement.
    static double executeUserInput(char opCode, double leftVal, double rightVal) {
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



/*
    public static void main(String[] args) {
//      Now we will set the CalcEngine to run in the command line, and to accept arguments (if provided).
//      First, we declare our arrays again.
        double[] leftVal = {100, 25, 225, 11};
        double[] rightVal = {50, 92, 17, 3};
        char[] opCode = {'d', 'a', 's', 'm'};
        double[] result = new double[opCode.length];

//      Next, we will have the code that was running in the above example run only if there are no arguments present. To do this, we will check the number of arguments, as declared in the "public static void main(String[] args) {...}" part of the program.
        if (args.length == 0) {
            for (int i = 0; i < opCode.length; i++) {
                result[i] = executeUserInput(opCode[i], leftVal[i], rightVal[i]);
        }
            for (double currentResult : result) System.out.println(currentResult);
        } else if (args.length == 3) handleCommandLine(args);
//      Here, we will be using a method we'll create below called handleCommandLine to run the app by opCode.
        else System.out.println("Please provide an operation code and 2 numeric values.\nNOTE: Operation codes are a for addition, s for subtraction, m for multiplication, and d for division.");
    }

//      Here we have the method for handling inputs in the command line.
    private static void handleCommandLine(String[] args) {
//      Since this method accepts an array of strings as defined by the String[] above, we will have to take the inputs, change them from strings to a char and two doubles so that the executeUserInput function can use the switch statement to calculate the result.
        char opCode = args[0].charAt(0);
//      Here we are changing the first argument from the command line from a string to a char, then assigning that value to opCode.
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
//      This is one of Java's built-in functions. It changes the string into a double, and this will be for second and third arguments.

        double result = executeUserInput(opCode, leftVal, rightVal);
//      Here we are using the method below to assign the arguments and return a result. Lastly, we just print the result:
        System.out.println(result);
    }

//      TO USE THIS APPLICATION FROM THE COMMAND LINE:
//      First, be sure the CalcEngine has built. (In IntelliJ the shortcut is Ctrl F9, or Ctrl Fn F9 if your settings have Fn permanently on.
//      Second, open a terminal and navigate to your CalcEngine directory.
//      Third, change directories to the out folder, the production folder, and the CalcEngine folder.
//      Fourth, run: java edu.Bootcamp.CalcEngine.Main
//      To add args, just include them after the package name! Try java edu.Bootcamp.CalcEngine.Main s 55 20 or java edu.Bootcamp.CalcEngine.Main d 99 3


//      Here we have the method for the switch that we'll be using to calculate.
    static double executeUserInput(char opCode, double leftVal, double rightVal) {
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
*/



/*
//      In this step, we will be adding String-capabilities to the CalcEngine. Specifically, we'll be adding a method (in addition to the first method that loops through the predetermined set of arrays, and the second method that allows a user to input an opCode and two numeric values from the command line to run the app).
//      This third method will allow the user to input full operation names rather than the opCode. Also, add a fourth function to allow the use of some numbers in word form.

    public static void main(String[] args) {
//      First, we declare our arrays for the first method's use:
        double[] leftVal = {100, 25, 225, 11};
        double[] rightVal = {50, 92, 17, 3};
        char[] opCode = {'d', 'a', 's', 'm'};
        double[] result = new double[opCode.length];

//      Here is the first method, if the user provides no arguments:
        if (args.length == 0) {
            for (int i = 0; i < opCode.length; i++) {
                result[i] = executeUserInput(opCode[i], leftVal[i], rightVal[i]);
            }
            for (double currentResult : result) System.out.println(currentResult);

//      Here is the second method, if the user provides three arguments:
        } else if (args.length == 3) {
            handleCommandLine(args);

//      Here is the third method, the one for using Strings:
        } else if (args.length == 1 && args[0].equalsIgnoreCase("INterACTive")) {
            executeInteractively();
//      To use Strings, we'll need to use the executeInteractively method below, and we'll run that if the user input is the word "interactive"

        } else System.out.println("Please provide an operation code and 2 numeric values.\nNOTE: Operation codes are a for addition, s for subtraction, m for multiplication, and d for division.");
//      NOTE: To run this, we can do so in the command line as specified in the previous example of the calculator, but we can also add arguments in IntelliJ by selecting Run from the menu above, selecting Edit Configurations..., and adding arguments to the Program Arguments field. Then just run the program.


    }



//      Function one's code:
    static double executeUserInput(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
            case 'a': result = leftVal + rightVal; break;
            case 's': result = leftVal - rightVal; break;
            case 'm': result = leftVal * rightVal; break;
            case 'd': result = (rightVal != 0) ? leftVal / rightVal : 0.0d; break;
            default: System.out.println(opCode + " is an invalid input."); result = 0.0d; break;
        }
        return result;
    }



//      Function two's code:
    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = executeUserInput(opCode, leftVal, rightVal);
        System.out.println(result);
    }



//      Function three's code:
//      The first thing to do there is to translate the words the user will input into words that Java can understand. For example, we'll need to convert the word "multiply" to an opCode.
    static char opCodeFromString(String operationName) {
//      This first line is us adding a function named opCodeFromString whose return type is a char (since the return will have to be an opCode, and they are all chars). The function will accept a single String as the parameter, which we'll call operationName.

//      The next thing we'll need to do is populate the body of the function. In this case, we're going to start by taking the String we receive and converting it to the opCode variable defined in the first function.
//      There are a variety of ways to do this, and my first impulse was to convert whole words like "addition" and "add" and "adding" equal to the opCode 'a', but there's an easier way in this situation. We can just pull the first letter of the word and use that to determine which opCode to set it equal to:
        char firstChar = operationName.charAt(0); // This is a zero-point index!!
//      Lastly, we need to return the first character of the String, which should be the same as the opCode.
        return firstChar;
//      NOTE: Since the only thing we did in this function was declare a variable and return that variable, this method's body could be simplified to "return operationName.charAt(0);". However, for the sake of clarity, we're doing this the long way.
    }


//      Function four's code:
//      Similarly to function three, if we want to convert words to numbers we're going declare function, we need to declare a static function and be sure it's a double (since method one's code is set to accept doubles).
    static double valueFromWord(String wordNumber) {
//      There are many ways convert words to numbers, but in this case we'll just use the first ten numbers for, and we'll define them in an array.
        String[] wordNumberArray = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
//      Since arrays are zero-based, and we started out array at "zero", instead of comparing wordNumberArray to a second array we will just assign the value of wordNumberArray to their corrisponding place in the zero-based array. ("zero" is [0], "one" is [1], etc.)
        double value = 0d;
        for (int index = 0; index < wordNumberArray.length; index++) { // This has us loop through the array until we come to the word the user typed
            if (wordNumber.equals(wordNumberArray[index])) {
                value = index;
                // Here we declare that is the value of the input is the same as its position in the array (again, "seven" = [7]), then we will exit the loop.
                break;
            }
        }
        return value;
    }


//  Method five's code:
    static void executeInteractively() {
//      This will be interacting with the user, so the first thing we should do is print out a message with instructions.
        System.out.println("Enter an operation and two numbers: ");
//      Above, we used Java's built-in System.out method to send information to the user. We could use Java's built-in System.in method to receive information from the user, but a more convenient (less work for us) thing to do is to use a type called Scanner.
//      To use Scanner, right under our package (located on line 1), we're going to import Scanner capability by typing in import java.util.Scanner;
//      After doing that, we can return here to our code and use Scanner the same way we use String.
        Scanner firstScanner = new Scanner(System.in);
//      What we've done here is use Scanner to take care of the details of System.in so we can get the input from the user.
//      Next, we can set Scanner to read all the input from the user until it reaches the end of the line (in most cases, until the Enter key is pressed) by using firstScanner.nextLine();
        String userInput = firstScanner.nextLine();
//      Here we've taken the input from the user (using the expression on the right) ad set it equal to a String named userInput.

//      Next, we want to break apart userInput so that something like "subtract three five" is broken in to one word we can use to find an opCode and two words we can use to get our integers. In that example, the char dividing the words is the space between "subtract" and "three" and "five".
        String[] partsArray = userInput.split(" ");
//      Here, we've split what the user inputs based on the spaces between words. This will return a String array.

        performOperation(partsArray);
//      Lastly, we'll be want to use partsArray to use those the three split inputs to perform an operation. For that, we're going to need another method.
    }


//  Method six's code:
    private static void performOperation(String[] partsArray) {
//      Example user input: divide nine three
        char operationFromArray = opCodeFromString(partsArray[0]);
//      Here we're taking the first word in the partsArray, running it through our opCodeFromString function to figure out what opCode "divide" is for, then setting it equal to a char variable.

        double leftValFromArray = valueFromWord(partsArray[1]);
//      Here we're taking the second word in the partsArray, running it through valueFromWord to figure out what number "nine" is, then setting that value equal to a double variable.
        double rightValFromArray = valueFromWord(partsArray[2]);
//      Here we are doing the same as in leftValFromArray

//        Now that we have an equivalent to the char opCode, double leftVal, and double rightVal that we needed to use function one's code, we just need to run it through that method!
        double result = executeUserInput(operationFromArray, leftValFromArray, rightValFromArray);

        System.out.println(result);
    }
*/




//      Here, we will be providing the users with some context of the information we're printing out, rather just accept input and display a result. (For example, the whole equation)
    public static void main(String[] args) {
        double[] leftVal0 = {100, 25, 225, 11};
        double[] rightVal0 = {50, 92, 17, 3};
        char[] opCode0 = {'d', 'a', 's', 'm'};
        double[] result0 = new double[opCode0.length];

//      Here is the first method, if the user provides no arguments:
        if (args.length == 0) {
            for (int index0 = 0; index0 < opCode0.length; index0++) {
                result0[index0] = executeUserInput(opCode0[index0], leftVal0[index0], rightVal0[index0]);
            }
            for (double currentResult : result0)
                System.out.println(currentResult);

//      Here is the second method, if the user provides three arguments:
        } else if (args.length == 3) {
            handleCommandLine(args);

//      Here is the third method, if the user provides "Interactive" as the argument:
        } else if (args.length == 1 && args[0].equalsIgnoreCase("INterACTive")) {
            executeInteractively();
//          To use executeInteractively, both the operation and the numbers must be in word form.

        } else System.out.println("Please provide an operation code and 2 numeric values.");
    }



//      Function one's code:
    static double executeUserInput(char opCode1, double leftVal1, double rightVal1) {
        double result1;
        switch (opCode1) {
            case 'a': result1 = leftVal1 + rightVal1; break;
            case 's': result1 = leftVal1 - rightVal1; break;
            case 'm': result1 = leftVal1 * rightVal1; break;
            case 'd': result1 = (rightVal1 != 0) ? leftVal1 / rightVal1 : 0.0d; break;
            default: System.out.println(opCode1 + " is an invalid input."); result1 = 0.0d; break;
        }
        return result1;
    }



//      Function two's code:
    private static void handleCommandLine(String[] args) {
        char opCode2 = args[0].charAt(0);
        double leftVal2 = Double.parseDouble(args[1]);
        double rightVal2 = Double.parseDouble(args[2]);
        double result2 = executeUserInput(opCode2, leftVal2, rightVal2);
        System.out.println(result2);
    }



//      Function three's code:
    static char opCodeFromString(String operationName) {
        char opCode3 = operationName.charAt(0);
        return opCode3;
    }



//      Function four's code:
    static double valueFromWord(String word) {
        String[] numberWord = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        double value4 = 0d;
        for (int index4 = 0; index4 < numberWord.length; index4++) {
            if (word.equals(numberWord[index4])) {
                value4 = index4;
                break;
            }
        }
        return value4;
    }


//      Method five's code:
    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers in words: ");
        Scanner scan5 = new Scanner(System.in);
        String userInput5 = scan5.nextLine();
        String[] partsArray5 = userInput5.split(" ");
        performOperation(partsArray5);
    }


//      Method six's code:
    private static void performOperation(String[] partsArray6) {
        char opCode6 = opCodeFromString(partsArray6[0]);
        double leftVal6 = valueFromWord(partsArray6[1]);
        double rightVal6 = valueFromWord(partsArray6[2]);
        double result6 = executeUserInput(opCode6, leftVal6, rightVal6);
//      Rather than using the System.out.println(result) like we were before, we're going to use a method that converts the opCode array to the operation's symbol.
        displayResult(opCode6, leftVal6, rightVal6, result6);
    }


//      Method seven's code:
    private static char symbolFromOpCode(char operationSymbol) {
        char[] opCodeArray7 = {'a', 's', 'm', 'd'};
        char[] symbolArray7 = {'+', '-', '*', '/'};
//      The two above arrays are parallel arrays
        char symbol7 = ' ';
        for (int index7 = 0; index7 < opCodeArray7.length; index7++) {
            if (operationSymbol == opCodeArray7[index7]) {
                symbol7 = symbolArray7[index7];
                break;
            }
        }
        return symbol7;
    }



//      Method eight's code:
    private static void displayResult(char opCode8, double leftVal8, double rightVal8, double result8) {
//      First we'll translate the symbol to char using the above function:
        char symbol8 = symbolFromOpCode(opCode8);
        StringBuilder builder8 = new StringBuilder(20);
        builder8.append(leftVal8); // This is a double
        builder8.append(" "); // This is a String
        builder8.append(symbol8); // This is a char
        builder8.append(" "); // This is a String
        builder8.append(rightVal8); // This ia double
        builder8.append(" = "); // This is a String
        builder8.append(result8); // This is a double
//      Using StringBuilder means we don't need to convert everything to a string before we use it, which saves time and compiling time.
//      Note, however, that StringBuilder is not itself a string, so we have to set its value equal to a String variable, then call that variable:
        String output8 = builder8.toString();
        System.out.println(output8);
    }



}
