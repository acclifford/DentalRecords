import java.util.Scanner;

public class DentalRecords {
    //----------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);

    //----------------------------------------------------------------------------------
    public static void main(String[] args) {

        int numPeopleInFamily;

        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");
        System.out.print("Please enter number of people in the family : ");
        numPeopleInFamily = keyboard.nextInt();

        if (numPeopleInFamily <= 0 || numPeopleInFamily > 6) {
            do {
                System.out.print("Invalid number of people, try again   : ");
                numPeopleInFamily = keyboard.nextInt();
            } while (numPeopleInFamily <= 0 || numPeopleInFamily > 6);
        }
        String [] justNames = new String [numPeopleInFamily];
        String[][][] familyToothInfo = new String[numPeopleInFamily][2][8];

        for (int t = 0; t < justNames.length; ++t) {
            System.out.print("Please enter the name for family member " + (t + 1) + "   : ");
            justNames[t] = keyboard.next();

            System.out.print("\n");


                String typeTeethUpper = null;
                String typeTeethLower = null;


                System.out.print("Please enter the uppers for " + justNames[t] + "  : ");
                typeTeethUpper = keyboard.next();

                System.out.print("Please enter the lowers for " + justNames[t] + "  : ");
                typeTeethLower = keyboard.next();

                for (int k = 0; k < 8; ++k) {
                    familyToothInfo[t][0][k] = String.valueOf(typeTeethUpper.charAt(k));
                    familyToothInfo[t][1][k] = String.valueOf(typeTeethLower.charAt(k));

            }
        }

        String menuChoice;

        do {
            System.out.print("\n");
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it : ");
            menuChoice = keyboard.next();
            System.out.print("\n");

            switch (menuChoice) {
                case "P":
                    printChoice(familyToothInfo, justNames);
                    break;
                case "E":
                    extractChoice(familyToothInfo, justNames);
                    break;
                case "R":
                    rootChoice(familyToothInfo);
                    break;
                case "X":
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    break;
                default:
                    System.out.print("Invalid menu option, try again");
                    break;
            }
        } while (!menuChoice.equals("X"));
    }

    //----------------------------------------------------------------------------------
    private static void printChoice(String[][][] familyTeethInfo, String [] justNames) {

        //--Name
        //--Uppers: 1:_ 2:_ ex
        //--Lowers: 1:_ 2:_ ex

        for (int l = 0; l < familyTeethInfo.length; ++l) {
            System.out.println(justNames[l]);


                    System.out.print("   Uppers: ");
                    for (int n = 0; n < familyTeethInfo[l][0].length; ++n) {
                        System.out.print("  " + (n + 1) + ":" + familyTeethInfo[l][0][n]);
                    }
                    System.out.print("\n");
                    System.out.print("   Lowers: ");

                for (int n = 0; n < familyTeethInfo[l][0].length; ++n) {
                    System.out.print("  " + (n + 1) + ":" + familyTeethInfo[l][1][n]);
                }
            System.out.print("\n");
            }

    }

    //----------------------------------------------------------------------------------
    private static String[][][] extractChoice(String[][][] familyTeethInfo, String[] justNames) {

        String familyMember;
        String upperOrLower;
        int toothNumber;

        System.out.print("Which family member                 :");
        familyMember = keyboard.next();


        for (int x = 0; x < justNames.length; ++x){
            if (justNames[x].equals(familyMember)){


        for (int o = 0; o < familyTeethInfo.length; ++o) {
            if (justNames[o].equals(familyMember)) {
                System.out.print("Which tooth layer (U)pper or (L)ower       : ");
                upperOrLower = keyboard.next();
                switch (upperOrLower) {
                    case "U":
                        System.out.print("Which tooth number      : ");
                        toothNumber = keyboard.nextInt();

                        if (toothNumber < 8 && toothNumber > 0) {
                            if (familyTeethInfo[o][0][toothNumber - 1] != "M" || familyTeethInfo[o][0][toothNumber] != null) {
                                familyTeethInfo[o][0][toothNumber - 1] = "M";
                            } else {
                                System.out.print("Missing tooth, try again      : ");
                            }
                        } else {
                            System.out.print("Invalid tooth number, try again    :");
                            toothNumber = keyboard.nextInt();
                        }
                        break;
                    case "L":
                        System.out.print("Which tooth number      : ");
                        toothNumber = keyboard.nextInt();

                        if (toothNumber < 8 && toothNumber > 0) {
                            if (familyTeethInfo[o][1][toothNumber - 1] != "M" || familyTeethInfo[o][1][toothNumber] != null) {
                                familyTeethInfo[o][1][toothNumber - 1] = "M";
                            } else {
                                System.out.print("Missing tooth, try again      : ");
                            }
                        } else {
                            System.out.print("Invalid tooth number, try again    :");
                            toothNumber = keyboard.nextInt();
                        }
                        break;
                    default:
                        System.out.print("Invalid layer, try again        : ");
                        upperOrLower = keyboard.next();

                }

            } else {
                System.out.print("Invalid family member, try again              : ");
            }}}

        }
        return(familyTeethInfo);
    }
        //----------------------------------------------------------------------------------
        private static void rootChoice (String[][][]familyTeethInfo){

            int numOfIs = 0;
            int numOfBs = 0;
            int numOfMs = 0;
            double familyRootPositive;
            double familyRootNegative;
            String valueAtTooth;


            for (int p = 0; p < familyTeethInfo.length; ++p){
                for (int q = 0; q < familyTeethInfo[p].length; ++q){
                    for(int r = 0; r < familyTeethInfo[p][q].length; ++r){
                         valueAtTooth = familyTeethInfo[p][q][r];
                         switch (valueAtTooth){
                             case "B":
                                 numOfBs += 1;
                                 break;
                             case "I":
                                 numOfIs += 1;
                                 break;
                             case "M":
                                 numOfMs += 1;
                         }

                        }
                    }
                }
            familyRootPositive = (-(numOfBs) + Math.sqrt(Math.pow(numOfBs, 2) - (4 * numOfIs * numOfMs))) / (2 * numOfIs);
            familyRootNegative = (-(numOfBs) - Math.sqrt(Math.pow(numOfBs, 2) - (4 * numOfIs * numOfMs))) / (2 * numOfIs);

            System.out.println("One root canal at     " + familyRootPositive);
            System.out.println("Another root canal at " + familyRootNegative);
    }
    //----------------------------------------------------------------------------------
    }







