package gsi.reyst.rx.step.by.step.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import gsi.reyst.rx.step.by.step.DI.ComponentHolder;
import gsi.reyst.rx.step.by.step.R;
import gsi.reyst.rx.step.by.step.adapters.BranchesAdapter;
import gsi.reyst.rx.step.by.step.adapters.ContributorsAdapter;
import gsi.reyst.rx.step.by.step.model.VO.Branch;
import gsi.reyst.rx.step.by.step.model.VO.Contributor;
import gsi.reyst.rx.step.by.step.model.VO.Repository;
import gsi.reyst.rx.step.by.step.presenter.BasePresenter;
import gsi.reyst.rx.step.by.step.presenter.RepoInfoPresenter;
import gsi.reyst.rx.step.by.step.views.RepoInfoView;

import static gsi.reyst.rx.step.by.step.Constants.KEY_REPO;

public class RepoInfoFragment extends BaseFragment implements RepoInfoView {

    @Inject
    RepoInfoPresenter mPresenter;

    @Inject
    Context mContext;

    @Inject
    BranchesAdapter mBranchesAdapter;

    @Inject
    ContributorsAdapter mContributorAdapter;

    public static RepoInfoFragment getInstance(Bundle params) {

        RepoInfoFragment result = new RepoInfoFragment();
        result.setArguments(params);

        return result;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle params = getArguments();
        Repository repo = (Repository) params.getSerializable(KEY_REPO);

        ComponentHolder.getInstance().getRepoInfoComponent(this, repo).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.repo_info_fragment, container, false);
//        mContext = inflater.getContext();

        RecyclerView rvBranches = (RecyclerView) view.findViewById(R.id.rv_branches);
        LinearLayoutManager llm1 = new LinearLayoutManager(mContext);
        rvBranches.setLayoutManager(llm1);
//        mBranchesAdapter = new BranchesAdapter();
        rvBranches.setAdapter(mBranchesAdapter);

        RecyclerView rvContributors = (RecyclerView) view.findViewById(R.id.rv_contributors);
        LinearLayoutManager llm2 = new LinearLayoutManager(mContext);
        rvContributors.setLayoutManager(llm2);
//        mContributorAdapter = new ContributorsAdapter();
        rvContributors.setAdapter(mContributorAdapter);

        mPresenter.onCreate(savedInstanceState);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mPresenter.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showContributors(List<Contributor> contributors) {
        mContributorAdapter.setData(contributors);
    }

    @Override
    public void showBranches(List<Branch> branches) {
        mBranchesAdapter.setData(branches);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

}
