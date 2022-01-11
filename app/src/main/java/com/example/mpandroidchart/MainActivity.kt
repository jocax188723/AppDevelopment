package com.example.mpandroidchart

import android.graphics.Color.blue
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.*
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import kotlin.math.sin


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entries = ArrayList<Entry>()

        val pi = 3.14

        for (i in 0..360){
            val radian = i * pi/180
            val angle = sin(radian)

            entries.add(Entry(i.toFloat(), angle.toFloat()))
        }

        val vl = LineDataSet(entries, "Sine Graph")

        vl.setDrawValues(false)
        vl.setDrawFilled(false)
        vl.lineWidth = 5f
        //vl.fillColor = R.color.green
        //vl.fillAlpha = R.color.green
        vl.mode = LineDataSet.Mode.CUBIC_BEZIER
        //vl.color = R.color.green

        val lineChart: LineChart = findViewById(R.id.line1)

        lineChart.xAxis.labelRotationAngle = 0f

        lineChart.data = LineData(vl)

        lineChart.axisRight.isEnabled = false
        lineChart.xAxis.axisMaximum = 360f

        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)

        lineChart.description.text = "Days"
        lineChart.setNoDataText("No forex yet!")

        lineChart.animateX(1800, Easing.EaseInExpo)

        val markerView = CustomMarker(this, R.layout.custom_marker)
        lineChart.marker = markerView
    }

}