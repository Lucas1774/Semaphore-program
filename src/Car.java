class Car implements Runnable {
    private String name;
    private String direction;
    private Bridge bridge;

    public Car(String name, String direction, Bridge bridge) {
        this.name = name;
        this.direction = direction;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        try {
            bridge.arrive(name, direction);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}