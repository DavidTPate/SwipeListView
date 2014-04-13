/*
 * Copyright 2013 David Pate
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.davidtpate.swipelistview.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.davidtpate.swipelistview.SwipeListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private SwipeListView mListView;
    private SampleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (SwipeListView) findViewById(R.id.list);
        mAdapter = new SampleAdapter();
        mListView.setAdapter(mAdapter);
    }

    private class SampleAdapter extends BaseAdapter {
        private List<String> mItems;

        public SampleAdapter() {
            super();
            mItems = new ArrayList<String>();
            for (int i = 0; i < 42; i++) {
                mItems.add("I'm list item #" + i + " and I have some text in here which takes up space.");
            }
        }

        /**
         * How many items are in the data set represented by this Adapter.
         *
         * @return Count of items.
         */
        @Override
        public int getCount() {
            if (mItems != null) {
                return mItems.size();
            }
            return 0;
        }

        /**
         * Get the data item associated with the specified position in the data set.
         *
         * @param position
         *     Position of the item whose data we want within the adapter's
         *     data set.
         *
         * @return The data at the specified position.
         */
        @Override
        public String getItem(int position) {
            if (mItems != null) {
                return mItems.get(position);
            }
            return null;
        }

        /**
         * Get the row id associated with the specified position in the list.
         *
         * @param position
         *     The position of the item within the adapter's data set whose row id we want.
         *
         * @return The id of the item at the specified position.
         */
        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * Get a View that displays the data at the specified position in the data set. You can either
         * create a View manually or inflate it from an XML layout file. When the View is inflated, the
         * parent View (GridView, ListView...) will apply default layout parameters unless you use
         * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
         * to specify a root view and to prevent attachment to the root.
         *
         * @param position
         *     The position of the item within the adapter's data set of the item whose view
         *     we want.
         * @param convertView
         *     The old view to reuse, if possible. Note: You should check that this view
         *     is non-null and of an appropriate type before using. If it is not possible to convert
         *     this view to display the correct data, this method can create a new view.
         *     Heterogeneous lists can specify their number of view types, so that this View is
         *     always of the right type (see {@link #getViewTypeCount()} and
         *     {@link #getItemViewType(int)}).
         * @param parent
         *     The parent that this view will eventually be attached to
         *
         * @return A View corresponding to the data at the specified position.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView != null) {
                holder = (ViewHolder) convertView.getTag();
            } else {
                convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false);
                holder = new ViewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.tv_text);
                convertView.setTag(holder);
            }

            holder.textView.setText(getItem(position));
            return convertView;
        }

        private class ViewHolder {
            TextView textView;
        }
    }
}
