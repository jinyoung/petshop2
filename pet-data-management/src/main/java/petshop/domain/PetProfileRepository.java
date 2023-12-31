package petshop.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshop.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "petProfiles",
    path = "petProfiles"
)
public interface PetProfileRepository
    extends PagingAndSortingRepository<PetProfile, Long> {}
