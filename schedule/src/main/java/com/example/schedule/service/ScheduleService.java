package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ScheduleService {
    //일단 저장
    //모든 목록조회
    //단일 목록 조회
    //업데이트
    //삭제
    ScheduleResponseDto saveSchedule(ScheduleResponseDto dto);
    List
}
