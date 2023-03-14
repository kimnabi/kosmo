package a.b.c.ch4;

public class AdapterTest {
	
	public static void main(String[] args) {
		Electronic110v hairDryer = new HairDryer();
		hairDryer.powerOn();
		Electronic110v cleaner = new ElectronicAdapter(new Cleaner());
		cleaner.powerOn(); // Ã»¼Ò±â 220v on
		Electronic110v airConditioner = new ElectronicAdapter(new AirConditioner());
        airConditioner.powerOn();
	}
}
