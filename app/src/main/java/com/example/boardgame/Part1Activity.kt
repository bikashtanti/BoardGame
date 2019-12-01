package com.example.boardgame

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_part1.*

class Part1Activity : AppCompatActivity() {
    public var height =0
    public var width=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part1)

       val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        width=displayMetrics.widthPixels
        height=width

        val text: TextView = findViewById(R.id.textView) as TextView
        text.setOnClickListener { text.setText("h" + height +"w" + width ) }

        val bitmap: Bitmap = Bitmap.createBitmap(1000,1000,Bitmap.Config.ARGB_8888)
        val canvas: Canvas =Canvas(bitmap)

        for(i in 0..4) {
            for (j in 0..7) {
                var shapeDrawable: ShapeDrawable
                var left = (i*width/6)+(width/18)
                var right = left+ (width/6) - 10
                var top = (j*height/9)+(height/27)
                var bottom = top+ (height/9)- 10

                shapeDrawable = ShapeDrawable(RectShape())
                shapeDrawable.setBounds(left, top, right, bottom)
                if(i==j) {
                    shapeDrawable.paint.setColor(Color.parseColor("#EC5247"))
                }
                else
                    shapeDrawable.paint.setColor(Color.parseColor("#ffffff"))

                shapeDrawable.draw(canvas)
                imageView.background = BitmapDrawable(getResources(), bitmap)

            }

        }

    }
}
