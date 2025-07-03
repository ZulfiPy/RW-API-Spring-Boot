package com.rw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Designer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String designTools;

    public Designer() {
    }

    public Designer(Integer id, String name, String designTools) {
        this.id = id;
        this.name = name;
        this.designTools = designTools;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignTools() {
        return designTools;
    }

    public void setDesignTools(String designTools) {
        this.designTools = designTools;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Designer designer = (Designer) o;
        return Objects.equals(id, designer.id) && Objects.equals(name, designer.name) && Objects.equals(designTools, designer.designTools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, designTools);
    }

    @Override
    public String toString() {
        return "Designer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designTools='" + designTools + '\'' +
                '}';
    }
}
