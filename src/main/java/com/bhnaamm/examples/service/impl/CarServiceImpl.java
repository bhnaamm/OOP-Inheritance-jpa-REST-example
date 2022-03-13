package com.bhnaamm.examples.service.impl;

import com.bhnaamm.examples.domain.Car;
import com.bhnaamm.examples.domain.CarFactory;
import com.bhnaamm.examples.domain.enumeration.CarType;
import com.bhnaamm.examples.repository.CarRepository;
import com.bhnaamm.examples.repository.ElectricalRepository;
import com.bhnaamm.examples.repository.SportRepository;
import com.bhnaamm.examples.service.CarService;
import com.bhnaamm.examples.repository.TwoWheelsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Car}.
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    private ElectricalRepository electricalRepository;
    private SportRepository sportRepository;
    private TwoWheelsRepository twoWheelsRepository;

    public CarServiceImpl(CarRepository carRepository, ElectricalRepository electricalRepository, SportRepository sportRepository, TwoWheelsRepository twoWheelsRepository) {
        this.carRepository = carRepository;
        this.electricalRepository = electricalRepository;
        this.sportRepository = sportRepository;
        this.twoWheelsRepository = twoWheelsRepository;
    }

    @Override
    public Car save(Car car) {
        CarFactory factory = new CarFactory();
        Car createdCar =  factory.createCar(car);
        return carRepository.save(createdCar);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Car> findAll(Pageable pageable, CarType carType) {
        Page<Car> cars = null;
        switch (carType){
            case ELECTRICAL:
                cars = electricalRepository.findAll(pageable);
                break;
            case SPORT:
                cars = sportRepository.findAll(pageable);
                break;
            case TWO_WHEELS:
                cars = twoWheelsRepository.findAll(pageable);
                break;
            default:
        }
        return cars;
    }

    @Override
    public Optional<Car> findOne(Long id) {
        return Optional.empty();
    }

}
