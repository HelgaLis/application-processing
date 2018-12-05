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
@Table(name="claim_app")
@PrimaryKeyJoinColumn(name = "clId")
public class ClaimApplication extends BaseApplication{
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	@Setter
	private int id;*/
	@Getter
	@Setter
	@Column(name="title")
	private String title;
	@Getter
	@Setter
	@Column(name="description")
	private String description;
}
