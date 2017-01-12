package gsi.reyst.rx.step.by.step.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gsi.reyst.rx.step.by.step.R;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter<T>.ViewHolder> {

    private List<T> list = new ArrayList<>();

    public T getItem(int position) {
        return list.get(position);
    }

    public void setData(List<T> data) {
        list = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public abstract void onBindViewHolder(ViewHolder holder, int position);

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }


}
