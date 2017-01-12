package gsi.reyst.rx.step.by.step;

import java.util.List;

import gsi.reyst.rx.step.by.step.model.DTO.BranchDTO;
import gsi.reyst.rx.step.by.step.model.DTO.ContributorDTO;
import gsi.reyst.rx.step.by.step.model.DTO.RepositoryDTO;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("users/{user}/repos")
    Observable<List<RepositoryDTO>> getRepositories(@Path("user") String user);

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<ContributorDTO>> getContributors(@Path("owner") String owner, @Path("repo") String repo);

    @GET("/repos/{owner}/{repo}/branches")
    Observable<List<BranchDTO>> getBranches(@Path("owner") String owner, @Path("repo") String repo);

}