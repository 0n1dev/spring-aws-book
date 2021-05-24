package com.dev.spring.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // BaseTimeEntity를 상속할 경우 해당 필드들도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함
public class BaseTimeEntity {

    @CreatedDate // Entity 생성시 자동으로 시간 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // Entity 값 변경시 자동 저장
    private LocalDateTime modifiedDate;
}
