package gsi.reyst.rx.step.by.step.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import gsi.reyst.rx.step.by.step.DI.ComponentHolder;
import gsi.reyst.rx.step.by.step.mappers.RepositoryMapper;
import gsi.reyst.rx.step.by.step.model.VO.Repository;
import gsi.reyst.rx.step.by.step.views.RepoListView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static gsi.reyst.rx.step.by.step.Constants.KEY_REPO;
import static gsi.reyst.rx.step.by.step.Constants.KEY_REPO_LIST;

public class RepoListPresenter extends BasePresenter {

    private static final String LOGGER_TAG = "L_L_PRESENTER";

    @Inject
    RepositoryMapper mRepositoryMapper;

    private RepoListView mView;

    private List<Repository> mListRepositories;

    public RepoListPresenter(RepoListView view) {
        this.mView = view;

        ComponentHolder.getInstance().getAppComponent().inject(this);

        Log.d(LOGGER_TAG, "RepoListPresenter");
    }

    public void onSearchClick() {
        Log.d(LOGGER_TAG, "onSearchClick");
        String name = mView.getUserName();
        if (!TextUtils.isEmpty(name)) {
            Disposable subscription = dataRepository.getRepoList(name)
                    .map(mRepositoryMapper)
                    .subscribe(new Consumer<List<Repository>>() {
                                   @Override
                                   public void accept(List<Repository> data) throws Exception {
                                       if (data != null && !data.isEmpty()) {
                                           mListRepositories = data;
                                           mView.showData(data);
                                       } else {
                                           mView.showEmptyList();
                                       }
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    mView.showError(throwable.getLocalizedMessage());
                                }
                            });

            addDisposable(subscription);
        }
    }

    private boolean isRepoListEmpty() {
        return isListEmpty(mListRepositories);
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.d(LOGGER_TAG, "onSaveInstanceState: " + outState);
        if (!isRepoListEmpty()) {
            outState.putSerializable(KEY_REPO_LIST, new ArrayList<>(mListRepositories));
        }
        Log.d(LOGGER_TAG, "onSaveInstanceState: " + outState);
    }

    public void onCreate(Bundle inState) {
        Log.d(LOGGER_TAG, "onCreate: " + inState);
        if (inState != null) {
            //noinspection unchecked
            mListRepositories = (List<Repository>) inState.getSerializable(KEY_REPO_LIST);
            if (!isRepoListEmpty()) {
                mView.showData(mListRepositories);
            }
        }
        Log.d(LOGGER_TAG, "onCreate: " + inState);
    }

    public void onClickItem(Repository r) {
        Bundle param = new Bundle(1);
        param.putSerializable(KEY_REPO, r);
        mView.startRepoInfoFragment(param);
    }

}
