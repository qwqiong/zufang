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
@Table(name = "house_source")
@Where(clause = "remove=false")
@SQLDelete(sql = "update house_source set remove=true,last_modified=now() where id=?")
public class HouseSource extends BaseEntity{
    /**
     * 小区
     */
    private String village;
    /**
     * 居室
     */
    private String zoneCount;
    /**
     * 楼号
     */
    private String buildingNo;
    /**
     * 价格
     */
    private String housePrice;
    /**
     * 朝向
     */
    private String orientation;
    /**
     * 电话
     */
    private String mobileNo;
}
