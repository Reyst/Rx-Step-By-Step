package gsi.reyst.rx.step.by.step.DI.modules;

import dagger.Module;
import dagger.Provides;
import gsi.reyst.rx.step.by.step.DI.scopes.PerFragment;
import gsi.reyst.rx.step.by.step.adapters.BranchesAdapter;
import gsi.reyst.rx.step.by.step.adapters.ContributorsAdapter;
import gsi.reyst.rx.step.by.step.model.VO.Repository;
import gsi.reyst.rx.step.by.step.presenter.RepoInfoPresenter;
import gsi.reyst.rx.step.by.step.views.RepoInfoView;

@Module
public class RepoInfoModule {

    private Repository mRepository;
    private RepoInfoView mView;

    public RepoInfoModule(RepoInfoView view, Repository repository) {
        this.mRepository = repository;
        mView = view;
    }

    @PerFragment
    @Provides
    public RepoInfoPresenter getPresenter() {
        return new RepoInfoPresenter(mView, mRepository);
    }

    @PerFragment
    @Provides
    public BranchesAdapter getBranchesAdapter() {
        return new BranchesAdapter();
    }

    @PerFragment
    @Provides
    public ContributorsAdapter getContributorsAdapter() {
        return new ContributorsAdapter();
    }

}
