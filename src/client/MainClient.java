package client;

import rmi.Calculator;
import server.MainServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainClient {

    public MainClient() {

    }

    public static void main(String args[]) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry("localhost", MainServer.port);

            // Looking up the registry for the remote object
            Calculator stub = (Calculator) registry.lookup("calculator");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Inserte el primer numero: ");
            float a = Float.parseFloat(br.readLine());

            System.out.println("Inserte el segundo numero: ");
            float b = Float.parseFloat(br.readLine());

            // Calling the remote method using the obtained object
            float plusR = stub.plus(a, b);
            float minusR = stub.minus(a, b);
            float timesR = stub.times(a, b);
            float divideR = stub.divide(a, b);
            float moduleR = stub.module(a, b);

            System.out.println(String.format("The result of %.2f + %.2f is: %.2f", a, b, plusR));
            System.out.println(String.format("The result of %.2f - %.2f is: %.2f", a, b, minusR));
            System.out.println(String.format("The result of %.2f * %.2f is: %.2f", a, b, timesR));
            System.out.println(String.format("The result of %.2f / %.2f is: %.2f", a, b, divideR));
            System.out.println(String.format("The result of %.2f %% %.2f is: %.2f", a, b, moduleR));

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
