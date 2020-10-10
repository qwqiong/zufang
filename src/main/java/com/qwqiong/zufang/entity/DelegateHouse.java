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
@Table(name = "delegate_source")
@Where(clause = "remove=false")
@SQLDelete(sql = "update delegate_source set remove=true,last_modified=now() where id=?")
public class DelegateHouse extends BaseEntity{
    /**
     * 委托价
     */
    private String delegatePrice;
    /**
     * 打款日
     */
    private String payDate;
    /**
     * 起租期
     */
    private String rentStartDate;
    /**
     * 截止日期
     */
    private String rentEndDate;
    /**
     * 配送成本
     */
    private String deliveryPrice;
    /**
     * 备注
     */
    private String comment;
}
