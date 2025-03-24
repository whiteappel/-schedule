package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        //요청받은 데이터를 스케쥴 객체 생성 id없이
        Schedule schedule = new Schedule(dto.getName(), dto.getPassword(), dto.getTodo(), LocalDateTime.now());

        return  scheduleRepository.saveSchedule(schedule);
    }

    //다찾는거
    @Override
    public List<ScheduleResponseDto> findAllSchedules(){
        return scheduleRepository.findAllSchedules();
    }


    //일부찾기
    @Override
    public ScheduleResponseDto findScheduleById(Long id){
        //없는거 방지
        Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleById(id);

        //npe방지
        if(optionalSchedule.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        return  new ScheduleResponseDto(optionalSchedule.get());
    }

    //수정
    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String name, String todo){

        if(name == null || todo == null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 설정");
        }

        int updatedRow = scheduleRepository.updateSchedule(id, name, todo);

        if(updatedRow == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "변경 사항 없음");
        }

        Optional<Schedule> optionSchedule = scheduleRepository.findScheduleById(id);

        return new ScheduleResponseDto(optionSchedule.get());
    }
    //삭제
    public int deleteSchedule(Long id,String password){

        int deletedRow = scheduleRepository.deleteSchedule(id, password);

        if (deletedRow == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " 잘못된 패스워드입니다");
        }
        return deletedRow;
    }


}
