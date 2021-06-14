package ibm.crawler.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ibm.crawler.model.dto.DataURL;
import ibm.crawler.service.CrawlerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/crawler")
public class CrawlerController {
	
	
	Logger logger=Logger.getLogger(CrawlerController.class);
	
	@Autowired
	private CrawlerService service;
	
	private final String className = this.getClass().getSimpleName();
	String methodName;
	
	@ApiOperation(value = "Add URLs", notes = "Add Urls")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Added"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/add/addUrls" }, method = RequestMethod.POST)
	public ResponseEntity<Object> addUrls(@RequestBody List<DataURL> request)
			throws Exception {
		try {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			service.addUrls(request);

		} catch (Exception e) {
			logger.error(e +" "+methodName);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Fetch All Match Urls", notes = "Fetch All Urls")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returns the list of Urls"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/url/getMathces/{inputString}" }, method = { RequestMethod.GET }, produces = { "application/json" })
	public ResponseEntity<Object> getAllMathches(@PathVariable String inputString) throws Exception {
		List<DataURL> matchUrl = null;
		try {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			matchUrl = service.getAllMatches(inputString);
			logger.info(matchUrl);

		} catch (Exception e) {
			logger.error(e +" "+methodName);
		}
		return new ResponseEntity<Object>(matchUrl, HttpStatus.OK);
	}
	

}
