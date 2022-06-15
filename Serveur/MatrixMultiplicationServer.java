package Serveur;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class MatrixMultiplicationServer {

    public MatrixMultiplicationServer() {

    }

    public static void main(String[] var0) {
        try {
            Registry var1 = LocateRegistry.createRegistry(1099);
            System.out.println("Serveur : Construction de l'implementation");
            MultiplicationFactoryImpl var2 = new MultiplicationFactoryImpl();
            System.out.println("Objet Fabrique lie dans le RMIregistry");
            var1.rebind("MultFactory", var2);
            System.out.println("Serveur prêt.");
            System.out.println("Attente des invocations des clients ...");
        } catch (Exception var3) {
            System.out.println("Erreur de liaison de l'objet Fabrique");
            System.out.println(var3.toString());
        }

    }
}
