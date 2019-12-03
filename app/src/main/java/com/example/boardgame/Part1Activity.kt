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
    public var posx: Float = 0.0f
    public var posy: Float = 0.0f
    public var height =0
    public var width=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part1)

        var drawBoardDecide=1
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        width=displayMetrics.widthPixels
        height=width

        GamePage.setOnTouchListener { _, event ->
            posx=event.x
            posy=(event.y/displayMetrics.heightPixels)*width

            drawBox(posx,posy)

            if (drawBoardDecide==1){
                drawBoard(height,width)
                drawBoardDecide=1
            }
            val text: TextView = findViewById(R.id.textView) as TextView
            text.text = "h" + posy +"w" + posx

            true
        }
    }

    private fun drawBoard(height: Int, width: Int) {
        val bitmap: Bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888)
        val canvas =Canvas(bitmap)
        for(i in 0..4) {
            for (j in 0..7) {
                var shapeDrawable = ShapeDrawable(RectShape())
                var left = (i*width/6)+(width/18)
                var right = left+ (width/6) - 10
                var top = (j*height/9)+(height/27)
                var bottom = top+ (height/9)- 10
                shapeDrawable.setBounds(left, top, right, bottom)
                shapeDrawable.paint.color = Color.parseColor("#ffffff")
                shapeDrawable.draw(canvas)
                imageView.background = BitmapDrawable(resources, bitmap)
            } } }

    private fun drawBox(posnx: Float, posny: Float) {
        val bitmap: Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        var i=((posnx+(width/9))/(width/6)).toInt()-1
        var j=((posny+(height/18))/(height/9)).toInt()-1
        if(i in 0..4 && j in 0..7) {
            var shapeDrawable = ShapeDrawable(RectShape())
            var left = (i * width / 6) + (width / 18)
            var right = left + (width / 6) - 10
            var top = (j * height / 9) + (height / 27)
            var bottom = top + (height / 9) - 10
            shapeDrawable.setBounds(left, top, right, bottom)
            shapeDrawable.paint.color = Color.parseColor("#EC5247")
            shapeDrawable.draw(canvas)
            imageViewBox.background = BitmapDrawable(resources, bitmap)
        }
    }
}
