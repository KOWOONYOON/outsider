package com.example.myapplication0325;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Fragment4 extends Fragment {


    public void getTimetv() {
        while(true) {
            TextView timeTv = getView().findViewById(R.id.timeTv);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");
            String time2 = sdf.format(new Date(System.currentTimeMillis()));
            timeTv.setText(time2);
        }
    }


    LineChart lineChart;
    public Fragment4() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root_view = inflater.inflate(R.layout.fragment_4, container, false);

        lineChart = (com.github.mikephil.charting.charts.LineChart) root_view.findViewById(R.id.lineChart);


        //initView();
        initData();

        return root_view;
    }

    public int ran() {
        Random ran = new Random();
        int i = ran.nextInt(199);

        return i;
    }

    public int ran2() {
        Random ran = new Random();
        int i = ran.nextInt(49);

        return i;
    }

    public void initData() {
        lineChart.setExtraOffsets(12,50,24,0); //padding
        setDescription("two lines example");
        lineChart.animateXY(500, 0);
        setLegend();
        setYAxis();
        setXAxis();
        setChartData();
    }

    public void setLegend() {
        Legend legend = lineChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setFormSize(20);
        legend.setTextSize(20f);
        legend.setFormLineWidth(1);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setTextColor(Color.BLACK);
    }

    public void setDescription(String descriptionStr) {
        Description description = new Description();
        description.setText(descriptionStr);
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        Paint paint = new Paint();
        paint.setTextSize(20);
        float x = outMetrics.widthPixels - Utils.convertDpToPixel(12);
        float y =  Utils.calcTextHeight(paint, descriptionStr) + Utils.convertDpToPixel(12);
        description.setPosition(x, y);
        lineChart.setDescription(description);
    }

    public void setYAxis() {
        final YAxis yAxisLeft = lineChart.getAxisLeft();
        yAxisLeft.setAxisMaximum(200);
        yAxisLeft.setAxisMinimum(0);
        yAxisLeft.setGranularity(10);
        yAxisLeft.setTextSize(12f);
        yAxisLeft.setTextColor(Color.BLACK);

        /*
        yAxisLeft.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value == yAxisLeft.getAxisMinimum() ? (int) value + "" : (int) value +"";
            }
        });*/
        lineChart.getAxisRight().setEnabled(false);
    }

    public void setXAxis() {
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(20);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setTextSize(12f);
        xAxis.setGranularity(1);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(100);

        /*
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value == 0 ? "example" : (int) value + "";
            }
        });*/
    }

    public void setChartData() {

        List<Entry> yVals1 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int j = ran();
            yVals1.add(new Entry(1 + i,j));
        }

        List<Entry> yVals2 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int j = ran2();
            yVals2.add(new Entry(1 + i,j));
        }

        LineDataSet lineDataSet1 = new LineDataSet(yVals1, "ex1");
        lineDataSet1.setValueTextSize(20);
        lineDataSet1.setDrawCircleHole(true);
        lineDataSet1.setColor(Color.MAGENTA);
        lineDataSet1.setMode(LineDataSet.Mode.LINEAR);
        lineDataSet1.setDrawCircles(true);
        lineDataSet1.setCubicIntensity(0.15f);
        lineDataSet1.setCircleColor(Color.MAGENTA);
        lineDataSet1.setLineWidth(1);

        LineDataSet lineDataSet2 = new LineDataSet(yVals2, "ex2");
        lineDataSet2.setValueTextSize(20);
        lineDataSet2.setDrawCircleHole(true);
        lineDataSet2.setColor(Color.BLUE);
        lineDataSet2.setMode(LineDataSet.Mode.LINEAR);
        lineDataSet2.setDrawCircles(true);
        lineDataSet2.setCubicIntensity(0.15f);
        lineDataSet2.setCircleColor(Color.BLUE);
        lineDataSet2.setLineWidth(1);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        LineData lineData = new LineData(dataSets);

        lineChart.setVisibleXRangeMaximum(5);
        lineChart.setScaleXEnabled(true);
        lineChart.setData(lineData);
    }

}