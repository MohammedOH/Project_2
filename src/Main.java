import java.io.*;
import java.util.Scanner;

public class Main {
    /* Main method */
    public static void main(String[] args) throws FileNotFoundException {
        /* Input file to read data from it */
        File input = new File("test.txt");
        /* Scanner to read data from the file */
        Scanner readFile = new Scanner(input);
        /* PrintWriter to Print result in (output.txt) file */
        PrintWriter writer = new PrintWriter("output.txt");
        // No. of Tests must done
        final int TESTS = readFile.nextInt();
        // Array to store  result
        int[][] result = new int[30][30];

        int queries;
        // StringBuilder to read operation
        StringBuilder sb = new StringBuilder();
        // Looping throw each Test
        for (int i = 1; i <= TESTS; i++) {
            /* Creat matrix A and get it Filled*/
            int[][] A = getArray(readFile);
            /* Creat matrix B and get it Filled */
            int[][] B = getArray(readFile);
            // No. of operations must be done
            queries = readFile.nextInt();
            // Printing output
            writer.printf("Case #%d: \n", TESTS);
            readFile.nextLine();
            // Looping throw operations
            for (int j = 0; j < queries; j++) {
                // Reading one operation at a time
                String operation = sb.append(readFile.nextLine()).toString();
                // Cleaning StringBuilder
                sb.delete(0, sb.capacity());

                writer.println(operation);
                // Identifying operation
                result = doOperation(operation.trim(), A, B);
                // Printing result
                writer.print(printArray(result));
            }
            // Cleaning result array
            zero(result);
        }
        writer.close();
    }

    public static void getInput(int[][] list, Scanner input) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] = input.nextInt();
            }
        }
    }

    public static int[][] getArray(Scanner input) {
        int column = input.nextInt();
        int row = input.nextInt();
        int[][] result = new int[column][row];
        getInput(result, input);
        return result;
    }

    public static int[][] doOperation(String operation, int[][] A, int[][] B) {
        int[][] result = new int[30][30];

        switch (operation) {
            case "SUM A B":
                result = Operations.sum(A, B);
                break;
            case "SUBT A B":
                result = Operations.subt(A, B);
                break;
            case "SUBT B A":
                result = Operations.subt(B, A);
                break;
            case "MUL A B":
                result = Operations.mul(A, B);
                break;
            case "Transpose A":
                result = Operations.transpose(A);
                break;
            case "Transpose B":
                result = Operations.transpose(B);
                break;
            case "Det A":
                result = Operations.det(A);
                break;
            case "Det B":
                result = Operations.det(B);
                break;
            default:
                System.out.println("Invalid operation!");
        }
        return result;
    }

    public static int[][] zero(int[][] list) {
        // Looping throw array to clean it
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] = 0;
            }
        }
        return list;
    }


    public static String printArray(int[][] list) {
        StringBuilder sb = new StringBuilder();
        outer:
        for (int[] aList : list) {
            for (int anAList : aList) {
                if ((anAList == 0) && (aList[0] == 0)) {
                    continue outer;
                } else if (anAList == 0) {
                    sb.append("\n");
                    continue outer;
                }
                sb.append(anAList).append(" ");
            }
        }
        return (sb.toString());
    }

}