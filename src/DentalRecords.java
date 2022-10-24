import java.util.Arrays;
import java.util.Scanner;

public class DentalRecords {
    //----------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);

    //----------------------------------------------------------------------------------
    public static void main(String[] args) {

        int numPeopleInFamily;

        //--Here is the introduction screen that prompts user for family size
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");
        System.out.print("Please enter number of people in the family : ");
        numPeopleInFamily = keyboard.nextInt();

        //--This loop causes the user to be forced to input a number within the domains
        if (numPeopleInFamily <= 0 || numPeopleInFamily > 6) {
            do {
                System.out.print("Invalid number of people, try again : ");
                numPeopleInFamily = keyboard.nextInt();
            } while (numPeopleInFamily <= 0 || numPeopleInFamily > 6);
        }

        //--I created two array, one 1D array to hold the names, and a 3D array for the teeth data
        String[] justNames = new String[numPeopleInFamily];
        String[][][] familyToothInfo = new String[numPeopleInFamily][2][];

        //--This loop prompts the user for the name of the family member
        //--The user is then prompted to enter the strings for the upper and lower teeth
        //--This loop ony allows for the user to put up to 8 teeth per upper/lower
        for (int t = 0; t < justNames.length; ++t) {
            System.out.print("Please enter the name for family member " + (t + 1) + "  : ");
            String familyMemberName = keyboard.next();
            familyMemberName = familyMemberName.toLowerCase();
            String firstLetter = familyMemberName.substring(0, 1).toUpperCase();
            String remainingLetters = familyMemberName.substring(1);
            familyMemberName = firstLetter + remainingLetters;
            justNames[t] = familyMemberName;


            String typeTeethUpper = null;
            String typeTeethLower = null;

            //--Here is where the string for the uppers is entered
            //--The mass block of text below keeps the user from inputting values that are not B, I, or M
            System.out.print("Please enter the uppers for " + justNames[t] + ": ");
            typeTeethUpper = keyboard.next();
            typeTeethUpper = typeTeethUpper.toUpperCase();

            if (typeTeethUpper.contains("A") || typeTeethUpper.contains("C") || typeTeethUpper.contains("D")
                    || typeTeethUpper.contains("E") || typeTeethUpper.contains("F") || typeTeethUpper.contains("G") ||
                    typeTeethUpper.contains("H") || typeTeethUpper.contains("J") || typeTeethUpper.contains("K")
                    || typeTeethUpper.contains("L") || typeTeethUpper.contains("N") || typeTeethUpper.contains("O") ||
                    typeTeethUpper.contains("P") || typeTeethUpper.contains("Q") || typeTeethUpper.contains("R") ||
                    typeTeethUpper.contains("S") || typeTeethUpper.contains("T") || typeTeethUpper.contains("U") ||
                    typeTeethUpper.contains("V") || typeTeethUpper.contains("W") || typeTeethUpper.contains("X") ||
                    typeTeethUpper.contains("Y") || typeTeethUpper.contains("Z")) {
                do {
                    System.out.print("Invalid teeth types, try again : ");
                    typeTeethUpper = keyboard.next();
                    typeTeethUpper = typeTeethUpper.toUpperCase();
                } while (typeTeethUpper.contains("A") || typeTeethUpper.contains("C") || typeTeethUpper.contains("D")
                        || typeTeethUpper.contains("E") || typeTeethUpper.contains("F") || typeTeethUpper.contains("G") ||
                        typeTeethUpper.contains("H") || typeTeethUpper.contains("J") || typeTeethUpper.contains("K")
                        || typeTeethUpper.contains("L") || typeTeethUpper.contains("N") || typeTeethUpper.contains("O") ||
                        typeTeethUpper.contains("P") || typeTeethUpper.contains("Q") || typeTeethUpper.contains("R") ||
                        typeTeethUpper.contains("S") || typeTeethUpper.contains("T") || typeTeethUpper.contains("U") ||
                        typeTeethUpper.contains("V") || typeTeethUpper.contains("W") || typeTeethUpper.contains("X") ||
                        typeTeethUpper.contains("Y") || typeTeethUpper.contains("Z"));
            }

            //--This loop prevents the user from inputting more than 8 values for teeth
            if (typeTeethUpper.length() > 8) {
                do {
                    System.out.print("Too many teeth, try again : ");
                    typeTeethUpper = keyboard.next();
                } while (typeTeethUpper.length() > 8);

            }

            //--This line initializes the size of the final portion of the array
            familyToothInfo[t][0] = new String[typeTeethUpper.length()];

            //--This loop takes the inputted string and assigns each character to the array
            for (int k = 0; k < typeTeethUpper.length(); ++k) {
                familyToothInfo[t][0][k] = String.valueOf(typeTeethUpper.charAt(k));
            }

            //--Here is where the string for the lowers is entered
            //--The mass block of text below keeps the user from inputting values that are not B, I, or M
            System.out.print("Please enter the lowers for " + justNames[t] + ": ");
            typeTeethLower = keyboard.next();
            typeTeethLower = typeTeethLower.toUpperCase();

            if (typeTeethLower.contains("A") || typeTeethLower.contains("C") || typeTeethLower.contains("D")
                    || typeTeethLower.contains("E") || typeTeethLower.contains("F") || typeTeethLower.contains("G") ||
                    typeTeethLower.contains("H") || typeTeethLower.contains("J") || typeTeethLower.contains("K")
                    || typeTeethLower.contains("L") || typeTeethLower.contains("N") || typeTeethLower.contains("O") ||
                    typeTeethLower.contains("P") || typeTeethLower.contains("Q") || typeTeethLower.contains("R") ||
                    typeTeethLower.contains("S") || typeTeethLower.contains("T") || typeTeethLower.contains("U") ||
                    typeTeethLower.contains("V") || typeTeethLower.contains("W") || typeTeethLower.contains("X") ||
                    typeTeethLower.contains("Y") || typeTeethLower.contains("Z")) {
                do {
                    System.out.print("Invalid teeth types, try again : ");
                    typeTeethLower = keyboard.next();
                    typeTeethLower = typeTeethLower.toUpperCase();
                } while (typeTeethLower.contains("A") || typeTeethLower.contains("C") || typeTeethLower.contains("D")
                        || typeTeethLower.contains("E") || typeTeethLower.contains("F") || typeTeethLower.contains("G") ||
                        typeTeethLower.contains("H") || typeTeethLower.contains("J") || typeTeethLower.contains("K")
                        || typeTeethLower.contains("L") || typeTeethLower.contains("N") || typeTeethLower.contains("O") ||
                        typeTeethLower.contains("P") || typeTeethLower.contains("Q") || typeTeethLower.contains("R") ||
                        typeTeethLower.contains("S") || typeTeethLower.contains("T") || typeTeethLower.contains("U") ||
                        typeTeethLower.contains("V") || typeTeethLower.contains("W") || typeTeethLower.contains("X") ||
                        typeTeethLower.contains("Y") || typeTeethLower.contains("Z"));
            }


            //--This loop prevents the user from inputting more than 8 values for teeth
            if (typeTeethLower.length() > 8) {
                do {
                    System.out.print("Too many teeth, try again : ");
                    typeTeethLower = keyboard.next();
                } while (typeTeethLower.length() > 8);
            }

            //--This line initializes the size of the final portion of the array
            familyToothInfo[t][1] = new String[typeTeethLower.length()];


            //--This loop takes the inputted string and assigns each character to the array
            for (int k = 0; k < typeTeethLower.length(); ++k) {
                familyToothInfo[t][1][k] = String.valueOf(typeTeethLower.charAt(k));
            }

        }

        String menuChoice;


        //--Here, the user is prompted to select one of four menu items
        //--This loop will continue to run until the exit selection is made
        do {
            System.out.print("\n");
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it : ");
            menuChoice = keyboard.next();
            menuChoice = menuChoice.toUpperCase();


            if (!(menuChoice.contains("P") || !menuChoice.contains("E") || !menuChoice.contains("R")
                    || !menuChoice.contains("X"))) {
                do {
                    System.out.print("Invalid menu option, try again : ");
                    menuChoice = keyboard.next();
                    menuChoice = menuChoice.toUpperCase();

                } while ((!menuChoice.contains("P") || !menuChoice.contains("E") || !menuChoice.contains("R")
                        || !menuChoice.contains("X")));

            }

            //--Many of the menu choices will send tha data down to a method for processing an output
            if (menuChoice.equals("P")) {
                printChoice(familyToothInfo, justNames);
            }
            if (menuChoice.equals("E")) {
                extractChoice(familyToothInfo, justNames);
            }
            if (menuChoice.equals("R")) {
                rootChoice(familyToothInfo);
            }
            if (menuChoice.equals("X")) {
                //--This is the final out print of the program
                System.out.println("\nExiting the Floridian Tooth Records :-)");
            }


        } while (!menuChoice.equals("X"));
    }

    //----------------------------------------------------------------------------------
    private static void printChoice(String[][][] familyTeethInfo, String[] justNames) {

        //--The printChoice method prints out the data in a neat way, like below
        //--Name
        //--Uppers: 1:_ 2:_ ex
        //--Lowers: 1:_ 2:_ ex

        System.out.print("\n");
        for (int l = 0; l < familyTeethInfo.length; ++l) {
            System.out.println(justNames[l]);

            //--This loop takes each upper tooth and puts it next to its corresponding number
            System.out.print("   Uppers: ");
            for (int n = 0; n < familyTeethInfo[l][0].length; ++n) {
                System.out.print("  " + (n + 1) + ":" + familyTeethInfo[l][0][n]);
            }

            //--This loop takes each lower tooth and puts it next to its corresponding number
            System.out.print("\n");
            System.out.print("   Lowers: ");

            for (int n = 0; n < familyTeethInfo[l][1].length; ++n) {
                System.out.print("  " + (n + 1) + ":" + familyTeethInfo[l][1][n]);
            }
            System.out.print("\n");
        }

    }

    //----------------------------------------------------------------------------------
    private static String[][][] extractChoice(String[][][] familyTeethInfo, String[] justNames) {

        //--The extractChoice method allows the user to select a tooth from one of the family members to extract
        //--The method does not allow teeth that are already missing or that our out or range to be extracted

        String familyMember;
        String upperOrLower = null;
        int toothNumber;

        //--User is prompted to input one of the prior names
        System.out.print("Which family member : ");
        familyMember = keyboard.next();
        familyMember = familyMember.toLowerCase();
        String firstLetter = familyMember.substring(0, 1).toUpperCase();
        String remainingLetters = familyMember.substring(1);
        familyMember = firstLetter + remainingLetters;



        //-This loop goes through the array to see which data the name corresponds to
        if (!Arrays.stream(justNames).anyMatch(familyMember::equals)) {
            do {
                System.out.print("Invalid family member, try again : ");
                familyMember = keyboard.next();
                familyMember = familyMember.toLowerCase();
                firstLetter = familyMember.substring(0, 1).toUpperCase();
                remainingLetters = familyMember.substring(1);
                familyMember = firstLetter + remainingLetters;
            } while (!Arrays.stream(justNames).anyMatch(familyMember::equals));
        }


        int w = 0;

        //--If the name is present, this loop figures out at which point the name is in the array
        if (!justNames[w].equals(familyMember)) {
            do {
                w += 1;
            } while (!justNames[w].equals(familyMember));
        }

        //--The user is prompted to extract from the upper or lower teeth
        if (justNames[w].equals(familyMember)) {
            System.out.print("Which tooth layer (U)pper or (L)ower : ");
            upperOrLower = keyboard.next();
            upperOrLower = upperOrLower.toUpperCase();

            //--this loop sets off if a layer that doesn't exist is selected
                /*do{
                System.out.print("Invalid layer, try again : ");
                upperOrLower = keyboard.next();
                upperOrLower = upperOrLower.toUpperCase();
            } while (!upperOrLower.contains("L") || !upperOrLower.contains("U"));
            */


            //--if the user selects upper, the data will be taken through this loop
            if (upperOrLower.equals("U")) {
                System.out.print("Which tooth number      : ");
                toothNumber = keyboard.nextInt();

                //--if the tooth number selected doesn't exist, the user will be prompted to enter again
                if (toothNumber > familyTeethInfo[w][0].length || toothNumber < 0) {
                    do {
                        System.out.print("Invalid tooth number, try again       : ");
                        toothNumber = keyboard.nextInt();
                    } while (toothNumber > 8 || toothNumber < 0);
                }
                if (toothNumber < familyTeethInfo[w][0].length && toothNumber > 0) {

                    //--if the tooth is already missing, the user will be prompted to enter again
                    if (familyTeethInfo[w][0][toothNumber - 1].equals("M")) {
                        do {
                            System.out.print("Missing tooth, try again      : ");
                            toothNumber = keyboard.nextInt();
                        } while (familyTeethInfo[w][0][toothNumber - 1].equals("M"));
                    }

                    //--if the tooth is not missing, it is extracted
                    if (!familyTeethInfo[w][0][toothNumber - 1].equals("M")) {
                        familyTeethInfo[w][0][toothNumber - 1] = "M";
                    }
                }
            }
            //--if the user selects lower, the data will be taken through this loop
            if (upperOrLower.equals("L")) {
                System.out.print("Which tooth number      : ");
                toothNumber = keyboard.nextInt();

                //--if the tooth number selected doesn't exist, the user will be prompted to enter again
                if (toothNumber > 8 || toothNumber < 0) {
                    do {
                        System.out.print("Invalid tooth number, try again       : ");
                        toothNumber = keyboard.nextInt();
                    } while (toothNumber > 8 || toothNumber < 0);

                    if (toothNumber < 8 && toothNumber > 0) {

                        //--if the tooth is already missing, the user will be prompted to enter again
                        if (familyTeethInfo[w][1][toothNumber - 1].equals("M")) {
                            do {
                                System.out.print("Missing tooth, try again      : ");
                                toothNumber = keyboard.nextInt();
                            } while (familyTeethInfo[w][1][toothNumber - 1].equals("M"));
                            familyTeethInfo[w][1][toothNumber - 1] = "M";
                        }
                        //--if the tooth is not missing, it is extracted
                        if (!familyTeethInfo[w][1][toothNumber - 1].equals("M")) {
                            familyTeethInfo[w][1][toothNumber - 1] = "M";
                        }
                    }

                }


            }
        }

        //--The changes to the array are sent back
        return(familyTeethInfo);
}
        //----------------------------------------------------------------------------------
        private static void rootChoice (String[][][]familyTeethInfo){

            //--The rootChoice method calculates the square roots based off the following equation:
            //-- Ix^2 + Bx - M
            //--The calculations will produce a positive and negative answer;

            int numOfIs = 0;
            int numOfBs = 0;
            int numOfMs = 0;
            double familyRootPositive;
            double familyRootNegative;
            String valueAtTooth;

            //--This loop goes through all the values of the array and add up the numbers of B's, I's, and M's
            for (int p = 0; p < familyTeethInfo.length; ++p) {
                for (int q = 0; q < familyTeethInfo[p].length; ++q) {
                    for (int r = 0; r < familyTeethInfo[p][q].length; ++r) {
                        valueAtTooth = familyTeethInfo[p][q][r];
                        if (valueAtTooth.equals("B")){
                            numOfBs +=  1;
                        }
                        if (valueAtTooth.equals("I")){
                            numOfIs += 1;
                        }
                        if (valueAtTooth.equals("M")){
                            numOfMs += 1;
                        }
                    }
                }
            }

            //--Using the found totals, we can calcualtes the two roots of the equation
            familyRootPositive = ((numOfBs * -1) + (Math.sqrt((Math.pow(numOfBs, 2)) + (4 * numOfIs * numOfMs))) )/ (2 *numOfIs);
            familyRootNegative = ((numOfBs * -1) - (Math.sqrt((Math.pow(numOfBs, 2)) + (4 * numOfIs * numOfMs ))) )/ (2 *numOfIs);

            //--Out printing of the two roots
            System.out.printf("One root canal at %.2f\n", familyRootPositive);
            System.out.printf("Another root canal at %.2f\n", familyRootNegative);

        }
        //----------------------------------------------------------------------------------
    }








