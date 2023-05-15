public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bridge bridge = new Bridge();

        Thread car01 = new Thread(new Car("Car 01", "north", bridge));
        Thread car02 = new Thread(new Car("Car 02", "south", bridge));
        Thread car03 = new Thread(new Car("Car 03", "south", bridge));
        Thread car04 = new Thread(new Car("Car 04", "north", bridge));
        Thread car05 = new Thread(new Car("Car 05", "north", bridge));
        Thread car06 = new Thread(new Car("Car 06", "south", bridge));
        Thread car07 = new Thread(new Car("Car 07", "south", bridge));
        Thread car08 = new Thread(new Car("Car 08", "north", bridge));
        Thread car09 = new Thread(new Car("Car 09", "south", bridge));
        Thread car10 = new Thread(new Car("Car 10", "south", bridge));
        Thread car11 = new Thread(new Car("Car 11", "north", bridge));
        Thread car12 = new Thread(new Car("Car 12", "north", bridge));
        Thread car13 = new Thread(new Car("Car 13", "south", bridge));
        Thread car14 = new Thread(new Car("Car 14", "north", bridge));
        Thread car15 = new Thread(new Car("Car 15", "south", bridge));
        
        car01.start();
        Thread.sleep(4000);
        car02.start();
        Thread.sleep(2000);
        car03.start();
        Thread.sleep(600);
        car04.start();
        Thread.sleep(1000);
        car05.start();
        Thread.sleep(800);
        car06.start();
        Thread.sleep(12000);
        car07.start();
        Thread.sleep(500);
        car08.start();
        Thread.sleep(7000);
        car09.start();
        Thread.sleep(900);
        car10.start();
        Thread.sleep(1500);
        car11.start();
        Thread.sleep(3000);
        car12.start();
        Thread.sleep(1000);
        car13.start();
        Thread.sleep(2000);
        car14.start();
        Thread.sleep(500);
        car15.start();
        Thread.sleep(2500);
        
    }
}