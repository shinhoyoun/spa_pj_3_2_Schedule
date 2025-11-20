package com.spa_pj_3_2_schedule_develop.entity;


import com.spa_pj_3_2_schedule_develop.dto.Schedule.ScheduleCreateRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * id
 * username
 * title
 * content
 * password
 * created_at
 * modified_at
 */


@Getter
@Entity
@Table(name="schedules", indexes={@Index(name="idx_schedule_username_updated", columnList="username_id, updated_at")})
@NoArgsConstructor
public class Schedule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="username_id", nullable=false)
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private User username;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String content;

    @Builder
    public Schedule(User username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public static Schedule of(User username, String title, String content){
        return Schedule.builder()
                .username(username)
                .title(title)
                .content(content)
                .build();
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}

