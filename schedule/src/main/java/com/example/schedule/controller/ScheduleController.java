package com.example.schedule.controller;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //일단 생성
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {
        return scheduleService.saveSchedule(dto);
    }

    //모든 목록조회
    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleService.findAllSchedules();
    }

    //단일 목록 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleById(@PathVariable("id") Long id) {
        return scheduleService.findScheduleById(id);
    }

    //업데이트
    @PatchMapping("/{id}")
    public ScheduleResponseDto updateSchedule(
            @PathVariable("id") Long id,
            @RequestBody ScheduleRequestDto dto) {
        return scheduleService.updateSchedule(id, dto.getName(), dto.getTodo());
    }

    //삭제
    @DeleteMapping("/{id}")
    public int deleteSchedule(
            @PathVariable("id") Long id,
            @RequestBody Map<String, String> request) {
        String password = request.get("password");
        {
            return scheduleService.deleteSchedule(id, password);
        }

    }
}
