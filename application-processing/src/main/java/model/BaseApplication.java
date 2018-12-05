package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Entity
@Table(name="base_app")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseApplication {
	@Id
	@Column(name="id")
	@Getter
	@Setter
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
}
