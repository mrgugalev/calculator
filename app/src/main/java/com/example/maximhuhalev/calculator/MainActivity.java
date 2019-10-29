package com.example.maximhuhalev.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etExpression, etResult;

    private ViewModelCalc model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etExpression = findViewById(R.id.et_expression);
        etResult = findViewById(R.id.et_expression);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);
        findViewById(R.id.button13).setOnClickListener(this);
        findViewById(R.id.button14).setOnClickListener(this);
        findViewById(R.id.button15).setOnClickListener(this);
        findViewById(R.id.button16).setOnClickListener(this);
        findViewById(R.id.button17).setOnClickListener(this);
        findViewById(R.id.button18).setOnClickListener(this);
        findViewById(R.id.button19).setOnClickListener(this);
        findViewById(R.id.button20).setOnClickListener(this);
        findViewById(R.id.button21).setOnClickListener(this);
        findViewById(R.id.button22).setOnClickListener(this);
        findViewById(R.id.button23).setOnClickListener(this);
        findViewById(R.id.button24).setOnClickListener(this);
        findViewById(R.id.button25).setOnClickListener(this);
        findViewById(R.id.button26).setOnClickListener(this);
        findViewById(R.id.button27).setOnClickListener(this);
        findViewById(R.id.button28).setOnClickListener(this);
        findViewById(R.id.button29).setOnClickListener(this);
        findViewById(R.id.button30).setOnClickListener(this);

        model = ViewModelProviders.of(this).get(ViewModelCalc.class);
        model.getExpression().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etExpression.setText(s);
            }
        });
    }

    private double calculateExpression(String expression) {
        return new ExpressionBuilder(expression)
                .build()
                .evaluate();
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.button30:
                    double result = calculateExpression(etExpression.getText().toString());
                    String resultString = String.valueOf(result);
                    if (resultString.equals("NaN")) {
                        throw new Exception("Error");
                    } else {
                        etResult.setText(String.valueOf(result));
                    }
                    break;
                case R.id.button1:
                    model.clearExpression();
                    etResult.setText("");
                    break;
                case R.id.button2:
                    model.changeExpression("sqrt(");
                    break;
                case R.id.button3:
                    model.changeExpression("(");
                    break;
                case R.id.button4:
                    model.changeExpression(")");
                    break;
                case R.id.button5:
                    model.backspaceExpression();
                    etResult.setText("");
                    break;
                case R.id.button6:
                    model.changeExpression("/");
                    break;
                case R.id.button7:
                    model.changeExpression("cos(");
                    break;
                case R.id.button8:
                    model.changeExpression("tan(");
                    break;
                case R.id.button9:
                    model.changeExpression("7");
                    break;
                case R.id.button10:
                    model.changeExpression("8");
                    break;
                case R.id.button11:
                    model.changeExpression("9");
                    break;
                case R.id.button12:
                    model.changeExpression("*");
                    break;
                case R.id.button13:
                    model.changeExpression("sin(");
                    break;
                case R.id.button14:
                    model.changeExpression("log10(");
                    break;
                case R.id.button15:
                    model.changeExpression("4");
                    break;
                case R.id.button16:
                    model.changeExpression("5");
                    break;
                case R.id.button17:
                    model.changeExpression("6");
                    break;
                case R.id.button18:
                    model.changeExpression("-");
                    break;
                case R.id.button19:
                    model.changeExpression("log(");
                    break;
                case R.id.button20:
                    model.changeExpression("^");
                    break;
                case R.id.button21:
                    model.changeExpression("1");
                    break;
                case R.id.button22:
                    model.changeExpression("2");
                    break;
                case R.id.button23:
                    model.changeExpression("3");
                    break;
                case R.id.button24:
                    model.changeExpression("+");
                    break;
                case R.id.button25:
                    model.changeExpression("^2");
                    break;
                case R.id.button26:
                    model.changeExpression(String.valueOf(Math.PI));
                    break;
                case R.id.button27:
                    model.changeExpression(String.valueOf(Math.E));
                    break;
                case R.id.button28:
                    model.changeExpression("0");
                    break;
                case R.id.button29:
                    model.changeExpression(",");
                    break;
            }
        } catch (Exception e) {
            model.clearExpression();
            etResult.setText("");
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
