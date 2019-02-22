package com.example.dycas.baseproject;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Util.LogUtil;
import Util.ReflectionUtil;
import Util.PackageInfoUtil;
import Util._CodeUtil;

/**
 * 単元ごとの先頭ActivityをList化.
 * 先頭Activityは、ActivityClassSummaryの実装が必要.
 */
public class BaseProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_project);

        // プロジェクト内からActivity一覧を取得.
        List<ActivityInfo> activityInfoArray = PackageInfoUtil.getActivityInfoArray(getApplicationContext());

        if (activityInfoArray != null
                && !activityInfoArray.isEmpty()) {
            // ListView
            MyArrayAdapter arrayAdapter = new MyArrayAdapter(getApplicationContext(), R.layout.base_project_activity_list_line_layout, activityInfoArray);
            ((ListView) findViewById(R.id.listview_activitys)).setAdapter(arrayAdapter);
        }
    }

    /**
     * ArrayAdapter SubClass.
     */
    private class MyArrayAdapter extends ArrayAdapter {

        public MyArrayAdapter(Context context, int resource, List<ActivityInfo> activitys) {
            super(context, resource, activitys);

            // List Item 精査.
            checkListItem(activitys);

            // ソート
            sortActivityInfo(activitys);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Layout 取得.
            ViewHolder viewHolder;
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.base_project_activity_list_line_layout, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            // データ 取得.
            ActivityInfo activityInfo = (ActivityInfo) getItem(position);
            final AppCompatActivity activity = (AppCompatActivity) ReflectionUtil.getInstanceFromClassName(activityInfo.name);

            // View 設定.
            viewHolder.mActivityClassNameTextView.setText(activity.getClass().getSimpleName());
            if (activity instanceof ActivityClassSummary) {
                viewHolder.mActivityTitleText.setText(((ActivityClassSummary) activity).getActivityTitle());
                viewHolder.mActivityOutLineText.setText(((ActivityClassSummary) activity).getActivityOutLine());
            }

            // 行選択 listener
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), activity.getClass());
                    startActivity(intent);
                }
            });

            return convertView;
        }

        /**
         * List Item 精査.
         *
         * @param activitys List Item
         */
        private void checkListItem(List<ActivityInfo> activitys) {
            List<ActivityInfo> tmpActivitys = new ArrayList<>(activitys);
            for (int i = 0; i < tmpActivitys.size(); i++) {
                ActivityInfo activityInfo = tmpActivitys.get(i);

                if (activityInfo == null) {
                    activitys.remove(i);
                    continue;
                }

                AppCompatActivity activity = (AppCompatActivity) ReflectionUtil.getInstanceFromClassName(activityInfo.name);
                if (!(activity instanceof ActivityClassSummary)) {
                    activitys.remove(activityInfo);
                }
            }
        }

        /**
         * List<ActivityInfo> のソート.
         * simpleClassName を String#compareTo() で辞書式に小さい順にソート.
         *
         * @param activitys
         */
        private void sortActivityInfo(List<ActivityInfo> activitys) {
            if (_CodeUtil.isNull(activitys)) {
                return;
            }

            Collections.sort(activitys, new Comparator<ActivityInfo>() {
                @Override
                public int compare(ActivityInfo o1, ActivityInfo o2) {
                    String o1SimpleClassName = getActivityInfoSimpleClassName(o1);
                    String o2SimpleClassName = getActivityInfoSimpleClassName(o2);

                    return o1SimpleClassName.compareTo(o2SimpleClassName);
                }
            });
        }

        /**
         * ActivityInfo から simpleClassName を取得.
         *
         * @param activityInfo Activity
         * @return
         */
        private String getActivityInfoSimpleClassName(@NonNull ActivityInfo activityInfo) {
            if (_CodeUtil.isNull(activityInfo)) {
                return "";
            }

            java.lang.String[] split = activityInfo.name.split("\\.");
            return split[split.length - 1];
        }

        /**
         * タグ付用クラス
         */
        private class ViewHolder {
            public TextView mActivityTitleText = null;
            public TextView mActivityClassNameTextView = null;
            public TextView mActivityOutLineText = null;

            public ViewHolder(View v) {
                this.mActivityTitleText = (TextView) v.findViewById(R.id.activity_title_text);
                this.mActivityClassNameTextView = (TextView) v.findViewById(R.id.activity_class_name_text);
                this.mActivityOutLineText = (TextView) v.findViewById(R.id.activity_out_Line_text);
            }
        }
    }
}
