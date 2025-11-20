package com.spa_pj_3_2_schedule_develop.repository;

import com.spa_pj_3_2_schedule_develop.entity.Schedule;
import com.spa_pj_3_2_schedule_develop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    Page<Schedule> findAllByUsernameOrderByModifiedAtDesc(User user, Pageable pageable);
}
