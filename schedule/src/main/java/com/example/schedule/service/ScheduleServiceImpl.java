package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{


    /*
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto){
        //요청받은 데이터를 스케쥴 객체 생성 id없이
        Schedule schedule = new Schedule(dto.getTitle(), dto.getTodo());

        //저장
        return scheduleRepository.saveSchedule(schedule);

    }

    public ScheduleResponseDto findAllSchedules(Long id){

        Optional<Schedule> optionalSchedule = ScheduleRepository.findScheduleById(id);

        if(optionalSchedule.isEmpty()){
            throw new ResponseStatusException(optionalSchedule.get());
        }

        return new ScheduleResponseDto(optionalSchedule.get());
    }




    @Override
    public ScheduleResponseDto findScheduleById(long id){

        Optional<Schedule> optionalSchedule = ScheduleRepository.findScheduleById(id);

        //npe방지
        if(optionalSchedule.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        return  new ScheduleResponseDto(optionalSchedule.get());
    }

    @Transactional
    @Override
    public int updateSchedule(Long id, String title, String todo){

        if(title == null || todo ==null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 설정");
        }

        int updatedRow = scheduleRepository.updateSchedule(id, title, todo);

        if(updatedRow == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "없음");
        }


        Optional<ScheduleResponseDto> optionSchedule = scheduleRepository.findScheduleById(id);

        return new ScheduleResponseDto(optionSchedule.get());
    }

    @Transactional
    @Override
    public ScheduleResponseDto updateTitle(Long id, String title){
        //검증
        if(title == null ){
            return new ResponseStatusException(HttpStatus.BAD_REQUEST,"타이틀 수정할거없음");
        }
        //제목수정
        int updateRow = scheduleRepository.updateTitle(id, title);
        //수정이없으면
        if (updateRow == 0){
            return new ResponseStatusException(HttpStatus.NOT_FOUND,"수정 없음");
        }

        return  new ScheduleResponseDto(ScheduleRepository.findScheduleById(id).get());
    }

    public int deleteSchedule(Long id){

        int deletedRow = scheduleRepository.deleteSchedule(id);

        if (deletedRow == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id ="+id);
        }
    }

     */
}
