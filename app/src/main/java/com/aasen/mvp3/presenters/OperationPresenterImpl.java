package com.aasen.mvp3.presenters;

import com.aasen.mvp3.interactor.OperationInteractorImpl;
import com.aasen.mvp3.interfaces.OperationPresenter;
import com.aasen.mvp3.views.OperationActivityView;

public class OperationPresenterImpl implements OperationPresenter {

    private OperationActivityView view;
    private OperationInteractorImpl interactor;

    public OperationPresenterImpl(OperationActivityView view) {
        this.view = view;
        this.interactor = new OperationInteractorImpl(this);
    }

    @Override
    public void showResult(String result) {
        if (view != null) {
            view.showResult(result);
        }
    }

    @Override
    public void invalidOperation() {
        if (view != null) {
            view.invalidOperation();
        }
    }

    @Override
    public void add(int num1, int num2) {
        if (interactor != null) {
            interactor.add(num1, num2);
        }
    }

    @Override
    public void substract(int num1, int num2) {
        if (interactor != null) {
            interactor.subtract(num1, num2);
        }
    }

    @Override
    public void multiply(int num1, int num2) {
        if (interactor != null) {
            interactor.multiply(num1, num2);
        }
    }

    @Override
    public void divide(int num1, int num2) {
        if (interactor != null) {
            interactor.divide(num1, num2);
        }
    }
}
