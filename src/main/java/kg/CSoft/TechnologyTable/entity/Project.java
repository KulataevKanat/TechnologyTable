package kg.CSoft.TechnologyTable.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "varchar")
    private String name;

    @Column(name = "description", columnDefinition = "varchar")
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_cn",
            joinColumns = @JoinColumn(name = "project_id"),
            indexes = @Index(columnList = "project_id"))
    @Column(name = "user_cn", nullable = false)
    private List<String> cnList = new ArrayList<>();


    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCnList() {
        return cnList;
    }

    public void setCnList(List<String> cnList) {
        this.cnList = cnList;
    }
}
