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

    @Query("SELECT sn FROM SubNetwork sn WHERE lower(sn.name) LIKE coalesce(lower(cast(CONCAT('%',:name,'%') as text)),lower(sn.name)) ")
    List<SubNetwork> subNetworkSearchByName(@Param("name") String name);

    @Query("SELECT sn FROM SubNetwork sn WHERE lower(sn.mask) LIKE coalesce(lower(cast(CONCAT('%',:mask,'%') as text)),lower(sn.mask)) ")
    List<SubNetwork> subNetworkSearchByMask(@Param("mask") String mask);

    @Query("SELECT sn FROM SubNetwork sn WHERE lower(sn.address) LIKE coalesce(lower(cast(CONCAT('%',:address,'%') as text)),lower(sn.address)) ")
    List<SubNetwork> subNetworkSearchByAddress(@Param("address") String address);

    @Query("SELECT sn FROM SubNetwork sn WHERE lower(sn.vlanName) LIKE coalesce(lower(cast(CONCAT('%',:vlanName,'%') as text)),lower(sn.vlanName)) ")
    List<SubNetwork> subNetworkSearchByVlanName(@Param("vlanName") String vlanName);

}
