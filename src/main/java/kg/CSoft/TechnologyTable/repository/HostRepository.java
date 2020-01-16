package kg.CSoft.TechnologyTable.repository;

import kg.CSoft.TechnologyTable.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
    List<Host> findAllBySubNetworkId(Long subNetworkId);

    @Query("SELECT h FROM Host h WHERE lower(h.login) LIKE coalesce(lower(cast(CONCAT('%',:login,'%') as text)),lower(h.login)) ")
    List<Host> hostSearchByLogin(@Param("login") String login);

    @Query("SELECT h FROM Host h WHERE lower(h.ipAddress) LIKE coalesce(lower(cast(CONCAT('%',:ipAddress,'%') as text)),lower(h.ipAddress)) ")
    List<Host> hostSearchByIpAddress(@Param("ipAddress") String ipAddress);

}
