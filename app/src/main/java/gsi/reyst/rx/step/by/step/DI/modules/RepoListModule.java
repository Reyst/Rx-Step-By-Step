package gsi.reyst.rx.step.by.step.DI.modules;

import dagger.Module;
import dagger.Provides;
import gsi.reyst.rx.step.by.step.DI.scopes.PerFragment;
import gsi.reyst.rx.step.by.step.adapters.RepositoriesAdapter;
import gsi.reyst.rx.step.by.step.presenter.RepoListPresenter;
import gsi.reyst.rx.step.by.step.views.RepoListView;

@Module
public class RepoListModule {

    private RepoListView mView;

    public RepoListModule(RepoListView view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public RepoListPresenter getPresenter() {
        return new RepoListPresenter(mView);
    }

    @PerFragment
    @Provides
    public RepositoriesAdapter getAdapter(RepoListPresenter presenter) {
        return new RepositoriesAdapter(presenter);
    }

}
