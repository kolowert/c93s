package fun.kolowert.c93s.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fun.kolowert.c93s.exception.UnitNotFoundException;
import fun.kolowert.c93s.model.Staff;

@Repository
public class StaffRepoFake implements StaffRepo {

	private static final Map<String, Staff> repo = new HashMap<>();

	static {
		initRepo();
	}

	private static void initRepo() {
		Staff s1 = new Staff("s1", "Arnold", "Schwarzenegger", "arny@hollywood.fun", "cashier", "ar123");
		Staff s2 = new Staff("s2", "Bruce", "Willis", "brus@hollywood.fun", "senior cashier", "br123");
		Staff s3 = new Staff("s3", "Chack", "Noris", "chack@hollywood.fun", "commodity expert", "ch123");
		repo.put(s1.getId(), s1);
		repo.put(s2.getId(), s2);
		repo.put(s3.getId(), s3);
	}

	@Override
	public Staff createUnit(Staff unit) {
		repo.put(unit.getId(), unit);
		return unit;
	}

	@Override
	public Staff getUnit(String unitId) {
		return repo.get(unitId);
	}

	@Override
	public Staff updateUnit(String unitId, Staff unit) {
		boolean isRemoved = true; // repo.remove(unitId, unit);
		if (isRemoved) {
			repo.put(unitId, unit);
		} else {
			throw new UnitNotFoundException();
		}
		return unit;
	}

	@Override
	public String deleteUnit(String unitId) {
		repo.remove(unitId);
		return String.format("Unit with id %s is deleted", unitId);
	}

	@Override
	public List<Staff> reportAllUnits() {
		Collection<Staff> c = repo.values();
        List<Staff> list = new ArrayList<>();
        list.addAll(c);
        return list;
	}

}
