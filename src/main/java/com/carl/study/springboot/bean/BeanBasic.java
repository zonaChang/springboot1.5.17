package com.carl.study.springboot.bean;

import com.carl.study.springboot.util.DateUtils;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


/**
 * @author changez
 * @desc
 * @date 2019/3/10 11:30
 */
@Getter
@Accessors(chain = true)
@Component
public class BeanBasic {

	@Setter
	private Integer id;

	// TODO 私有后就不能访问了， 再添加一个字段表示更新时间。 业务字段和功能字段不混用？？？
	@Setter(AccessLevel.PRIVATE)
	protected Long updateTime;

	@Setter(AccessLevel.PRIVATE)
	protected Long createTime;


	protected void touchCreateTime() {
		this.createTime = DateUtils.currTime();
	}

	protected void touchUpdateTime() {
		this.updateTime = DateUtils.currTime();
	}

	@PrePersist
	public void fireCreated() {
		touchCreateTime();
		touchUpdateTime();
	}

	@PreUpdate
	public void fireUpdated() {
		touchUpdateTime();
	}
}
