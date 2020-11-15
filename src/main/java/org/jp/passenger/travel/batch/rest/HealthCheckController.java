
package org.jp.passenger.travel.batch.rest;

import org.jp.passenger.travel.batch.utility.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("psnTrvlBatch")
public class HealthCheckController {

	@GetMapping("healthStatus")
	public String appStatus() {
		return Status.OK.getValue();
	}
}
