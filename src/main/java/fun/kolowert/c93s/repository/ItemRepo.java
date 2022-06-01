package fun.kolowert.c93s.repository;

import java.util.List;

import fun.kolowert.c93s.model.Item;

public interface ItemRepo {
	Item createUnit(Item unit);
	Item getUnit(String id);
	Item updateUnit(String id, Item unit);
	String deleteUnit(String id);
	List<Item> reportAllUnits();
}
