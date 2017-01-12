package gsi.reyst.rx.step.by.step.DI.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gsi.reyst.rx.step.by.step.mappers.BranchMapper;
import gsi.reyst.rx.step.by.step.mappers.ContributorMapper;
import gsi.reyst.rx.step.by.step.mappers.RepositoryMapper;

@Module
public class MappersModule {

    @Singleton
    @Provides
    public BranchMapper getBranchMapper() {
        return new BranchMapper();
    }

    @Singleton
    @Provides
    public ContributorMapper getContributorMapper() {
        return new ContributorMapper();
    }

    @Singleton
    @Provides
    public RepositoryMapper getRepositoryMapper() {
        return new RepositoryMapper();
    }
}
