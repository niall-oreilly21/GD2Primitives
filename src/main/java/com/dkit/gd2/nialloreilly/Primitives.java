package com.dkit.gd2.nialloreilly;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Primitives
{
    public static void main( String[] args )
    {
        int score = 65535;
        int len = 32;

       // printBinary(score);

        //String binary = printByte(score, len);
        //System.out.println("The binary representation of " + score + " is " + binary);

        Scanner keyboard = new Scanner(System.in);

        final float WEIGHT_IN_POUNDS = 100f;
        final float WEIGHT_IN_KILOS = 100f;
        //investigateIntegers();
        //investigateBytes();
        //investigateShorts();
        //investigateLongs();
        //investigateFloats();
        //investigateDoubles();
        //investigateChars();
        //investigateBooleans();
        //investigateStrings();
        //testTypedDivision();


        // Converts pounds to kilos
        //System.out.printf("Weight in kg is %.1fkg \n\n" ,convertPoundsToKilos(WEIGHT_IN_POUNDS));

        System.out.printf("Your weight in kg is %.1fkg \n" , convertPoundsToKilos(getWeightInPounds1(keyboard)));
        System.out.printf("Your weight in kg is %.1fkg \n" , convertPoundsToKilos(getWeightInPounds2(keyboard)));


        //System.out.println("Please input weight in kg");
        //float weightInKilos = keyboard.nextFloat();

        // Convert kilos to pounds
        //System.out.printf("Your weight in pounds is %.1flb" ,convertKilosToPounds(WEIGHT_IN_KILOS));
    }

    /*TODO Fix the LBYLfunction so that it works - the solution will be similar tp */
    private static float getWeightInPounds1(Scanner keyboard)
    {
        float weightInPounds = Constants.INVALID_WEIGHT;
        System.out.print("Please input your weight in pounds > ");
        while(true)
        {
            if (keyboard.hasNextFloat())
            {
                weightInPounds = keyboard.nextFloat();
                if (weightInPounds <= 0)
                {
                    System.out.println(Colours.RED + "Please enter a weight that is greater than 0" + Colours.RESET);
                    continue;
                }
                if(weightInPounds > Float.MAX_VALUE)
                {
                    System.out.println(Colours.RED + "Value is too big. Please enter a value which is less than the float max" + Colours.RESET);
                    continue;
                }
                // Float max and min
            }
            else
            {
                System.out.println("Please enter a float");
                keyboard.next();
                continue;
            }
            return weightInPounds;
        }

    }

    /*TODO Fix this method so that it can handle blank input and space input*/
    private static float getWeightInPounds2(Scanner keyboard)
    {
        float weightInPounds = Constants.INVALID_WEIGHT;
        while(true)
        {
            try
            {
                System.out.print("Please input your weight in pounds > ");
                weightInPounds = Float.parseFloat(keyboard.nextLine());

                if(weightInPounds <= 0)
                {
                    throw new IllegalArgumentException("Please enter a weight that is greater than 0");
                }
                if(weightInPounds > Float.MAX_VALUE)
                {
                    throw new IllegalArgumentException("Value is too big");
                }
                    return weightInPounds;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println(Colours.RED + "Please enter a number" + Colours.RESET);
            }
            catch (IllegalArgumentException iae)
            {
                System.out.println(Colours.RED + iae.getMessage() + Colours.RESET);
            }
        }

    }

//    private  float getFloat(Scanner keyboard)
//    {
//        System.out.print("Please input your weight in pounds > ");
//        weightInPounds = keyboard.nextFloat();
//        return weightInPounds;
//    }

    private static float convertPoundsToKilos(float weight_in_pounds)
    {
        final float KILOS_IN_POUND = 0.45359237f;
        return weight_in_pounds * KILOS_IN_POUND;
    }

    private static float convertKilosToPounds(float weight_in_kilos)
    {
        final float POUNDS_IN_KILOS = 2.20462f;
        return weight_in_kilos * POUNDS_IN_KILOS;
    }

    private static void testTypedDivision()
    {
        int myIntValue = 5 / 3;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5d / 3d;

        System.out.println(myIntValue);
        System.out.println(myFloatValue);
        System.out.println(myDoubleValue);
    }

    private static void investigateStrings()
    {
        // A String is not a primitive type
        // It is a class

        String myString = "This is my String";
        System.out.println("The myString variable is " + myString);

        myString = myString + ", and this is more.";
        System.out.println(myString);

        myString += " \u00A9 2021";
        System.out.println(myString);

        String numberString = "20.99";
        numberString += "19.81";
        System.out.println(numberString);

        String lastString = "10";
        int myInt = 50;
        int convertedInt = Integer.parseInt(lastString);
        System.out.println(myInt + convertedInt);

        double doubleNumber = 128.47d;
        double convertedDouble = (double) (convertedInt);
        System.out.println(convertedDouble + doubleNumber);
    }

    private static void investigateBooleans()
    {
        boolean isOverEighteen = true;
        boolean isEmployed = false;
    }

    private static void investigateChars()
    {
        char myChar = 'A';
        char myUnicodeChar = '\u8844';
        System.out.println(myChar);
        System.out.println(myUnicodeChar);
        char copyRightChar = '\u00A9';
        System.out.println(copyRightChar);
    }

    private static void investigateDoubles()
    {
        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;

        double score = -5.5;
        System.out.println(score);

        System.out.println("Max is " + myMaxDoubleValue + "Min is "+ myMinDoubleValue);
    }

    private static void investigateFloats()
    {
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;

        float score = -5.5F;
        System.out.println(score);

        System.out.println("Max is " + myMaxFloatValue + "Min is "+ myMinFloatValue);
    }

    private static void investigateLongs()
    {
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;

        System.out.println(convertMaxLongToDays(myMaxLongValue));

        System.out.println("Max is " + myMaxLongValue + "Min is "+ myMinLongValue);

        long bigValue = 2_147_987_777L;
        System.out.println(bigValue);
    }

    private static long convertMaxLongToDays(long myMaxLongValue)
    {
        return myMaxLongValue / (24 * 60 * 60 * 1000 * 365);
    }

    private static void investigateShorts()
    {
        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;

        System.out.println("Max is " + myMaxShortValue + "Min is "+ myMinShortValue);
    }

    private static void investigateBytes()
    {
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;

        System.out.println("Max is " + myMaxByteValue + "Min is "+ myMinByteValue);
    }

    private static void printBinary(int score)
    {
        System.out.println(Integer.toBinaryString(score));
    }

    private static void investigateIntegers()
    {
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println(myMinIntValue - 1);
        System.out.println(myMaxIntValue + 1);
    }

    private static String printByte(int score, int len)
    {
        String binary = "";
        for (long i = (1L << len - 1); i > 0; i = i / 2)
        {
            binary = binary + ((score & i) != 0 ? "1" : "0");
        }
        return binary;

    }
}

/*
    int individualByte = score << 8;
        System.out.println(Integer.toBinaryString(i))*/
