package ibm.crawler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ibm.crawler.model.dto.DataURL;

@Repository
public interface URLRepository extends JpaRepository<DataURL, Long> {

	@Query("SELECT s FROM CRAWLER s WHERE s.URL LIKE %?1%")
	public List<DataURL> searchUrl(String inputString);

	// public List<DataURL> findByPlaceContaining(String inputString);

}
