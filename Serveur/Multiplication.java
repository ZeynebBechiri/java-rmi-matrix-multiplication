package Serveur;

import javax.management.relation.RelationException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Multiplication extends UnicastRemoteObject implements MultiplicationInterface {

    public static int MAX = java.lang.Integer.MAX_VALUE;
    int M1[][], M2[][];

    public Multiplication() throws RemoteException {
        super();
    }


    @Override
    public int[][] MatrixMult(int[][] A, int[][] B) throws RemoteException {
        int C[][] = new int[A.length][B[0].length];

        try {
            Thread.sleep(40000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (A[0].length != B.length) {
            C[0][0] = MAX;
        }

        else {

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = 0;
                    for (int k = 0; k < A[0].length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                    //System.out.print(C[i][j] + " ");
                }
            }
        }
        return C;
    }
}

