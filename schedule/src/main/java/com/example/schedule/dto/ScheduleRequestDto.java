package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {
    // id, `할일`, `작성자명`, `비밀번호`, `작성/수정일`(형식 : YYYY-MM-DD)을 저장 id는 자동생성
//주의: `작성/수정일`은 날짜와 시간을 모두 포함한 형태 최초 입력 시, 수정일은 작성일과 동일
    private long id; //만들때 따로 지정안하도록 주의해야함
    private String name;//이름
    private String password;//비번
    private String todo;//할일
    private LocalDateTime createday;
    private LocalDateTime reportingday;

}
