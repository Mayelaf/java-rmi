package rmi;

import java.rmi.RemoteException;

public class CalculatorImp implements Calculator {
    @Override
    public float plus(float a, float b) throws RemoteException {
        return a + b;
    }

    @Override
    public float minus(float a, float b) throws RemoteException {
        return a - b;
    }

    @Override
    public float times(float a, float b) throws RemoteException {
        return a * b;
    }

    @Override
    public float divide(float a, float b) throws RemoteException {
        return a / b;
    }

    @Override
    public float module(float a, float b) throws RemoteException {
        return a % b;
    }
}
