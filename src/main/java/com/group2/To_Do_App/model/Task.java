package com.group2.To_Do_App.model;


import com.group2.To_Do_App.enums.PriorityLevel;
import com.group2.To_Do_App.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE task SET deleted_at = NOW() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PriorityLevel priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    private Date deletedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }
}

