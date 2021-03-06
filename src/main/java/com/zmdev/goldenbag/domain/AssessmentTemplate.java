package com.zmdev.goldenbag.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 考核模板
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AssessmentTemplate {

    @CreatedDate
    private Date createdAt;

    @Id
    @GeneratedValue
    private Long id;
    @LastModifiedDate
    private Date updatedAt;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "quarter_id")
    private Quarter quarter;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "assessmentTemplate")
    private Set<AssessmentProject> assessmentProjects;

    @OneToMany(mappedBy = "assessmentTemplate")
    private Set<AssessmentInput> assessmentInputs;

    public Quarter getQuarter() {
        return quarter;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<AssessmentProject> getAssessmentProjects() {
        return assessmentProjects;
    }

    public void setAssessmentProjects(Set<AssessmentProject> assessmentProjects) {
        this.assessmentProjects = assessmentProjects;
    }

    public Set<AssessmentInput> getAssessmentInputs() {
        return assessmentInputs;
    }

    public void setAssessmentInputs(Set<AssessmentInput> assessmentInputs) {
        this.assessmentInputs = assessmentInputs;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public enum Type {
        STAFF_TEMPLATE, // 員工模板
        MANAGER_TEMPLATE // 經理模板
    }
}
