package org.springframework.samples.petclinic;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class HeadersInspectController {

	@GetMapping("/headers")
	@ResponseBody
	public ResponseEntity<String> inspectHeaders(@RequestHeader MultiValueMap<String, String> headers) {
		StringBuilder strBld = new StringBuilder("");
		strBld.append(String.format("<h4>Listing %d headers</h4>", headers.size()));
		headers.forEach((key, value) -> {
			strBld.append(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))))
					.append("<BR>");
		});

		return new ResponseEntity<String>(strBld.toString(), HttpStatus.OK);
	}

}
