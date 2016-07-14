package com.shangliu.china.android.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shangliu.china.android.R;


/**
 * itemview
 * <p/>
 * 自定义组合控件
 * 第一步定义你需要的属性
 * 第二部写相应的类
 * 第三部在布局中去引用
 */
public class ComItemLayoutView extends FrameLayout {

    public ComItemLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ViewGroup.LayoutParams lps = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        RelativeLayout viewGroup = (RelativeLayout) View.inflate(context, R.layout.common_item_layout, null);

        ImageView iconImage = (ImageView) viewGroup.findViewById(R.id.icon_img);
        TextView titleView = (TextView) viewGroup.findViewById(R.id.hint_title);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ComItem_attr);

        //图片
        if (typedArray.hasValue(R.styleable.ComItem_attr_cicon)) {
            int imgId = typedArray.getResourceId(R.styleable.ComItem_attr_cicon,R.drawable.loading_default);
            iconImage.setImageResource(imgId);
        }

        //标题
        if (typedArray.hasValue(R.styleable.ComItem_attr_ctitle)) {
            String titleStr = typedArray.getString(R.styleable.ComItem_attr_ctitle);
            titleView.setText(titleStr);
        }

        typedArray.recycle();

        viewGroup.setLayoutParams(lps);

        addView(viewGroup);
    }

}