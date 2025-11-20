package com.spa_pj_3_2_schedule_develop.dto.Schedule;

import com.spa_pj_3_2_schedule_develop.entity.Schedule;
import com.spa_pj_3_2_schedule_develop.entity.User;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 출력값
 * id
 * title
 * content
 * username
 * + createdAt , LastModifiedAt
 */

@Value //
public class ScheduleResponse {

    Long id;

//    Long scheduleUserId;
//    String scheduleUsername;

    String title;
    String content;

    User username;

    LocalDateTime createdAt;
    LocalDateTime modifiedAt;

    public static ScheduleResponse from(Schedule s) {
        return new ScheduleResponse(
                s.getId(),
//                s.getScheduleUsername().getId(),
//                s.getScheduleUsername().getUsername(),
                s.getTitle(),
                s.getContent(),
                s.getUsername(),
                s.getCreatedAt(),
                s.getModifiedAt()
        );
    }

    public List<ScheduleResponse> toScheduleResponseList(List<Schedule> schedules) {
        return schedules.stream()
                .map(this::from)
                .toList();
    }

}