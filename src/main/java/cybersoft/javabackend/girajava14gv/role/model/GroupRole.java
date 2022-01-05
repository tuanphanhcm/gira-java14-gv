package cybersoft.javabackend.girajava14gv.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cybersoft.javabackend.girajava14gv.common.model.BaseEntity;
import cybersoft.javabackend.girajava14gv.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "gira_group_role")
public class GroupRole extends BaseEntity {
	

	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "code", unique = true)
	private String code;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "gira_role_group_role",
		joinColumns = @JoinColumn(name = "group_role_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new LinkedHashSet<Role>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name 				= "gira_group_role_user",
		joinColumns 		= @JoinColumn(name = "group_role_id"),
		inverseJoinColumns 	= @JoinColumn(name = "user_id")
	)
	private Set<User> users = new LinkedHashSet<User>();
}
