package com.github.slowrookie.persistence;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

/**
 * 需要保存修改信息的映射父类
 * 
 * @author 刘佳兴
 */
@MappedSuperclass
public abstract class AuditablePersistable extends IdentityPersistable implements Auditable<Long, Long>{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	protected Long createdBy;
	
	@Column(nullable = false)
	protected DateTime createdDate;
	
	@Column(nullable = false)
	protected Long lastModifiedBy;
	
	@Column(nullable = false)
	protected DateTime lastModifiedDate;
	
	@Column(nullable = false)
	protected Integer activity;

	@Override
	public Long getCreatedBy() {
		return createdBy;
	}

	@Override
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override
	public void setCreatedDate(DateTime creationDate) {
		this.createdDate = creationDate;
	}

	@Override
	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	@Override
	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	@Override
	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}


}
