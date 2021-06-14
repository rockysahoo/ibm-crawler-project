package ibm.crawler.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="crawler")
@Data
public class DataURL {
	
	@Id
	private int ID;
	
	@Column(name="URL")
	private String urls;

}
