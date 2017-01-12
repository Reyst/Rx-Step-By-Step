package gsi.reyst.rx.step.by.step.DI.components;

import dagger.Subcomponent;
import gsi.reyst.rx.step.by.step.DI.modules.RepoInfoModule;
import gsi.reyst.rx.step.by.step.DI.scopes.PerFragment;
import gsi.reyst.rx.step.by.step.views.fragments.RepoInfoFragment;

@PerFragment
@Subcomponent(modules = {RepoInfoModule.class})
public interface RepoInfoComponent {

    void inject(RepoInfoFragment fragment);

}
