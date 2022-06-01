package fun.kolowert.c93s.repository;

import java.util.List;

import fun.kolowert.c93s.model.Staff;

public interface StaffRepo {

	Staff createUnit(Staff unit);
	Staff getUnit(String email);
	Staff updateUnit(String email, Staff unit);
	String deleteUnit(String email);
	List<Staff> reportAllUnits();
}
