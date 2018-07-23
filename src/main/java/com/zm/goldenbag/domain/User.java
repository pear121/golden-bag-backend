package com.zm.goldenbag.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private Date entryTime;

    // 职级系数
    private float rankCoefficient;

    // 角色（岗位）
    private String role;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "direct_manager_id")
    private User directManager;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "indirect_manager_id")
    private User indirectManager;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "department_id")
    private Department department;

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

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public float getRankCoefficient() {
        return rankCoefficient;
    }

    public void setRankCoefficient(float rankCoefficient) {
        this.rankCoefficient = rankCoefficient;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getDirectManager() {
        return directManager;
    }

    public void setDirectManager(User directManager) {
        this.directManager = directManager;
    }

    public User getIndirectManager() {
        return indirectManager;
    }

    public void setIndirectManager(User indirectManager) {
        this.indirectManager = indirectManager;
    }
}
