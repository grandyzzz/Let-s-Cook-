package com.kostya.parser.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kostya.parser.ParserItem;
import com.kostya.parser.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Костя on 28.05.2016.
 */
public class FoodAdapter extends BaseAdapter {
    Context context;
    ArrayList<ParserItem> arrayList;
    LayoutInflater inflater;

    public FoodAdapter(Context context, ArrayList<ParserItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = ((Activity) context).getLayoutInflater();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        ParserItem parserItem = (ParserItem) getItem(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
//            holder.ing = (TextView) convertView.findViewById(R.id.ingredients);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(Html.fromHtml(parserItem.getName()));
//        holder.ing.setText(Html.fromHtml(parserItem.getIng()));
        Picasso.with(context).load(parserItem.getImg()).into(holder.img);

        return convertView;
    }

    class ViewHolder {
        TextView name;
        ImageView img;
    }
}
