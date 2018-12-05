package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name="signed_app")
@PrimaryKeyJoinColumn(name = "signedId")
public class SignedApplication extends BaseApplication {
	@Getter
	@Setter
	@Column(name="author_name")
	private String authorName;
	
}
