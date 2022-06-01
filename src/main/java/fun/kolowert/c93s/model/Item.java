package fun.kolowert.c93s.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Item {
	private String id;
	private String name;
	private String description;
	private String unitOfMeasurement;
	private String quantity;
	private String price;
}
