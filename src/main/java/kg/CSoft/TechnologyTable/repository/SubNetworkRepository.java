package kg.CSoft.TechnologyTable.repository;

import kg.CSoft.TechnologyTable.entity.SubNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubNetworkRepository extends JpaRepository<SubNetwork, Long> {
    List<SubNetwork> findAllByProjectId(Long projectId);

    @Query("SELECT sn FROM SubNetwork sn WHERE lower(sn.name) LIKE coalesce(lower(cast(CONCAT('%',:search,'%') as text)),lower(sn.name)) OR " +
            "lower(sn.mask) LIKE coalesce(lower(cast(CONCAT('%',:search,'%') as text)),lower(sn.mask)) OR " +
            "lower(sn.address) LIKE coalesce(lower(cast(CONCAT('%',:search,'%') as text)),lower(sn.address)) OR " +
            "lower(sn.vlanName) LIKE coalesce(lower(cast(CONCAT('%',:search,'%') as text)),lower(sn.vlanName)) "
    )
    List<SubNetwork> subNetworkSearch(@Param("search") String search);
}
