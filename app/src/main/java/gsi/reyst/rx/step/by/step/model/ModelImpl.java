package gsi.reyst.rx.step.by.step.model;


import java.util.List;

import javax.inject.Inject;

import gsi.reyst.rx.step.by.step.ApiInterface;
import gsi.reyst.rx.step.by.step.DI.ComponentHolder;
import gsi.reyst.rx.step.by.step.model.DTO.BranchDTO;
import gsi.reyst.rx.step.by.step.model.DTO.ContributorDTO;
import gsi.reyst.rx.step.by.step.model.DTO.RepositoryDTO;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ModelImpl implements Model {

    @Inject
    ApiInterface apiInterface;

    public ModelImpl() {
        ComponentHolder.getInstance().getAppComponent().inject(this);
    }

    @Override
    public Observable<List<RepositoryDTO>> getRepoList(String name) {
        return apiInterface.getRepositories(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<BranchDTO>> getRepoBranches(String owner, String name) {
        return apiInterface.getBranches(owner, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<ContributorDTO>> getRepoContributors(String owner, String name) {
        return apiInterface.getContributors(owner, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}