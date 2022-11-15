package com.example.androidlab

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

class MyDecoration(val context : Context):RecyclerView.ItemDecoration() {
    //리싸이클러뷰에 이미지를 덮는기능

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        //리싸이클러뷰 사이즈를 체크
        val width= parent.width
        val height = parent.height
        //이미지 크기 체크
        val kboImage : Drawable?  = ResourcesCompat.getDrawable(context.resources, R.drawable.kbo, null)
        val imageWidth = kboImage?.intrinsicWidth
        val imageHeight = kboImage?.intrinsicHeight
        //이미지 놓을 좌표 계산(x,y)
        val x = width/2 - imageWidth?.div(2) as Int
        val y = height/2 - imageHeight?.div(2) as Int
        //리사이클러뷰에 (x,y) 이미지를 그린다(캔버스에 비트맵그린다)
        c.drawBitmap(BitmapFactory.decodeResource(context.resources,R.drawable.kbo),x.toFloat(),y.toFloat(),null)





    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view)+1
        if(index %3 ==0){
            outRect.set(10,10,10,60)
        }else{
            outRect.set(10,10,10,0)
        }
        view.setBackgroundColor(Color.parseColor("#FF6FDED3"))
        ViewCompat.setElevation(view, 20.0f)
    }
}