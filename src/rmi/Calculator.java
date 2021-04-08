package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    float plus(float a, float b) throws RemoteException;
    float minus(float a, float b) throws RemoteException;
    float times(float a, float b) throws RemoteException;
    float divide(float a, float b) throws RemoteException;
    float module(float a, float b) throws RemoteException;
}
