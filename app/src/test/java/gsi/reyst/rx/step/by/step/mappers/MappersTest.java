package gsi.reyst.rx.step.by.step.mappers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import gsi.reyst.rx.step.by.step.BuildConfig;
import gsi.reyst.rx.step.by.step.TestUtils;
import gsi.reyst.rx.step.by.step.model.DTO.RepositoryDTO;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MappersTest {

    @Inject
    TestUtils mTestUtils;

    List<RepositoryDTO> mRepoDTOList;

//    @Inject
//    List<BranchDTO> BranchDTOList;
//
//    @Inject
//    List<ContributorDTO> ContributorDTOList;

    @Inject
    RepositoryMapper mRepoListMapper;

    @Inject
    BranchMapper mBranchMapper;

    @Inject
    ContributorMapper mContributorMapper;

    @Before
    public void setUp() throws Exception {

        RepositoryDTO[] repositoryDTOArray = mTestUtils.getGson().fromJson(mTestUtils.readString("json/repos.json"), RepositoryDTO[].class);
        mRepoDTOList = Arrays.asList(repositoryDTOArray);

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testRepoListMapper() {

    }

}
