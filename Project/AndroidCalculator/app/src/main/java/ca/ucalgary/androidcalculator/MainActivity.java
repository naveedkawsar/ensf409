package ca.ucalgary.androidcalculator;

import android.icu.util.Currency;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private double value_one;
    private double value_two;

    private Button add_button;
    private Button subtract_button;
    private Button multiply_button;
    private Button division_button;

    private char CURRENT_OPERATION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void calculate() {
        if (CURRENT_OPERATION == Operations.ADDITION) {
            value_one += value_two;
        }
        else if (CURRENT_OPERATION == Operations.SUBTRACTION) {
            value_one -= value_two;
        }
        else if (CURRENT_OPERATION == Operations.MULTIPLICATION) {
            value_one *= value_two;
        }
        else if (CURRENT_OPERATION == Operations.DIVISION) {
            value_one /= value_two;
        }
}
