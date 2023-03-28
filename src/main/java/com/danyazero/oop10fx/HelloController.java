package com.danyazero.oop10fx;

import BLL.CalculatorLogic;
import BLL.ICalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Result;

public class HelloController {
    @FXML
    private Label calculatedIntervalValue;
    @FXML
    private Label calculatedTimeValue;
    @FXML
    private TextField intervalsCount;
    @FXML
    private TextField threadsCount;

    @FXML
    public void startCalculationHandler(ActionEvent actionEvent) {
        ICalculator bll = new CalculatorLogic();
        Result result = bll.calculateIntegral(Integer.parseInt(intervalsCount.getText()), Integer.parseInt(threadsCount.getText()));
        calculatedIntervalValue.setText(String.valueOf(result.getResult()));
        calculatedTimeValue.setText(String.valueOf(result.getTime()));
    }
}