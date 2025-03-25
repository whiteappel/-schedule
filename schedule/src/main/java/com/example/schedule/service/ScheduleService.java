package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    //일단 저장
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);
    //모든 목록조회
    List<ScheduleResponseDto> findAllSchedules();
    //단일 목록 조회
    ScheduleResponseDto findScheduleById(Long id);
    //업데이트
    ScheduleResponseDto updateSchedule(Long id, String name, String todo);
    //삭제
    int deleteSchedule(Long id, String password);
}
