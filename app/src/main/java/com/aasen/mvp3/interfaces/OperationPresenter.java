package com.aasen.mvp3.interfaces;

public interface OperationPresenter {



    /**
     * VIEW Communication
     * @param result
     */
    void showResult(String result);

    void invalidOperation();

    /**
     * INTERACTOR Communication
     * @param num1
     * @param num2
     */
    void add(int num1, int num2);

    void substract(int num1, int num2);

    void multiply(int num1, int num2);

    void divide(int num1, int num2);

}
