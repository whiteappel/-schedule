CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 자동 증가 ID
    todo VARCHAR(255) NOT NULL,            -- 할 일
    name VARCHAR(255) NOT NULL,            -- 작성자명
    password VARCHAR(255) NOT NULL,        -- 비밀번호
    written DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 작성일
    reporting DATETIME DEFAULT CURRENT_TIMESTAMP  -- 수정일 (수정 시 자동 갱신)
);