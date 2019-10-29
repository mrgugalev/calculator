package com.example.maximhuhalev.calculator;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelCalc extends ViewModel {

    private MutableLiveData<String> liveDataExpression;

    public ViewModelCalc() {
        liveDataExpression = new MutableLiveData<>("");
    }

    public void clearExpression() {
        liveDataExpression.setValue("");
    }

    public void changeExpression(String symbol) {
        liveDataExpression.setValue(liveDataExpression.getValue() + symbol);
    }

    public void backspaceExpression() {
        final int strLength =  liveDataExpression.getValue().length();
        if (strLength > 0) {
            liveDataExpression.setValue(liveDataExpression.getValue().substring(0, strLength - 1));
        }
    }

    public MutableLiveData<String> getExpression() {
        return liveDataExpression;
    }
}
