package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultiplicationInterface extends Remote {

    int[][] MatrixMult(int A[][], int B[][])  throws RemoteException;
}
