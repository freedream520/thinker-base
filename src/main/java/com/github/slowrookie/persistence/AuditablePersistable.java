package com.github.slowrookie.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * 持久化映射父类
 * 
 * @author 刘佳兴
 */
@MappedSuperclass
public abstract class AuditablePersistable extends IdentityPersistable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(nullable = false)
	protected Long createdBy;
	
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
	
	@NotNull
	@Column(nullable = false)
	protected Long lastModifiedBy;
	
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;
	
	@NotNull
	@Column(nullable = false)
	protected Integer activity;

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date creationDate) {
		this.createdDate = creationDate;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}


}
