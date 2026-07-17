package com.flagly.api.project;

import com.flagly.api.common.entity.BaseEntity;
import com.flagly.api.organization.Organization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="organization_id", nullable=false)
    private Organization organization;

}
