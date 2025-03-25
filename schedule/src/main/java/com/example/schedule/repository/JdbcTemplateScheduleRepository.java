package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //생성
    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule){
        //insert 퀴리 문자열 직접 작성안해도되게해줌 그리고 자동증가 ID
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");

        //현재시간 가져옴
        LocalDateTime now = LocalDateTime.now();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", schedule.getName());
        parameters.put("password", schedule.getPassword());
        parameters.put("todo", schedule.getTodo());
        parameters.put("createday", now);
        parameters.put("reportingday", now);//최초값은 수정일과 작성일 같으므로 이렇게 작성

        //저장후 생성된 key값 number 타입으로 반환
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        Schedule savedSchedule = new Schedule(key.longValue(), schedule.getName(),schedule.getPassword(), schedule.getTodo(), now, now);

        return new ScheduleResponseDto(savedSchedule);
    }
    //전체 조회
    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        return jdbcTemplate.query("select * from schedule ORDER BY reportingday ", scheduleRowMapper());
    }
    //일부 조회
    @Override
    public Optional<Schedule> findScheduleById(long id) {
        List<Schedule> result = jdbcTemplate.query("select * from schedule where id = ?", scheduleRowMapperV2(), id);

        return result.stream().findAny();
    }
    //수정
    @Override
    public int updateSchedule(Long id, String name, String todo){
        return jdbcTemplate.update("update schedule set name = ?, todo = ?, reportingday =?  where id = ?",name,todo,LocalDateTime.now(),id);
    }
    //삭제
    @Override
    public int deleteSchedule(Long id,String password) {
        return jdbcTemplate.update("delete from schedule where id = ? and password = ?", id, password);
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper(){
        return  new RowMapper<ScheduleResponseDto>() {

            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("todo"),
                        rs.getTimestamp("createday").toLocalDateTime(),
                        rs.getTimestamp("reportingday").toLocalDateTime()
                );
            }

        };
    }

    private RowMapper<Schedule> scheduleRowMapperV2(){
        return new RowMapper<Schedule>(){

                @Override
                public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Schedule(
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("todo"),
                        rs.getTimestamp("reportingday").toLocalDateTime()
                    );
                }

        };
    }

}