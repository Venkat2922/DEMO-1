package GenericUtility;

import com.github.javafaker.Faker;

public class FakerUtility {
	
	Faker faker=new Faker();
	
	public  String foreignName() {
		return faker.name().fullName();
		
		
	}
	public  String adults() {
		return faker.number().digits(1);
	
}
	
	public  String childrens() {
		return faker.number().digits(1);
		
	}
}
