package ibm.crawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.crawler.model.dto.DataURL;
import ibm.crawler.repository.URLRepository;

@Service
public class CrawlerService {

	@Autowired
	private URLRepository uRLRepository;

	public void addUrls(List<DataURL> request) throws Exception {
		checkNullRequest(request);

		for (DataURL dataURL : request) {

			uRLRepository.save(dataURL);
		}

	}

	public List<DataURL> getAllMatches(String inputString) {

		if (inputString != null) {
			return uRLRepository.searchUrl(inputString);
		}
		return null;

	}

	private void checkNullRequest(Object request) throws Exception {
		if (request == null) {
			throw new Exception();
		}

	}
}
