import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;

class Bridge {
    private Semaphore semaphoreNorthToSouth;
    private Semaphore semaphoreSouthToNorth;
    private int cars;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss.SSS");

    public Bridge() {
        this.semaphoreNorthToSouth = new Semaphore(1);
        this.semaphoreSouthToNorth = new Semaphore(1);
        this.cars = 0;
    }

    public void arrive(String carName, String carDirection) throws InterruptedException {
        System.out.println( LocalTime.now().format(formatter) + " " + carName + " arriving towards " + carDirection );
        System.out.println( " Cars " + this.cars + " Semaphore to south is open: " + this.semaphoreNorthToSouth.availablePermits() + " Semaphore to north is open: " + this.semaphoreSouthToNorth.availablePermits());
        if (carDirection.equals("north")){ //si va al norte
            semaphoreSouthToNorth.acquire(); //espera al semáforo hacia el norte
            if (semaphoreNorthToSouth.availablePermits() == 1){
                semaphoreNorthToSouth.acquire(); //semáforo hacia el sur se pone rojo si está verde
            }
            semaphoreSouthToNorth.release(); //semáforo hacia el norte se pone verde;
        }
        else { //si va al sur
            semaphoreNorthToSouth.acquire(); //espera al semáforo hacia el sur
            if (semaphoreSouthToNorth.availablePermits() == 1){
                semaphoreSouthToNorth.acquire(); //semáforo hacia el sur se pone rojo si está verde
            }
            semaphoreNorthToSouth.release(); //semáforo hacia el sur se pone verde
        }
        this.crossBridge(carName, carDirection); //cruzar
    }

    private void crossBridge(String carName, String carDirection) throws InterruptedException {
        System.out.println( LocalTime.now().format(formatter) + " " + carName + " entering bridge towards " + carDirection );
        this.cars++;
        Thread.sleep(1000);
        System.out.println( LocalTime.now().format(formatter) + " " + carName + " leaving bridge towards " + carDirection );
        this.cars--;
        if (this.cars == 0) {
            if (carDirection.equals("north")) {
                semaphoreNorthToSouth.release();
            } else {
                semaphoreSouthToNorth.release();
            }
        }
    }
}