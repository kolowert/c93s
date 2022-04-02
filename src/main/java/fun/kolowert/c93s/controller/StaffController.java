package fun.kolowert.c93s.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fun.kolowert.c93s.model.Staff;
import fun.kolowert.c93s.repository.StaffRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StaffController {

	@Autowired
	private StaffRepo staffRepo;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to c93s Example.";
	}

	@PostMapping("/staff")
	@ResponseBody
	public Staff addUnit(@RequestBody Staff unit) {
		log.info("(Service Side) Creating Unit with id: {}", unit.getId());
		return staffRepo.createUnit(unit);
	}

	@RequestMapping(value = "/staff/{unitId}", method = RequestMethod.GET)
	@ResponseBody
	public Staff getUnit(@PathVariable("unitId") String unitId) {
		log.info("(Service Side) reading Unit with id: {}", unitId);
		return staffRepo.getUnit(unitId);
	}

	@RequestMapping(value = "/staff", method = RequestMethod.PUT)
	@ResponseBody
	public Staff updateUnit(@RequestBody Staff unit) {
		log.info("(Service Side) Editing Unit: {}", unit.getId());
		return staffRepo.updateUnit(unit.getId(), unit);
	}

	@RequestMapping(value = "/staff/{unitId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUnit(@PathVariable("unitId") String unitId) {
		log.info("(Service Side) Deleting unit: " + unitId);
		return staffRepo.deleteUnit(unitId);
	}

	@RequestMapping(value = "/staff", method = RequestMethod.GET)
	@ResponseBody
	public List<Staff> reportAllUnits() {
		log.info("All units are reported as List<unit>");
		return staffRepo.reportAllUnits();
	}

}
