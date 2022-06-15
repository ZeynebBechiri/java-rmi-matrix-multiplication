package Serveur;

import javax.management.relation.RelationException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MultiplicationFactoryImpl extends UnicastRemoteObject implements MultiplicationFactory{

    public MultiplicationFactoryImpl() throws RemoteException {
    }

    @Override
    public MultiplicationInterface newMultiplication() throws RemoteException {
        return new Multiplication();
    }
}
