package com.kostya.parser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kostya.parser.ItemObject;
import com.kostya.parser.ParserItem;
import com.kostya.parser.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LiveRecyclerViewAdapter extends RecyclerView.Adapter<LiveRecyclerViewHolders> {

    private List<ParserItem> itemList;
    private Context context;

    public LiveRecyclerViewAdapter(Context context, List<ParserItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public LiveRecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_card_view_item, null);
        LiveRecyclerViewHolders rcv = new LiveRecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(LiveRecyclerViewHolders holder, int position) {
        ParserItem parserItem = (ParserItem) itemList.get(position);
        holder.foodName.setText(Html.fromHtml(parserItem.getName()));
        Picasso.with(context).load(parserItem.getImg()).into(holder.foodPhoto);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}