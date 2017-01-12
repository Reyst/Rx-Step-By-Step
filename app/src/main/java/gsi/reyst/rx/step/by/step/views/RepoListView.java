package gsi.reyst.rx.step.by.step.views;

import android.os.Bundle;

import java.util.List;

import gsi.reyst.rx.step.by.step.model.VO.Repository;

public interface RepoListView extends IView {

    void showData(List<Repository> RepoList);

    void showEmptyList();

    String getUserName();

    void startRepoInfoFragment(Bundle params);

}
