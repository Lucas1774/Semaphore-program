public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bridge bridge = new Bridge();

        Thread car1 = new Thread(new Car("Car 1", "north", bridge));
        Thread car2 = new Thread(new Car("Car 2", "south", bridge));
        Thread car3 = new Thread(new Car("Car 3", "south", bridge));
        Thread car4 = new Thread(new Car("Car 4", "north", bridge));
        Thread car5 = new Thread(new Car("Car 5", "north", bridge));
        Thread car6 = new Thread(new Car("Car 6", "south", bridge));
        Thread car7 = new Thread(new Car("Car 7", "south", bridge));
        Thread car8 = new Thread(new Car("Car 8", "north", bridge));
        Thread car9 = new Thread(new Car("Car 9", "south", bridge));
        Thread car10 = new Thread(new Car("Car 10", "south", bridge));

        car1.start();
        Thread.sleep(400);
        car2.start();
        Thread.sleep(200);
        car3.start();
        Thread.sleep(60);
        car4.start();
        Thread.sleep(100);
        car5.start();
        Thread.sleep(80);
        car6.start();
        Thread.sleep(1200);
        car7.start();
        Thread.sleep(50);
        car8.start();
        Thread.sleep(700);
        car9.start();
        Thread.sleep(90);
        car10.start();
        Thread.sleep(150);
    }
}