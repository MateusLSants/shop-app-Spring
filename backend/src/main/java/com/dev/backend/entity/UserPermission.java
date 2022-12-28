package com.dev.backend.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "userPermission")
@Data
public class UserPermission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "PermissionID")
    private Permission permission;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
}
