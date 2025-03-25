package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;


import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    //저장
    ScheduleResponseDto saveSchedule(Schedule schedule);
    //전체목록
    List<ScheduleResponseDto> findAllSchedules();
    //일부목록
    Optional<Schedule> findScheduleById(long id);
    //수정
    int updateSchedule(Long id, String name, String todo);
    //삭제
    int deleteSchedule(Long id, String password);
}
