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
@Table(name = "custom_source")
@Where(clause = "remove=false")
@SQLDelete(sql = "update custom_source set remove=true,last_modified=now() where id=?")
public class CustomSource extends BaseEntity{
    /**
     * 客户姓名
     */
    private String customName;
    /**
     * 需求户型
     */
    private String requireType;
    /**
     * 电话
     */
    private String mobileNo;
    /**
     * 需求价位
     */
    private String requirePrice;
    /**
     * 看房时间
     */
    private String visitTime;
    /**
     * 入住时间
     */
    private String inTime;
    /**
     * 备注
     */
    private String comment;
}
