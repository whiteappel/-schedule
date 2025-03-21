package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl {

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto){
        //요청받은 데이터를 스케쥴 객체 생성 id없이
        Schedule schedule = new Schedule(dto.getTitle(),dto.getTodo());

        //저장

        return scheduleRepository.saveSchdeule(schedule);

    }
    @Override
    public List<ScheduleResponseDto> findAllSchedule(Long id){

        Optional<Schedule> optionalSchedule = ScheduleRepository.findMemoById(id);

        if(optionalSchedule.isEmpty()){
            throw new ResponseStatusException(optionalSchedule.get());
        }

        return scheduleRepository(optionalSchedule.get());
    }
}
