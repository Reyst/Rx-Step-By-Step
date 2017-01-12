package gsi.reyst.rx.step.by.step.DI.components;

import dagger.Subcomponent;
import gsi.reyst.rx.step.by.step.DI.modules.RepoListModule;
import gsi.reyst.rx.step.by.step.DI.scopes.PerFragment;
import gsi.reyst.rx.step.by.step.views.fragments.RepoListFragment;

@PerFragment
@Subcomponent(modules = {RepoListModule.class})
public interface RepoListComponent {

    void inject(RepoListFragment fragment);

}
