package gsi.reyst.rx.step.by.step.mappers;

import java.util.List;

import gsi.reyst.rx.step.by.step.model.DTO.RepositoryDTO;
import gsi.reyst.rx.step.by.step.model.VO.Repository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class RepositoryMapper implements Function<List<RepositoryDTO>, List<Repository>> {
    @Override
    public List<Repository> apply(List<RepositoryDTO> repositoryDTOs) throws Exception {
        return Observable.fromIterable(repositoryDTOs)
                .map(new Function<RepositoryDTO, Repository>() {
                    @Override
                    public Repository apply(RepositoryDTO repoDTO) throws Exception {
                        return new Repository(repoDTO.getId(), repoDTO.getName(), repoDTO.getOwner().getLogin());
                    }
                })
                .toList()
                .blockingGet();
    }
}
