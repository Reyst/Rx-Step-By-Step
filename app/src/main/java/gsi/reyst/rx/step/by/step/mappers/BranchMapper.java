package gsi.reyst.rx.step.by.step.mappers;

import java.util.List;

import gsi.reyst.rx.step.by.step.model.DTO.BranchDTO;
import gsi.reyst.rx.step.by.step.model.VO.Branch;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class BranchMapper implements Function<List<BranchDTO>, List<Branch>> {
    @Override
    public List<Branch> apply(List<BranchDTO> branchDTOs) throws Exception {
        return Observable
                .fromIterable(branchDTOs)
                .map(new Function<BranchDTO, Branch>() {
                    @Override
                    public Branch apply(BranchDTO branchDTO) throws Exception {
                        return new Branch(branchDTO.getName());
                    }
                })
                .toList()
                .blockingGet();
    }
}
