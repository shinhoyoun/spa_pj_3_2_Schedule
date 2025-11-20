package com.spa_pj_3_2_schedule_develop.dto.Schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * title
 * content
 */

@Getter
@NoArgsConstructor
public class ScheduleCreateRequest {
    @NotBlank
    @Size(max = 40)
    private String title;
    @NotBlank
    private String content;
}
