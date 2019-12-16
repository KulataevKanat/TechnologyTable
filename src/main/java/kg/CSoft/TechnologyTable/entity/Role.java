package kg.CSoft.TechnologyTable.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "integer")
    private Long id;
    @Column(name = "name", columnDefinition = "varchar", unique = true)
    private String name;
    @Column(name = "text", columnDefinition = "varchar")
    private String text;
    @ElementCollection
    @CollectionTable(name = "users_cn",
            joinColumns = @JoinColumn(name = "role_id"),
            indexes = @Index(columnList = "role_id"))
    @Column(name = "user_cn", nullable = false)
    private Set<String> cnList;

    public Role() {
    }

    public Role(String name, String text) {
        this.name = name;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getCnList() {
        return cnList;
    }

    public void setCnList(Set<String> cnList) {
        this.cnList = cnList;
    }
}
