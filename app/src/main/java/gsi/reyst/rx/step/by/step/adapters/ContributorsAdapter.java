package gsi.reyst.rx.step.by.step.adapters;

import gsi.reyst.rx.step.by.step.model.VO.Contributor;

public class ContributorsAdapter extends BaseAdapter<Contributor> {

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contributor item = getItem(position);
        holder.textView.setText(item.getName());
    }

}
