package gsi.reyst.rx.step.by.step.adapters;

import gsi.reyst.rx.step.by.step.model.VO.Branch;

public class BranchesAdapter extends BaseAdapter<Branch> {

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Branch branch = getItem(position);
        holder.textView.setText(branch.getName());
    }
}
