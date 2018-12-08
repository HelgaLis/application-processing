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
	@Column(name="author_name")
	private String authorName;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return super.toString()+" SignedApplication [authorName=" + authorName + "]";
	}
	
}
