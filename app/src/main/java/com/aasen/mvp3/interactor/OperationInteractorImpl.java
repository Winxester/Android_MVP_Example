package com.aasen.mvp3.interactor;

import com.aasen.mvp3.interfaces.OperationInteractor;
import com.aasen.mvp3.interfaces.OperationPresenter;
import com.aasen.mvp3.presenters.OperationPresenterImpl;

public class OperationInteractorImpl implements OperationInteractor {

    private int result;
    private OperationPresenter presenter;

    public OperationInteractorImpl(OperationPresenterImpl presenter) {
        this.presenter = presenter;
    }

    @Override
    public void add(int num1, int num2) {
        result = num1 + num2;
        presenter.showResult(String.valueOf(result));
    }

    @Override
    public void subtract(int num1, int num2) {
        result = num1 - num2;
        presenter.showResult(String.valueOf(result));
    }

    @Override
    public void multiply(int num1, int num2) {
        result = num1 * num2;
        presenter.showResult(String.valueOf(result));
    }

    @Override
    public void divide(int num1, int num2) {
        if (num2 != 0) {
            result = num1 / num2;
            presenter.showResult(String.valueOf(result));
        } else {
            presenter.invalidOperation();
        }
    }
}
