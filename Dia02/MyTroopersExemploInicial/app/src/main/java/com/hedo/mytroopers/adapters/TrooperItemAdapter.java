package com.hedo.mytroopers.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hedo.mytroopers.R;
import com.hedo.mytroopers.domain.Trooper;
import com.hedo.mytroopers.util.DrawableUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Criado por hedo.junior em 16/11/2017.
 */

public class TrooperItemAdapter extends RecyclerView.Adapter<TrooperItemAdapter.ViewHolder> implements View.OnClickListener {

    private List<Trooper> troopers = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private View.OnLongClickListener onItemLongClickListener;

    public TrooperItemAdapter(List<Trooper> troopers, OnItemClickListener onItemClickListener, View.OnLongClickListener onItemLongClickListener) {
        this.troopers = troopers;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return troopers.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_trooper_item, parent, false);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(onItemLongClickListener);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trooper trooper = troopers.get(position);
        holder.bind(trooper, position != getItemCount());
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick((Trooper) v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTrooperName;
        private ImageView imvTrooperAffiliation;
        private View vSeparator;

        public ViewHolder(View view) {
            super(view);
            tvTrooperName = view.findViewById(R.id.trooper_name_tv);
            imvTrooperAffiliation = view.findViewById(R.id.trooper_affiliation_imv);
            vSeparator = view.findViewById(R.id.separator_v);
        }

        public void bind(Trooper trooper, boolean showSeparator) {
            tvTrooperName.setText(trooper.getName());
            imvTrooperAffiliation.setImageResource(DrawableUtil.getAffiliationDrawable(trooper.getAffiliation()));
            itemView.setTag(trooper);
            vSeparator.setVisibility(showSeparator ? View.VISIBLE : View.INVISIBLE);
        }


    }

    public interface OnItemClickListener {
        void onItemClick(Trooper item);
    }
}
