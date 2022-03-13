package com.bhnaamm.examples.domain;

public class CarFactory {

    public Car createCar(Car car){
        if(car instanceof Sport){
            return  (Sport) new Sport.SportBuilder()
                    .setHorsePower(((Sport)car).getHorsePower())
                    .carBuilder(car.getName(),car.getManufacturer(),car.getColor(),car.getRegistrationNumber(),car.getManufacturingDate())
                    .build();
        }else if(car instanceof Electrical){
            return (Electrical) new Electrical.ElectricalBuilder()
                    .setBatteryDuration(((Electrical)car).getBatteryDuration())
                    .carBuilder(car.getName(),car.getManufacturer(),car.getColor(),car.getRegistrationNumber(),car.getManufacturingDate())
                    .build();
        }else if(car instanceof TwoWheels){
            return (TwoWheels) new TwoWheels.TwoWheelBuilder()
                    .carBuilder(car.getName(),car.getManufacturer(),car.getColor(),car.getRegistrationNumber(),car.getManufacturingDate())
                    .build();
        }
        return null;
    }
}
