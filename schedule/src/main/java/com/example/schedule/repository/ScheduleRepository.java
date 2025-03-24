package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ScheduleRepository {
    //저장
    ScheduleResponseDto saveSchedule(Schedule schedule);
    //전체목록
    List<ScheduleResponseDto> findAllSchedules();
    //일부목록
    Optional<Schedule> findScheduleById(long id);
    //오류잡는거
    Schedule findScheduleByIdOrElseThrow(Long id);
    //수정
    int updateSchedule(Long id, String title, String todo);
    //삭제
    int deleteSchedule(Long id, String password);
}
