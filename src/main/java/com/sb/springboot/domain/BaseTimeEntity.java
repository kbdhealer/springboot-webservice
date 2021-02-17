package com.sb.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //when JPA entity classes inherit BaseTimeEntity, create @createdDate,@LastModifiedDate as columns
@EntityListeners(AuditingEntityListener.class) // include auditing for this class
public abstract class BaseTimeEntity {

    @CreatedDate // date time stored automatically when Entity created
    private LocalDateTime createdDate;

    @LastModifiedDate // date time stored automatically when field value in entity retrieved and changed
    private LocalDateTime modifiedDate;
}
