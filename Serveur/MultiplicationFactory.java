package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultiplicationFactory extends Remote {

    MultiplicationInterface newMultiplication() throws RemoteException;
}
