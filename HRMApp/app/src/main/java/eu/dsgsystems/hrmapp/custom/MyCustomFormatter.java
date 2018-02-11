package eu.dsgsystems.hrmapp.custom;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by Dimitris on 11/2/2018.
 */

public class MyCustomFormatter implements IAxisValueFormatter{

    public MyCustomFormatter(){}
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return "";
    }
}
