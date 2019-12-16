package kg.CSoft.TechnologyTable.repository;

import kg.CSoft.TechnologyTable.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p WHERE lower(p.name) LIKE coalesce(lower(cast(CONCAT('%',:name,'%') as text)),lower(p.name)) ")
    List<Project> projectSearchByName(@Param("name") String name);
}
