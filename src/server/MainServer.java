package server;

import rmi.Calculator;
import rmi.CalculatorImp;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServer extends CalculatorImp {

    public final static int port = 1080;

    public MainServer() {

    }

    public static void main(String args[]) {
        try {
            // Instantiating the implementation class
            CalculatorImp cal = new CalculatorImp();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(cal, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.createRegistry(port);

            registry.bind("calculator", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
