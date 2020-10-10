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
@Table(name = "house_tenant")
@Where(clause = "remove=false")
@SQLDelete(sql = "update house_tenant set remove=true,last_modified=now() where id=?")
public class HouseTenant extends BaseEntity{
    /**
     * 租户姓名
     */
    private String customName;
    /**
     * 身份证号
     */
    private String idNo;
    /**
     * 联系电话
     */
    private String mobileNo;
    /**
     * 承租价
     */
    private String rentPrice;
    /**
     * 起租日期
     */
    private String rentStartDate;
    /**
     * 截止日期
     */
    private String rentEndDate;
    /**
     * 交款日期
     */
    private String payDate;
    /**
     * 备注
     */
    private String comment;
}
