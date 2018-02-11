package eu.dsgsystems.hrmapp.custom;


import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by Dimitris on 11/2/2018.
 */

public class MyAxisPointsFormatter implements IAxisValueFormatter {

    private DecimalFormat mFormat;

    public MyAxisPointsFormatter() {

        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mFormat.format(value) + " points";
    }
}
