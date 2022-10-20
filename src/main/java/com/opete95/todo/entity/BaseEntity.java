package com.opete95.todo.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//Entity를 별도로 생성하지 않는 클래스
@MappedSuperclass
//JPA를 감시하고 있다가 동작하도록 설정
@EntityListeners(value={AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
    @CreatedDate
    @Column(name="regdate",updatable = false)
    private LocalDateTime regDate;

    @CreatedDate
    @Column(name="moddate")
    private LocalDateTime modDate;

}
