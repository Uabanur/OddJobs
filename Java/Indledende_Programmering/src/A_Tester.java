
public class A_Tester {
	
	public static void main(String[] args) {
		
		Road[] roads = new Road[9];
        roads[0] = new Road(1203, 8.3, "Ravehøjvej", "concrete");
        roads[1] = new Road(785, 12.5, "Anker Engelunds Vey", "asphalt");
        roads[2] = new Road(2307, 15.3, "Lundtoftegårdsvej", "asphalt");
        roads[3] = new Road(831, 2.65, "Vesthussti", "dirt");
        roads[4] = new Road(2731, 4.0512, "Ulvedalsvej", "gravel");
        roads[5] = new Road(3400, 21.30, "Lyngby omfartsvej", "concrete");
        roads[6] = new Road(31, 0.50, "Småsti", "dirt");
        roads[7] = new Road(102.5, 3.0, "Storsti", "mud");
        roads[8] = new Road(102.5, 3.0, "ILLEGAL", "dirt");
         
        for (int i = 0; i < roads.length; i++) {
            System.out.println(roads[i]);
        }
         
        roads[2].setName("Ny Lundtoftegårdsvej");
        System.out.println(roads[2]);
        roads[0].setSurface("asphalt");
        System.out.println(roads[0]);
        roads[1].setWidth(13.2);
        System.out.println(roads[1]);
        roads[1].setWidth(0.2);
        System.out.println(roads[1]);
        roads[1].setSurface("something");
        System.out.println(roads[1]);
        roads[1].setLength(12345);
        System.out.println(roads[1]);
        System.out.println(roads[3].getName());
        System.out.println(roads[4].getLength());
        System.out.println(roads[5].getWidth());
        System.out.println(roads[1].getSurface());
	}
	
}
