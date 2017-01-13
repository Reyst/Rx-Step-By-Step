package gsi.reyst.rx.step.by.step.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

import javax.inject.Inject;

import gsi.reyst.rx.step.by.step.DI.ComponentHolder;
import gsi.reyst.rx.step.by.step.DI.modules.RepoListModule;
import gsi.reyst.rx.step.by.step.FragmentChanger;
import gsi.reyst.rx.step.by.step.R;
import gsi.reyst.rx.step.by.step.adapters.RepositoriesAdapter;
import gsi.reyst.rx.step.by.step.model.VO.Repository;
import gsi.reyst.rx.step.by.step.presenter.BasePresenter;
import gsi.reyst.rx.step.by.step.presenter.RepoListPresenter;
import gsi.reyst.rx.step.by.step.views.RepoListView;

public class RepoListFragment extends BaseFragment implements RepoListView {

    private static final String LOGGER_TAG = "L_LIST";

    @Inject
    RepoListPresenter mPresenter;

    private EditText searchEditText;

    @Inject
    RepositoriesAdapter mRepoAdapter;

    @Inject
    Context mContext;

    private View mFragmentView;

    public static RepoListFragment getInstance(Bundle params) {

        Log.d(LOGGER_TAG, "getInstance: " + params);

        RepoListFragment result = new RepoListFragment();
        result.setArguments(params);
        return result;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentHolder.getInstance().getRepoListComponent(this).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(LOGGER_TAG, "onCreateView: " + savedInstanceState);

        if (mFragmentView == null) {

            mFragmentView = inflater.inflate(R.layout.repo_list_fragment, container, false);

            searchEditText = (EditText) mFragmentView.findViewById(R.id.search_edit_text);
            mFragmentView.findViewById(R.id.btn_find).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.onSearchClick();
                }
            });

            RecyclerView rvRepoList = (RecyclerView) mFragmentView.findViewById(R.id.rv_repos);
            LinearLayoutManager llm = new LinearLayoutManager(mContext);
            rvRepoList.setLayoutManager(llm);
            mRepoAdapter = new RepositoriesAdapter(mPresenter);
            rvRepoList.setAdapter(mRepoAdapter);

            mPresenter.onCreate(savedInstanceState);

            setFragmentChanger((FragmentChanger) getActivity());

        }

        return mFragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
        Log.d(LOGGER_TAG, "onSaveInstanceState: " + outState);
        mFragmentView = null;
    }

    @Override
    public void showData(List<Repository> RepoList) {
        Log.d(LOGGER_TAG, "showData");
        mRepoAdapter.setData(RepoList);
    }

    @Override
    public void showEmptyList() {
        makeToast(getString(R.string.empty_repo_list));
    }

    @Override
    public String getUserName() {
        return searchEditText.getText().toString();
    }

    @Override
    public void startRepoInfoFragment(Bundle params) {
        try {
            FragmentChanger changer = getFragmentChanger();
            changer.changeFragment(changer.getFragmentInstance(BaseFragment.TYPE_REPOSITORY_INFO, params), true);
        } catch (Exception e) {
            showError(e.getLocalizedMessage());
        }
    }

    @Override
    protected BasePresenter getPresenter() {
        Log.d(LOGGER_TAG, "getPresenter");
        return mPresenter;
    }


}
