package com.example.ecoevent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticsActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM_ID = "SELECTED_ITEM_ID";
    private int selectedItemId = R.id.menu_stadistic;
    private TableLayout myTableLayout;
    private SharedPreferences dataPrefes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_screen);
        myTableLayout = findViewById(R.id.myTableLayout);
        dataPrefes = getSharedPreferences("QData", MODE_PRIVATE);
        loadData();
        setupPieChart();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(selectedItemId);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectedItemId = item.getItemId();
                Class<?> targetActivity = null;

                if (selectedItemId == R.id.menu_home) {
                    targetActivity = MainActivity3.class;
                } else if (selectedItemId == R.id.menu_categories) {
                    targetActivity = CategoriaActivity.class;
                } else if (selectedItemId == R.id.menu_register) {
                    targetActivity = RegistrosActivity.class;
                } else if (selectedItemId == R.id.menu_stadistic) {
                    targetActivity = StatisticsActivity.class;
                } else if (selectedItemId == R.id.menu_about) {
                    targetActivity = TipsActivity.class;
                }

                if (targetActivity != null) {
                    startActivity(new Intent(StatisticsActivity.this, targetActivity));
                    return true;
                } else {
                    return false;
                }
            }
        });
    }


    private void setupPieChart() {
        PieChart pieChart = findViewById(R.id.pieChart);

        // Lee los datos de SharedPreferences y acumula las cantidades por mes
        int dataIndex = dataPrefes.getInt("index", 0);
        Map<String, Float> monthData = new HashMap<>();

        for (int i = 0; i < dataIndex; i++) {
            String month = dataPrefes.getString("mes" + i, "");
            String cantidadString = dataPrefes.getString("cantidad" + i, "0");
            float cantidad = Float.parseFloat(cantidadString);

            if (!month.isEmpty() && cantidad > 0) {
                if (monthData.containsKey(month)) {
                    monthData.put(month, monthData.get(month) + cantidad);
                } else {
                    monthData.put(month, cantidad);
                }
            }
        }

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        for (Map.Entry<String, Float> entry : monthData.entrySet()) {
            pieEntries.add(new PieEntry(entry.getValue(), entry.getKey()));
        }

        if (pieEntries.isEmpty()) {
            Toast.makeText(this, "No hay datos para mostrar en el gráfico", Toast.LENGTH_SHORT).show();
        } else {
            PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

            ArrayList<Integer> pieColors = new ArrayList<>();
            pieColors.add(Color.rgb(15, 158, 213));
            pieColors.add(Color.rgb(60, 125, 34));
            pieColors.add(Color.rgb(12, 118, 158));
            pieColors.add(Color.rgb(160, 43, 147));
            pieColors.add(Color.rgb(233, 113, 50));
            pieDataSet.setColors(pieColors);

            PieData pieData = new PieData(pieDataSet);
            pieChart.setData(pieData);
            pieChart.setUsePercentValues(false);
            pieChart.setEntryLabelColor(Color.WHITE);

            Description pieDescription = new Description();
            pieDescription.setText("Consumo mes");
            pieChart.setDescription(pieDescription);
            pieChart.invalidate();
        }
    }


        /* Configurar PieChart
        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(1000f, "Enero"));
        pieEntries.add(new PieEntry(900f, "Febrero"));
        pieEntries.add(new PieEntry(500f, "Marzo"));
        pieEntries.add(new PieEntry(800f, "Abril"));
        pieEntries.add(new PieEntry(600f, "Mayo"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

        ArrayList<Integer> pieColors = new ArrayList<>();
        pieColors.add(Color.rgb(15,158,213));
        pieColors.add(Color.rgb(60,125,34));
        pieColors.add(Color.rgb(12,118,158));
        pieColors.add(Color.rgb(160,43,147));
        pieColors.add(Color.rgb(233,113,50));
        pieDataSet.setColors(pieColors);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.setUsePercentValues(false);
        pieChart.setEntryLabelColor(Color.WHITE);

        Description pieDescription = new Description();
        pieDescription.setText("Consumo mes");
        pieChart.setDescription(pieDescription);
        pieChart.invalidate();*/


        // Configurar HorizontalBarChart
        /*HorizontalBarChart horizontalBarChart = findViewById(R.id.horizontalBarChart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 500f));
        barEntries.add(new BarEntry(1, 800f));
        barEntries.add(new BarEntry(2, 600f));
        barEntries.add(new BarEntry(3, 1200f));
        barEntries.add(new BarEntry(4, 1500f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Tipo");
        barDataSet.setColor(Color.rgb(78,167,46));

        BarData barData = new BarData(barDataSet);
        horizontalBarChart.setData(barData);

        horizontalBarChart.getDescription().setEnabled(false);

        String[] barLabels = new String[]{"Latas", "Cubiertos", "Platos", "Vasos", "Bolsas"};
        XAxis xAxis = horizontalBarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(barLabels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);

        horizontalBarChart.invalidate();*/

    private  void loadData(){
        SharedPreferences dataPrefes = getSharedPreferences("QData",MODE_PRIVATE);
        int dataIndex = dataPrefes.getInt("index",0);
        for (int i = 0; i < dataIndex; i++){
            String month = dataPrefes.getString("mes" + i,"");
            String tipo = dataPrefes.getString("tipo" + i,"");
            String cantidad = dataPrefes.getString("cantidad" + i,"");
            String precio = dataPrefes.getString("costo" + i , "");

            //Generar datos dentro de la tabla
            TableRow tableRow = new TableRow(this);

            TextView textViewMonth = new TextView(this);
            textViewMonth.setText(month);
            textViewMonth.setBackgroundResource(R.color.white);
            tableRow.addView(textViewMonth);

            TextView textViewService = new TextView(this);
            textViewService.setText(tipo);
            textViewService.setBackgroundResource(R.color.white);
            tableRow.addView(textViewService);

            TextView textViewConsumption = new TextView(this);
            textViewConsumption.setText(cantidad);
            textViewConsumption.setBackgroundResource(R.color.white);
            tableRow.addView(textViewConsumption);

            TextView textViewPrice = new TextView(this);
            textViewPrice.setText(precio);
            textViewPrice.setBackgroundResource(R.color.white);
            tableRow.addView(textViewPrice);

            myTableLayout.addView(tableRow);
        }
    }
}