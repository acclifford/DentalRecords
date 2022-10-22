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

        String[][][] familyToothInfo = new String[numPeopleInFamily][2][8];

        for (int i = 0; i < familyToothInfo.length; ++i) {
            System.out.print("Please enter the name for family member " + (i + 1) + "   : ");
            familyToothInfo[i] = keyboard.nextLine();
            System.out.print(familyToothInfo[i]);

            for (int j = 0; j < familyToothInfo[i].length; ++j) {
                String typeTeeth;

                if (j < 1) {
                    System.out.print("Please enter the uppers for " + familyToothInfo[i] + "  : ");
                    typeTeeth = keyboard.nextLine();
                } else {
                    System.out.print("Please enter the lowers for " + familyToothInfo[i] + "  : ");
                    typeTeeth = keyboard.nextLine();
                }

                for (int k = 0; k < 8; ++k) {
                    familyToothInfo[i][j][k] = String.valueOf(typeTeeth.charAt(k));
                }
            }
        }

        String menuChoice;

        System.out.print("\n");
        System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it");
        menuChoice = keyboard.nextLine();

        switch (menuChoice) {
            case "P":
                printChoice(familyToothInfo);
                break;
            case "E":
                familyToothInfo = extractChoice(familyToothInfo);
                break;
            case "R":
                rootChoice(familyToothInfo);
                break;
            case "X":
                System.out.println("Exiting the Floridian Tooth Records :-)");
                break;
            default:
                System.out.println("Invalid menu option, try again : ");
        }

        do {
            System.out.print("\n");
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it");
            menuChoice = keyboard.nextLine();

            switch (menuChoice) {
                case "P":
                    printChoice(familyToothInfo);
                    break;
                case "E":
                    extractChoice(familyToothInfo);
                    break;
                case "R":
                    rootChoice(familyToothInfo);
                    break;
                case "X":
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    break;
                default:
                    System.out.println("Invalid menu option, try again : ");
            }
        } while (menuChoice != "X");

    }

    //----------------------------------------------------------------------------------
    private static void printChoice(String[][][] familyTeethInfo) {

        //--Name
        //--Uppers: 1:_ 2:_ ex
        //--Lowers: 1:_ 2:_ ex

        for (int l = 0; l < familyTeethInfo.length; ++l) {
            System.out.println(familyTeethInfo[l]);
            for (int m = 0; m < familyTeethInfo[l].length; ++m) {
                if (m < 1) {
                    System.out.print("Uppers: ");
                    for (int n = 0; n < familyTeethInfo[l][m].length; ++n) {
                        System.out.print("  " + (n + 1) + familyTeethInfo[l][m][n]);
                    }
                } else {
                    System.out.print("Lowers: ");
                }
                for (int n = 0; n < familyTeethInfo[l][m].length; ++n) {
                    System.out.print("  " + (n + 1) + familyTeethInfo[l][m][n]);
                }
            }
        }
    }

    //----------------------------------------------------------------------------------
    private static String[][][] extractChoice(String[][][] familyTeethInfo) {

        String familyMember;
        String upperOrLower;
        int toothNumber;

        System.out.print("Which family member                 :");
        familyMember = keyboard.nextLine();

        for (int o = 0; o < familyTeethInfo.length; ++o) {
            if (familyTeethInfo[o].equals(familyMember)) {
                System.out.print("Which tooth layer (U)pper or (L)ower       : ");
                upperOrLower = keyboard.next();
                switch (upperOrLower) {
                    case "U":
                        System.out.print("Which tooth number      : ");
                        toothNumber = keyboard.nextInt();

                        if (toothNumber < 8 && toothNumber > 0) {
                            if (familyTeethInfo[o][0][toothNumber - 1] != "M" || familyTeethInfo[o][1][toothNumber] != null) {
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
            }

        }
        return(familyTeethInfo);
    }
        //----------------------------------------------------------------------------------
        private static void rootChoice (String[][][]familyTeethInfo){

            int numOfIs;
            int numOfBs;
            int numOfMs;


            for (int p = 0; p < familyTeethInfo.length; ++p){
            
        }


        }

        //----------------------------------------------------------------------------------


}




