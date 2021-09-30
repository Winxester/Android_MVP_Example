package com.aasen.mvp3.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aasen.mvp3.R;
import com.aasen.mvp3.interfaces.OperationPresenter;
import com.aasen.mvp3.interfaces.OperationView;
import com.aasen.mvp3.presenters.OperationPresenterImpl;

public class OperationActivityView extends AppCompatActivity implements OperationView {

    private EditText et_num1, et_num2;
    private int[] myNumbers;
    private TextView tv_result;
    private Button btn_add, btn_subtract, btn_multiply, btn_divide;
    private OperationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        presenter = new OperationPresenterImpl(this);

        et_num1 = findViewById(R.id.txtNumber1);
        et_num2 = findViewById(R.id.txtNumber2);
        tv_result = findViewById(R.id.txtResult);
        btn_add = findViewById(R.id.button_add);
        btn_subtract = findViewById(R.id.button_subtract);
        btn_multiply = findViewById(R.id.button_multiply);
        btn_divide = findViewById(R.id.button_divide);


        btn_add.setOnClickListener(view -> {
            myNumbers = getNumbers();
            presenter.add(myNumbers[0], myNumbers[1]);
        });
        btn_subtract.setOnClickListener(view -> {
            myNumbers = getNumbers();
            presenter.substract(myNumbers[0], myNumbers[1]);
        });
        btn_multiply.setOnClickListener(view -> {
            myNumbers = getNumbers();
            presenter.multiply(myNumbers[0], myNumbers[1]);
        });
        btn_divide.setOnClickListener(view -> {
            myNumbers = getNumbers();
            presenter.divide(myNumbers[0], myNumbers[1]);
        });

    }

    @Override
    public void showResult(String result) {
        tv_result.setText(result);
    }

    @Override
    public void invalidOperation() {
        Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();

    }

    private int[] getNumbers() {
        int[] arr = new int[0];
        try {
            int num1 = Integer.parseInt(et_num1.getText().toString());
            int num2 = Integer.parseInt(et_num2.getText().toString());
            arr = new int[]{num1, num2};
        } catch (NumberFormatException e) {
            invalidOperation();
        }
        return arr;
    }

}