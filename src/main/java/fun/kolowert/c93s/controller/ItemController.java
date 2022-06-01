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

import fun.kolowert.c93s.model.Item;
import fun.kolowert.c93s.repository.ItemRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ItemController {
	
	private static final String UNIT_INFO = "Item";
	
	@Autowired
	private ItemRepo itemRepo;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to c93s Example.";
	}

	@PostMapping("/item")
	@ResponseBody
	public Item addUnit(@RequestBody Item unit) {
		log.info("(Service Side) Creating Unit {} with id: {}", UNIT_INFO, unit.getId());
		return itemRepo.createUnit(unit);
	}

	@RequestMapping(value = "/item/{unitId}", method = RequestMethod.GET)
	@ResponseBody
	public Item getUnit(@PathVariable("unitId") String unitId) {
		log.info("(Service Side) reading Unit {} with id: {}", UNIT_INFO, unitId);
		return itemRepo.getUnit(unitId);
	}

	@RequestMapping(value = "/item", method = RequestMethod.PUT)
	@ResponseBody
	public Item updateUnit(@RequestBody Item unit) {
		log.info("(Service Side) Editing Unit {}: {}", UNIT_INFO, unit.getId());
		return itemRepo.updateUnit(unit.getId(), unit);
	}

	@RequestMapping(value = "/item/{unitId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUnit(@PathVariable("unitId") String unitId) {
		log.info("(Service Side) Deleting unit {}: {}", UNIT_INFO, unitId);
		return itemRepo.deleteUnit(unitId);
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> reportAllUnits() {
		log.info("All units {} are reported as List<unit>", UNIT_INFO);
		return itemRepo.reportAllUnits();
	}

}
