package gsi.reyst.rx.step.by.step.model;

import java.util.List;

import gsi.reyst.rx.step.by.step.model.DTO.BranchDTO;
import gsi.reyst.rx.step.by.step.model.DTO.ContributorDTO;
import gsi.reyst.rx.step.by.step.model.DTO.RepositoryDTO;
import io.reactivex.Observable;

public interface Model {

    Observable<List<RepositoryDTO>> getRepoList(String name);

    Observable<List<BranchDTO>> getRepoBranches(String owner, String name);

    Observable<List<ContributorDTO>> getRepoContributors(String owner, String name);

}