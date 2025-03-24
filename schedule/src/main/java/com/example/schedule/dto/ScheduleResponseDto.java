package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    // id, `할일`, `작성자명`, `비밀번호`, `작성/수정일`(형식 : YYYY-MM-DD)을 저장 id는 자동생성
//주의: `작성/수정일`은 날짜와 시간을 모두 포함한 형태 최초 입력 시, 수정일은 작성일과 동일
    private final long id; //만들때 따로 지정안하도록 주의해야함
    private final String name;//이름
    private final String password;//비번
    private final String todo;//할일
    private final LocalDateTime createday;//최초
    private final LocalDateTime reportingday;//수정

    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.password = schedule.getPassword();
        this.todo = schedule.getTodo();
        this.createday = schedule.getCreateday();
        this.reportingday = schedule.getReportingday();
    }


    public ScheduleResponseDto(long id, String name, String password, String todo, LocalDateTime createday, LocalDateTime reportingday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.todo = todo;
        this.createday = createday;
        this.reportingday = reportingday;
    }
}
