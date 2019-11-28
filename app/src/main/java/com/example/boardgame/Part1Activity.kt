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
import kotlinx.android.synthetic.main.activity_part1.*

class Part1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part1)

       val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width=displayMetrics.widthPixels
        val height=displayMetrics.heightPixels

        val bitmap: Bitmap = Bitmap.createBitmap(1000,1000,Bitmap.Config.ARGB_8888)
        val canvas: Canvas =Canvas(bitmap)

        var shapeDrawable: ShapeDrawable
        var left =width-width
        var right=width-100
        var top=height-height
        var bottom = height-100

        shapeDrawable= ShapeDrawable(RectShape())
        shapeDrawable.setBounds(left, top, right, bottom)
        shapeDrawable.paint.setColor(Color.parseColor("#ffffff"))
        shapeDrawable.draw(canvas)

        imageView.background=BitmapDrawable(getResources(), bitmap)
    }
}
