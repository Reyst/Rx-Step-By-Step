package gsi.reyst.rx.step.by.step.adapters;

import android.view.View;

import gsi.reyst.rx.step.by.step.model.VO.Repository;
import gsi.reyst.rx.step.by.step.presenter.RepoListPresenter;

public class RepositoriesAdapter extends BaseAdapter<Repository> {

    private RepoListPresenter mPresenter;

    public RepositoriesAdapter(RepoListPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Repository r = getItem(position);

        holder.textView.setText(r.getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickItem(r);
            }
        });

    }
}
