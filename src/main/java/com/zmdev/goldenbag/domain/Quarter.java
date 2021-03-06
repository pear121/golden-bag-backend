package com.zmdev.goldenbag.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 季度表
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Quarter {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Date startDate;

    private Date startAssessmentDate;

    private Double price;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @OneToMany(mappedBy = "quarter")
    private Set<AssessmentTemplate> assessmentTemplates;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartAssessmentDate() {
        return startAssessmentDate;
    }

    public void setStartAssessmentDate(Date startAssessmentDate) {
        this.startAssessmentDate = startAssessmentDate;
    }

    public Set<AssessmentTemplate> getAssessmentTemplates() {
        return assessmentTemplates;
    }

    public void setAssessmentTemplates(Set<AssessmentTemplate> assessmentTemplates) {
        this.assessmentTemplates = assessmentTemplates;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
}
