import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;

class Bridge {
    private long BRIDGE_LENGTH = 10000;
    private DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("ss.SSS");
    private Semaphore semaphoreNorthToSouth;
    private Semaphore semaphoreSouthToNorth;
    private int cars;

    public Bridge() {
        this.semaphoreNorthToSouth = new Semaphore(1);
        this.semaphoreSouthToNorth = new Semaphore(1);
        this.cars = 0;
    }

    public void arrive(String carName, String carDirection) throws InterruptedException {
        System.out.println( LocalTime.now().format(FORMATTER) + " " + carName + " arriving towards " + carDirection );
        System.out.println( " Cars " + this.cars + ". Semaphore to south is open: " + this.semaphoreNorthToSouth.availablePermits() + ". Semaphore to north is open: " + this.semaphoreSouthToNorth.availablePermits());
        if (carDirection.equals("north")){ //si va al norte
            semaphoreSouthToNorth.acquire(); //espera al semáforo hacia el norte
            if (semaphoreNorthToSouth.availablePermits() == 1){
                semaphoreNorthToSouth.acquire(); //semáforo hacia el sur se pone rojo si está verde
            }
            Thread.sleep(10);
            semaphoreSouthToNorth.release(); //semáforo hacia el norte se pone verde dejando pasar a los coches de atrás
        }
        else { //si va al sur
            semaphoreNorthToSouth.acquire(); //espera al semáforo hacia el sur
            if (semaphoreSouthToNorth.availablePermits() == 1){
                semaphoreSouthToNorth.acquire(); //semáforo hacia el norte se pone rojo si está verde
            }
            Thread.sleep(10);
            semaphoreNorthToSouth.release(); //semáforo hacia el sur se pone verde dejando pasar a los coches de atrás
        }
        this.crossBridge(carName, carDirection); //cruzar
    }

    private void crossBridge(String carName, String carDirection) throws InterruptedException {
        System.out.println( LocalTime.now().format(FORMATTER) + " " + carName + " entering bridge towards " + carDirection );
        this.cars++;
        Thread.sleep(BRIDGE_LENGTH);
        System.out.println( LocalTime.now().format(FORMATTER) + " " + carName + " leaving bridge towards " + carDirection );
        this.cars--;
        if (this.cars == 0) { //si el puente está vacío
            if (carDirection.equals("south")) {
                    semaphoreSouthToNorth.release(); //semáforo hacia el norte se pone verde
            } else {
                semaphoreNorthToSouth.release(); //semáforo hacia el sur se pone verde
            }
        }
    }
}