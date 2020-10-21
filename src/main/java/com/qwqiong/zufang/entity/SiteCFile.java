package com.qwqiong.zufang.entity;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "site_file")
@Where(clause = "remove=false")
@SQLDelete(sql = "update site_file set remove=true,last_modified=now() where id=?")
public class SiteCFile extends BaseEntity{
	private String objectId;
	
	private String fileUrl;
	
	private String isTemp;

}
