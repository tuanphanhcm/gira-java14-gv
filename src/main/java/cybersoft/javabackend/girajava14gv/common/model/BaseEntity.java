package cybersoft.javabackend.girajava14gv.common.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Version
	protected int version;
	
	@CreatedBy
	@Column(name = "created_by")
	protected String createdBy;
	
	@CreatedDate
	@Column(name = "created_at")
	protected LocalDateTime createAt;
	
	@LastModifiedBy
	@Column(name = "updated_by")
	protected String updatedBy;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;
}
