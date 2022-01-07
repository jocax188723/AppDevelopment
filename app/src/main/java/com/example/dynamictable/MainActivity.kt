package com.example.dynamictable

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        var count = 2
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            genNextRow(count)
            count += 1
        }


    }

    private fun init(){
        val num = (0..100).random()
        val changedText: TextView = findViewById(R.id.textView2)
        num.also { changedText.text = it.toString() }
    }

    private fun genNextRow(count: Int) {
        val mTbl : TableLayout = findViewById(R.id.tableLayout)
        val tRow = TableRow(this)
        val tv0 = TextView(this)
        tv0.text = count.toString()
        tv0.setTextColor(Color.BLACK)
        tv0.gravity = Gravity.CENTER_HORIZONTAL
        tv0.textSize = 20F
        tv0.setPadding(4, 4,4,4)
        tRow.addView(tv0)
        val tv1 = TextView(this)
        val num = (0..100).random()
        tv1.text = num.toString()
        tv1.setTextColor(Color.BLACK)
        tv1.gravity = Gravity.CENTER_HORIZONTAL
        tv1.textSize = 20F
        tv1.setPadding(4, 4,4,4)
        tRow.addView(tv1)
        mTbl.addView(tRow, count)

    }

}