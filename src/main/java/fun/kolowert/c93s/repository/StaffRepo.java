package fun.kolowert.c93s.repository;

import java.util.List;

import fun.kolowert.c93s.model.Staff;

public interface StaffRepo {

	Staff createUnit(Staff user);
	Staff getUnit(String email);
	Staff updateUnit(String email, Staff user);
	void deleteUnit(String email);
	List<Staff> reportAllUnits();
}
