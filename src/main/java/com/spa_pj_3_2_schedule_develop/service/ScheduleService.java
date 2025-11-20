package com.spa_pj_3_2_schedule_develop.service;

import com.spa_pj_3_2_schedule_develop.dto.Schedule.ScheduleCreateRequest;
import com.spa_pj_3_2_schedule_develop.dto.Schedule.ScheduleResponse;
import com.spa_pj_3_2_schedule_develop.dto.Schedule.ScheduleUpdateRequest;
import com.spa_pj_3_2_schedule_develop.entity.Schedule;
import com.spa_pj_3_2_schedule_develop.entity.User;
import com.spa_pj_3_2_schedule_develop.repository.ScheduleRepository;
import com.spa_pj_3_2_schedule_develop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponse create(Long userId, ScheduleCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid UserId : " + userId));

        Schedule schedule = Schedule.of(user, request.getTitle(), request.getContent());

        scheduleRepository.save(schedule);

        return ScheduleResponse.from(schedule);
    }

    @Transactional
    public ScheduleResponse update(Long userId, Long scheduleId, ScheduleUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid UserId : " + userId));

//        Schedule.update(request.getTitle(), request.getContent());
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid scheduleId : " + scheduleId));
        schedule.update(request.getTitle(), request.getContent());

        return ScheduleResponse.from(schedule);
    }

    @Transactional
    public void delete(Long userId, Long scheduleId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid UserId : " + userId));

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid scheduleId : " + scheduleId));

        if (!user.getId().equals(schedule.getUsername().getId())) {
            throw new IllegalArgumentException("Invalid Content");
        }

        scheduleRepository.delete(schedule);
    }


    @Transactional(readOnly = true)
    public ScheduleResponse get(Long userId, Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("Invalid scheduleId : " + scheduleId));

        return ScheduleResponse.from(schedule);
    }


    @Transactional(readOnly = true)
    public Page<Schedule> userGetAllList(Long userId, Pageable pageable) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid UserID"));
        return scheduleRepository.findAllByUsernameOrderByModifiedAtDesc(user, pageable);

    }

}
