package com.example.mrb.drawbycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrb on 16-04-26.
 */
public class DrawingArea extends View // You need to extend the View class
{

    Paint pntTextPaint;     // Painting object to handle the paint jobs for graphics
    Paint pntGraphicsPaint; // Painting object to handle the paint jobs for text
    Paint pntOtherPaint;
    boolean blnShowText;
    int intTextPosition;

    public DrawingArea(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawingArea,
                0, 0);

        try {
            blnShowText = a.getBoolean(R.styleable.DrawingArea_displayText, false);
            intTextPosition = a.getInteger(R.styleable.DrawingArea_labelPosition, 0);
        } finally {
            a.recycle();
        }

        init(); // Calling the init() method happens once, when we set up our Paint objects
    }

    private void init()
    {
        // This method is called once when the DrawingArea object is made.
        // It is best practice to handle the set-up of our Paint objects here rather than in onDraw()

        pntTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntGraphicsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntOtherPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        pntGraphicsPaint.setColor(Color.BLUE);
        pntGraphicsPaint.setStrokeWidth(3);

        pntTextPaint.setColor(Color.GREEN);
        pntTextPaint.setStrokeWidth(3);

        pntOtherPaint.setColor(Color.BLACK);
        pntOtherPaint.setStrokeWidth(3);

    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // This method exists to handle re-drawing of the DrawingArea object in the event of a
        //   resize of our App. For example, tilting the device may require us to redraw our content.
        // More instructions are meant to be added at the bottom if required.

        super.onSizeChanged(w, h, oldw, oldh);

    }

    protected void onDraw(Canvas canvas)
    {
        // This method is where we issue our actual drawing commands.
        // The Canvas parameter is what we draw ON; the Paint objects defined above are what we draw WITH.

        super.onDraw(canvas);
        /*
        canvas.drawCircle((float)325.0,(float)100.0,(float)100.0,pntGraphicsPaint);

        canvas.drawRect((float)300.0, (float)125.0,(float)350.0,(float)500.0, pntGraphicsPaint);

        canvas.drawRect((float)150.0,(float)250.0,(float)500.0,(float)300.0,pntGraphicsPaint);

        canvas.drawRect((float)400.0,(float)450.0,(float)250.0,(float)500.0,pntGraphicsPaint);

        canvas.drawRect((float)200.0,(float)450.0,(float)250.0,(float)700.0,pntGraphicsPaint);
        canvas.drawRect((float)400.0,(float)450.0,(float)450.0,(float)700.0,pntGraphicsPaint);

        canvas.drawCircle((float)280.0, (float) 80.0, (float)20.0,pntOtherPaint);
        canvas.drawCircle((float)370.0, (float) 80.0,(float) 20.0,pntOtherPaint);

       for(int i = 0; i<canvas.getWidth() ; i+= lineStart) {
            canvas.drawLine((float)i,(float)0.00,(float)i,(float)canvas.getHeight(),pntOtherPaint);
       }
        for(int i = 0; i <canvas.getHeight(); i+= lineStart) {
            canvas.drawLine((float) 0.00, (float) i, (float) canvas.getWidth(), (float) i, pntOtherPaint);
        }
        **/
        boolean isBlue = true;
        float leftSide = (float) 0.0;
        float rightSide = (float) 100.0;
        float TopSide = (float) 100.00;
        float botLength = (float) 0.0;
       do{
           if(isBlue){
               pntGraphicsPaint.setColor(Color.BLUE);
               isBlue = false;
           }else{
               pntGraphicsPaint.setColor(Color.RED);
               isBlue = true;
           }
           canvas.drawRect(leftSide, botLength, rightSide, TopSide, pntGraphicsPaint);
           leftSide += 100.0;
           rightSide += 100.0;
           if(rightSide >= canvas.getWidth()){
               botLength += 100.0;
               TopSide += 100.0;
               leftSide = (float) 0.0;
               rightSide = (float) 100.0;
           }
       }while(canvas.getHeight() >= botLength);
    }
}
