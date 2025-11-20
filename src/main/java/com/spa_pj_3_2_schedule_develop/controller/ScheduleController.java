package com.spa_pj_3_2_schedule_develop.controller;

import com.spa_pj_3_2_schedule_develop.dto.Schedule.ScheduleCreateRequest;
import com.spa_pj_3_2_schedule_develop.dto.Schedule.ScheduleResponse;
import com.spa_pj_3_2_schedule_develop.dto.Schedule.ScheduleUpdateRequest;
import com.spa_pj_3_2_schedule_develop.service.ScheduleService;
import com.spa_pj_3_2_schedule_develop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 */

@RestController
@RequestMapping("/api/users/{userId}/schedules") // Input, start.
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;


    @PostMapping
    public ResponseEntity<ScheduleResponse> create(@PathVariable Long userId, @Valid @RequestBody ScheduleCreateRequest request) {
        ScheduleResponse response = scheduleService.create(userId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> update(@PathVariable Long userId, @PathVariable Long scheduleId, @Valid @RequestBody ScheduleUpdateRequest request) {
        ScheduleResponse response = scheduleService.update(userId, scheduleId, request);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable Long scheduleId) {
        scheduleService.delete(userId, scheduleId);

//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> get(@PathVariable Long userId, @PathVariable Long scheduleId) {
        ScheduleResponse response = scheduleService.get(userId, scheduleId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ScheduleResponse>> userGetAllList(@PathVariable Long userId, @PageableDefault(size = 10, sort = {"modifiedAt"}, direction = Sort.Direction.DESC)
                                                       Pageable pageable) {
        scheduleService.userGetAllList(userId, pageable);

//        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.list());
        return ResponseEntity.ok(scheduleService.userGetAllList(userId, pageable).map(ScheduleResponse::from));

    }

}
