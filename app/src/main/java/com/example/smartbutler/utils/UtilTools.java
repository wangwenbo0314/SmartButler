package com.example.smartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * 项目名： SmartButler
 * 包  名： com.example.smartbutler.utils
 * 文件名： UtilTools
 *
 * @author 王文博
 * @date 2018/3/15
 * 描  述： 工具统一类
 */

public class UtilTools {
    public static void setFont(Context mContext, TextView textView){
        Typeface fontType = Typeface.createFromAsset(mContext.getAssets(),"fonts/FONT.TTF");
        textView.setTypeface(fontType);
    }
}
