package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }

    public void speedUp(int seconds)
        {
        if ( model.getSpeed() < model.getMaxSpeed())
            {
             //   speed += (3.5 * seconds);
                model.setSpeed( (int) (model.getSpeed()+  (3.5 * seconds)) );
            }
        if ( model.getSpeed() > model.getMaxSpeed())
            {
               // speed = maxSpeed;
                model.setSpeed(model.getMaxSpeed());
            }
        }

    public void speedDown(int seconds)
        {
        if ( model.getSpeed() > 0)
            {
              //  speed -= (12 * seconds);
                model.setSpeed(model.getSpeed()-  (12 * seconds)  );
            }
        if ( model.getSpeed() < 0)
            {
             //   speed = 0;
                model.setSpeed(0);
            }
        }
}