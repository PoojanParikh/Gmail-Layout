/*package com.vnurture.vnurture.gmaillayout;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;


public class ExtendCustomAdapter extends BaseAdapter {

    List<ToExtend> items;
    Context context;

    public class Row{
        AppCompatButton toExtendButton;
        AppCompatTextView mTvDescription;
        AppCompatSpinner toSpinner;
        LinearLayout toLinearLayout;
        Button mIvArrow;
    }

    public ExtendCustomAdapter(Context context, List<ToExtend> items){
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        Row theRow;

        if(convertView == null){
            theRow = new Row();
            convertView = LayoutInflater.from(context).inflate(R.layout.single_row_to_layout, parent, false);
            theRow.toLinearLayout = (LinearLayout) convertView.findViewById(R.id.to_main_linear_layout);
            //theRow.toExtendButton = (AppCompatButton) convertView.findViewById(R.id.app_compat_text_view);
            //theRow.mTvDescription = (AppCompatTextView) convertView.findViewById(R.id.tv_description);
            theRow.mIvArrow = (Button) convertView.findViewById(R.id.to_image_button);

            convertView.setTag(theRow);
        }else{

            theRow = (Row) convertView.getTag();
        }

        // Update the View
        ToExtend item = items.get(i);
        if(item.isExpanded){
            theRow.toLinearLayout.setVisibility(View.VISIBLE);
            theRow.mIvArrow.setRotation(180f);
        }else{
            theRow.toLinearLayout.setVisibility(View.GONE);
            theRow.mIvArrow.setRotation(0f);
        }

        //theRow.mTvTitle.setText(item.title);
        //theRow.mTvDescription.setText(item.description);


        // return the view
        return convertView;
    }

}*/
