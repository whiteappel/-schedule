package com.example.schedule.controller;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    //일단 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchdule()

    @PostMapping
    private ResponseEntity<ScheduleResponseDto> createschedule(@RequestBody ScheduleRequestDto dto){
        long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        //식별자 1씩 증가
        schedule schedule = new schedule(scheduleId, dto.getTitle(),dto.getContents());
        //요청데이터로  schedule 객체 생성

        scheduleList.put(scheduleId, schedule);

        return new ResponseEntity<>(new scheduleResponseDto(schedule), HttpStatus.CREATED);
    }
    //모든 목록조회
    @GetMapping
    //단일 목록 조회
    @GetMapping("/{id}")
    //업데이트
    @PatchMapping("/{id}")
    //삭제
    @DeleteMapping("/{id}")

}
