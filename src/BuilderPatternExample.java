// Product class
class Computer {
    private String processor;
    private int ramGB;
    private int storageGB;
    private String operatingSystem;

    // Getters and setters...

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ramGB=" + ramGB +
                ", storageGB=" + storageGB +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}

// Builder interface
interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildStorage();
    void buildOperatingSystem();
    Computer getComputer();
}

// Concrete Builder
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel i9");
    }

    @Override
    public void buildRAM() {
        computer.setRamGB(32);
    }

    @Override
    public void buildStorage() {
        computer.setStorageGB(2000);
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 10");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

// Director class
class ComputerAssembler {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer assembleComputer() {
        computerBuilder.buildProcessor();
        computerBuilder.buildRAM();
        computerBuilder.buildStorage();
        computerBuilder.buildOperatingSystem();
        return computerBuilder.getComputer();
    }
}

class LaptopBuilder implements ComputerBuilder {
    private Computer computer;

    public LaptopBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel i5");
    }

    @Override
    public void buildRAM() {
        computer.setRamGB(16);
    }

    @Override
    public void buildStorage() {
        computer.setStorageGB(512);
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}


// Client
class BuilderClient {
    public static void main(String[] args) {
        ComputerAssembler computerAssembler = new ComputerAssembler();

        // Gaming Computer
        ComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        computerAssembler.setComputerBuilder(gamingComputerBuilder);
        Computer gamingComputer = computerAssembler.assembleComputer();
        System.out.println("Gaming Computer: " + gamingComputer);
		
		System.out.println();

        // Laptop
        ComputerBuilder laptopBuilder = new LaptopBuilder();
        computerAssembler.setComputerBuilder(laptopBuilder);
        Computer laptop = computerAssembler.assembleComputer();
        System.out.println("Laptop: " + laptop);
    }
}
