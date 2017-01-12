package gsi.reyst.rx.step.by.step.presenter;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import gsi.reyst.rx.step.by.step.DI.ComponentHolder;
import gsi.reyst.rx.step.by.step.mappers.BranchMapper;
import gsi.reyst.rx.step.by.step.mappers.ContributorMapper;
import gsi.reyst.rx.step.by.step.model.VO.Branch;
import gsi.reyst.rx.step.by.step.model.VO.Contributor;
import gsi.reyst.rx.step.by.step.model.VO.Repository;
import gsi.reyst.rx.step.by.step.views.RepoInfoView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static gsi.reyst.rx.step.by.step.Constants.KEY_BRANCHES_LIST;
import static gsi.reyst.rx.step.by.step.Constants.KEY_CONTRIBUTORS_LIST;

public class RepoInfoPresenter extends BasePresenter {

    private RepoInfoView mView;

    @Inject
    BranchMapper mBranchMapper;

    @Inject
    ContributorMapper mContributorMapper;

    private List<Branch> mBranches;
    private List<Contributor> mContributors;

    private Repository mRepository;

    public RepoInfoPresenter(RepoInfoView view, Repository repo) {
        this.mView = view;
        mRepository = repo;

        ComponentHolder.getInstance().getAppComponent().inject(this);
    }

    public void onSaveInstanceState(Bundle outState) {
        if (!isListEmpty(mBranches)) {
            outState.putSerializable(KEY_BRANCHES_LIST, new ArrayList<>(mBranches));
        }

        if (!isListEmpty(mContributors)) {
            outState.putSerializable(KEY_CONTRIBUTORS_LIST, new ArrayList<>(mContributors));
        }
    }

    public void onCreate(Bundle inState) {
        if (inState != null) {
            //noinspection unchecked
            mBranches = (List<Branch>) inState.getSerializable(KEY_BRANCHES_LIST);
            if (!isListEmpty(mBranches)) {
                mView.showBranches(mBranches);
            }

            //noinspection unchecked
            mContributors = (List<Contributor>) inState.getSerializable(KEY_CONTRIBUTORS_LIST);
            if (!isListEmpty(mContributors)) {
                mView.showContributors(mContributors);
            }
        }

        if (isListEmpty(mBranches) || isListEmpty(mContributors)) {
            loadData();
        }

    }

    private void loadData() {
        Disposable subs1 = dataRepository
                .getRepoBranches(mRepository.getOwner(), mRepository.getName())
                .map(mBranchMapper)
                .subscribe(new Consumer<List<Branch>>() {
                    @Override
                    public void accept(List<Branch> data) throws Exception {
                        if (data != null) {
                            mBranches = data;
                            mView.showBranches(data);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable.getLocalizedMessage());
                    }
                });

        addDisposable(subs1);

        Disposable subs2 = dataRepository
                .getRepoContributors(mRepository.getOwner(), mRepository.getName())
                .map(mContributorMapper)
                .subscribe(new Consumer<List<Contributor>>() {
                    @Override
                    public void accept(List<Contributor> data) throws Exception {
                        if (data != null) {
                            mContributors = data;
                            mView.showContributors(data);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable.getLocalizedMessage());
                    }
                });

        addDisposable(subs2);
    }

}
