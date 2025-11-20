package com.spa_pj_3_2_schedule_develop.Config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing  // 타이머 기능 연관
public class JPAConfig {
}
