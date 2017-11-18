package com.hedo.troopersapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hedo.troopersapp.R;
import com.hedo.troopersapp.model.Trooper;
import com.hedo.troopersapp.util.ResourceUtil;

import java.util.ArrayList;

/**
 * Criado por hedo.junior em 18/11/2017.
 */

public class TrooperAdapter
        extends RecyclerView.Adapter<TrooperAdapter.ViewHolder>
        implements View.OnClickListener {

    private ArrayList<Trooper> troopers;
    private OnItemClickListener onItemClickListener;
    private View.OnLongClickListener onLongClickListener;

    public TrooperAdapter(ArrayList<Trooper> troopers,
                          OnItemClickListener onItemClickListener,
                          View.OnLongClickListener onLongClickListener) {
        this.troopers = troopers;
        this.onItemClickListener = onItemClickListener;
        this.onLongClickListener = onLongClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_trooper,
                        parent,
                        false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trooper trooper = troopers.get(position);
        holder.tvTrooperName.setText(trooper.getName());
        holder
                .imvTrooperAffiliation
                .setImageResource(ResourceUtil
                        .getResourceBasedOnAffiliation(
                                trooper.getAffiliation()
                        )
                );

        holder.separator
                .setVisibility(
                        position == troopers.size() -1 ?
                                View.INVISIBLE : View.VISIBLE);

        holder.itemView.setTag(trooper);
        holder.itemView.setOnClickListener(this);
        holder.itemView
                .setOnLongClickListener(onLongClickListener);
    }

    @Override
    public int getItemCount() {
        return troopers.size();
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick((Trooper) v.getTag());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTrooperName;
        ImageView imvTrooperAffiliation;
        View separator;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTrooperName = itemView.findViewById(R.id.trooper_name_tv);
            imvTrooperAffiliation =
                    itemView.findViewById(R.id.trooper_affiliation_imv);

            separator = itemView.findViewById(R.id.separator);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Trooper trooper);
    }







}
