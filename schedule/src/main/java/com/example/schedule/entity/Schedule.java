package com.example.schedule.entity;

import com.example.schedule.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
// id, `할일`, `작성자명`, `비밀번호`, `작성/수정일`(형식 : YYYY-MM-DD)을 저장 id는 자동생성
//주의: `작성/수정일`은 날짜와 시간을 모두 포함한 형태 최초 입력 시, 수정일은 작성일과 동일
    private long id; //만들때 따로 지정안하도록 주의해야함
    private String todo;//할일
    private String name;//작성자명
    private String password;//비밀번호
    private LocalDateTime createday;//작성일
    private LocalDateTime reportingday;//수정일

    //가져올떄 할일 작성자명 작성일/수정일 최초수정일은 작성일과 동일하다
    public Schedule(String todo, String name,String password,LocalDateTime createday) {
        this.todo = todo;
        this.name = name;
        this.password = password;
        this.createday = createday;
        this.reportingday =createday;//동일 설정
    }

    public void update(String todo) {
        this.todo = todo;
        this.reportingday = LocalDateTime.now();
    }




}
