package gsi.reyst.rx.step.by.step.views;

import java.util.List;

import gsi.reyst.rx.step.by.step.model.VO.Branch;
import gsi.reyst.rx.step.by.step.model.VO.Contributor;

public interface RepoInfoView extends IView {

    void showContributors(List<Contributor> contributors);

    void showBranches(List<Branch> branches);

}
