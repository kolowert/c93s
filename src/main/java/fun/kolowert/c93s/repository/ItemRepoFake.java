package fun.kolowert.c93s.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fun.kolowert.c93s.exception.UnitNotFoundException;
import fun.kolowert.c93s.model.Item;

public class ItemRepoFake implements ItemRepo {
	
	private static final Map<String, Item> repo = new HashMap<>();

	static {
		initRepo();
	}

	private static void initRepo() {
		Item i1 = new Item("i1", "Eclair", "Eclair description", "piece", "45", "0.35");
		Item i2 = new Item("i2", "Marmalade", "Marmalade description", "kilogram", "30", "1.05");
		Item i3 = new Item("i3", "Strawberry Pie", "Strawberry Pie description", "piece", "20", "0.25");
		repo.put(i1.getId(), i1);
		repo.put(i2.getId(), i2);
		repo.put(i3.getId(), i3);
	}
	
	@Override
	public Item createUnit(Item unit) {
		repo.put(unit.getId(), unit);
		return unit;
	}

	@Override
	public Item getUnit(String id) {
		return repo.get(id);
	}

	@Override
	public Item updateUnit(String id, Item unit) {
		boolean isRemoved = true; // repo.remove(unitId, unit);
		if (isRemoved) {
			repo.put(id, unit);
		} else {
			throw new UnitNotFoundException();
		}
		return unit;
	}

	@Override
	public String deleteUnit(String id) {
		repo.remove(id);
		return String.format("Unit with id %s is deleted", id);
	}

	@Override
	public List<Item> reportAllUnits() {
		Collection<Item> c = repo.values();
        List<Item> list = new ArrayList<>();
        list.addAll(c);
        return list;
	}

}
