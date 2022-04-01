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
		Staff s1 = new Staff("s1", "Arnold", "Schwarz", "arny@hollywood.fun", "cashier", "ar123");
		Staff s2 = new Staff("s2", "Bruce", "Willis", "brus@hollywood.fun", "senior cashier", "br123");
		Staff s3 = new Staff("s3", "Chack", "Noris", "chack@hollywood.fun", "commodity expert", "ch123");
		repo.put(s1.getId(), s1);
		repo.put(s2.getId(), s2);
		repo.put(s3.getId(), s3);
	}

	@Override
	public Staff createUnit(Staff staffUnit) {
		repo.put(staffUnit.getId(), staffUnit);
		return staffUnit;
	}

	@Override
	public Staff getUnit(String staffId) {
		return repo.get(staffId);
	}

	@Override
	public Staff updateUnit(String staffId, Staff staffUnit) {
		boolean isRemoved = repo.remove(staffId, staffUnit);
		if (isRemoved) {
			repo.put(staffId, staffUnit);
		} else {
			throw new UnitNotFoundException();
		}
		return null;
	}

	@Override
	public void deleteUnit(String staffId) {
		repo.remove(staffId);
	}

	@Override
	public List<Staff> reportAllUnits() {
		Collection<Staff> c = repo.values();
        List<Staff> list = new ArrayList<>();
        list.addAll(c);
        return list;
	}

}
