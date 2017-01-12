package gsi.reyst.rx.step.by.step.mappers;

import java.util.List;

import gsi.reyst.rx.step.by.step.model.DTO.ContributorDTO;
import gsi.reyst.rx.step.by.step.model.VO.Contributor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ContributorMapper implements Function<List<ContributorDTO>, List<Contributor>> {
    @Override
    public List<Contributor> apply(List<ContributorDTO> contributorDTOs) throws Exception {
        return Observable.fromIterable(contributorDTOs)
                .map(new Function<ContributorDTO, Contributor>() {
                    @Override
                    public Contributor apply(ContributorDTO contributorDTO) throws Exception {
                        return new Contributor(contributorDTO.getLogin());
                    }
                })
                .toList()
                .blockingGet();
    }
}
