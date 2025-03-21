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
public class scheduleContoroller {

    private final Map<Long, Schedule>scheduleList = new HashMap<>();
    //최초 생성
    @PostMapping
    private ResponseEntity<ScheduleResponseDto> createschedule(@RequestBody ScheduleRequestDto dto){
        long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        //식별자 1씩 증가
        Schedule schedule = new Schedule(scheduleId, dto.getTitle(),dto.getTodo());
        //요청데이터로  schedule 객체 생성

        scheduleList.put(scheduleId, schedule);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.CREATED);
    }

    //특정메모가져옴
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable long id){
        Schedule schedule = scheduleList.get(id);
        //없으면 없다고 떠라
        if(schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ScheduleResponseDto(schedule),HttpStatus.OK);
    }

    //모든메모를봄
    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules() {
        //init List
        List<ScheduleResponseDto> responseList =new ArrayList<>();

        for (Schedule schedule : scheduleList.values()){
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }
        return responseList;
    }

    //수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto>  updateScheduleById(
            @PathVariable long id,
            @RequestBody ScheduleRequestDto dto
    ){
        Schedule schedule = scheduleList.get(id);

        if (schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(dto.getTitle() == null || dto.getTodo() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        schedule.update(dto);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateTitle(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ){
        Schedule schedule = scheduleList.get(id);
        if (schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(dto.getTitle() == null || dto.getTodo() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        schedule.updateTitle(dto);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule),HttpStatus.OK);
    }

    //제거
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        if(scheduleList.containsKey(id)){
            scheduleList.remove(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
