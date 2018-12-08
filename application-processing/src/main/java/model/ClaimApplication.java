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

	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return super.toString()+" ClaimApplication [title=" + title + ", description=" + description + "]";
	}
}
