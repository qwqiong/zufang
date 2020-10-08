package com.qwqiong.zufang.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Where(clause = "remove=false")
@SQLDelete(sql = "update user set remove=true,last_modified=now() where id=?")
public class User extends BaseEntity{
    private String userName;
    private String password;
    private String role;
}
