package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;

import java.util.List;

public class ScheduleSericeImpl {

    public ScheduleSericeImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto){
        //요청받은 데이터를 스케쥴 객체 생성 id없이
        Schedule schedule = new Schedule(dto.getTodo(),dto.getreporting());

        //저장

        return scheduleRepository.saveSchdeule(schedule);

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule(){
        return scheduleRepository.findAllSchedule();
    }
}
