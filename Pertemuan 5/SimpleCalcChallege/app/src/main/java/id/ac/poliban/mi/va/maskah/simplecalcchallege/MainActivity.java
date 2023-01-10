package id.ac.poliban.mi.va.maskah.simplecalcchallege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.poliban.mi.va.maskah.simplecalcchallenge.Calculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the calculator class and all the views
        id.ac.poliban.mi.va.maskah.simplecalcchallenge.Calculator mCalculator = new id.ac.poliban.mi.va.maskah.simplecalcchallenge.Calculator();
        ResultTextView = findViewById(R.id.operation_result_text_view);
        OperandOneEditText = findViewById(R.id.operand_one_edit_text);
        OperandTwoEditText = findViewById(R.id.operand_two_edit_text);
    }

    /**
     * OnClick method called when the add Button is pressed.
     */
    public void onAdd(View view) {
        compute(id.ac.poliban.mi.va.maskah.simplecalcchallenge.Calculator.Operator.ADD);
    }

    /**
     * OnClick method called when the subtract Button is pressed.
     */
    public void onSub(View view) {
        compute(id.ac.poliban.mi.va.maskah.simplecalcchallenge.Calculator.Operator.SUB);
    }

    /**
     * OnClick method called when the divide Button is pressed.
     */
    public void onDiv(View view) {
        try {
            compute(id.ac.poliban.mi.va.maskah.simplecalcchallenge.Calculator.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            ResultTextView.setText(getString(R.string.computationError));
        }
    }

    /**
     * OnClick method called when the multiply Button is pressed.
     */
    public void onMul(View view) {
        compute(id.ac.poliban.mi.va.maskah.simplecalcchallenge.Calculator.Operator.MUL);
    }

    private void compute(id.ac.poliban.mi.va.maskah.simplecalcchallenge.Calculator.Operator operator) {
        double operandOne;
        double operandTwo;
        try {
            operandOne = getOperand(OperandOneEditText);
            operandTwo = getOperand(OperandTwoEditText);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            ResultTextView.setText(getString(R.string.computationError));
            return;
        }

        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(
                        Calculator.add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(
                        Calculator.sub(operandOne, operandTwo));
                break;
            case DIV:
                result = String.valueOf(
                        Calculator.div(operandOne, operandTwo));
                break;
            case MUL:
                result = String.valueOf(
                        Calculator.mul(operandOne, operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }

    }

    /**
     * @return the operand value entered in an EditText as double.
     */
    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    /**
     * @return the operand text which was entered in an EditText.
     */
    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }
}