package com.example.m_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.m_app.R;
import com.example.m_app.model.Activity;

import java.util.List;

public class ActivitiesListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Activity> activityList;

    public ActivitiesListAdapter(Context context, List<Activity> activityList) {
        this.context = context;
        this.activityList = activityList;
    }

    @Override
    public int getGroupCount() {
        return activityList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        Activity groupAct = activityList.get(i);

        return groupAct;
    }

    @Override
    public Object getChild(int i, int i1) {
        Activity childAct = activityList.get(i);

        return childAct;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        Activity activity = (Activity) getGroup(i);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.place_activity_list_header, viewGroup, false);
        }

        TextView tv_name = view.findViewById(R.id.activity_name);
        TextView tv_price = view.findViewById(R.id.activity_price);

        tv_name.setText(activity.getActivityName());
        tv_price.setText(activity.getPrice().toString());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Activity activity = (Activity) getChild(i, i1);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.place_activity_list_child, viewGroup, false);
        }

        TextView tv_desc = view.findViewById(R.id.activity_description);
        TextView tv_type = view.findViewById(R.id.activity_type);
        TextView tv_offer = view.findViewById(R.id.activity_offer);

        tv_desc.setText(activity.getActivityDesc());
        tv_type.setText(activity.getType());
        if (activity.getOffer() != null) {
            tv_offer.setText(activity.getOffer());
            tv_offer.setVisibility(View.VISIBLE);
        }


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
