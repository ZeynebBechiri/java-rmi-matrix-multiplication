package Client;

import Serveur.MultiplicationFactory;
import Serveur.MultiplicationInterface;

import java.io.DataInputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MatrixMultiplicationClient {

    public MatrixMultiplicationClient() {

    }

    public static int[][] assignMatrix(int row, int column) {
        int M[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(String.format("Entrez a[%d][%d] : ", i, j));
                Scanner sc = new Scanner(System.in);
                M[i][j] = sc.nextInt();
            }
        }
        return M;
    }

    public static void print(int M[][]) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print("[ " + M[i][j] + " ] ");
            }
            System.out.println("\n");
        }
    }



    public static void main(String args[]) {

        int A[][], B[][], row, column;
        int MAX = java.lang.Integer.MAX_VALUE;

        //if (args.length != 1)
        //{
         //   System.out.println("Exit!");
          //  System.exit(0);
        //}

        try {
            Registry var1 = LocateRegistry.getRegistry("localhost", 1099);
            MultiplicationFactory var2 = (MultiplicationFactory)var1.lookup("MultFactory");
            MultiplicationInterface var3 = var2.newMultiplication();

            System.out.println("First matrix: ");
            System.out.print("Row number:");
            Scanner sc = new Scanner(System.in);
            row = sc.nextInt();

            System.out.print("Column number:");
            column = sc.nextInt();
             A = assignMatrix(row,column);


            System.out.println("Second matrix: ");
            System.out.print("Row number:");
            row = sc.nextInt();

            System.out.print("Column number:");
            column = sc.nextInt();
            B = assignMatrix(row,column);



            int[][] C = var3.MatrixMult(A,B);
            print(C);


        } catch (Exception var7) {
            System.out.println("Erreur d'acces a l'objet distant.");
            System.out.println(var7.toString());
        }
    }
}
