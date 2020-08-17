/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Symb0L
 */
@ManagedBean(name="user")
@SessionScoped
public class UserBean {
    
    public String username;
    public String password;
    public String confirmPassword;
    public String email;
    public int age;
    public String gender;
    
    public UserBean() {
    
    }
    
    private static final ArrayList<Car> carList = 
        new ArrayList<Car>(Arrays.asList(
        new Car("1", "car1", "resources/images/car01.jpg"),
        new Car("2", "car2", "resources/images/car02.jpg"),
        new Car("3", "car3", "resources/images/car03.jpg"),
        new Car("4", "car4", "resources/images/car04.jpg"),
        new Car("5", "car5", "resources/images/car05.jpg")
    ));
    
    public ArrayList<Car> getCarList() {
        return carList;
    }
    public String deleteAction(Car car) {
        carList.remove(car);
        return null;
    }
    
    public static class Car {
        String carId;
        String carName;
        String carImg;
        
        public Car(String carId, String carName, String carImg) {
            this.carId = carId;
            this.carName = carName;
            this.carImg = carImg;
        }

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getCarName() {
            return carName;
        }

        public void setCarName(String carName) {
            this.carName = carName;
        }

        public String getCarImg() {
            return carImg;
        }

        public void setCarImg(String carImg) {
            this.carImg = carImg;
        }
        
        
    }

    public UserBean(String username, String password, String confirmPassword, String email, int age, String gender) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String Login() {
        if(username.equals("admin") && password.equals("admin")) {
            return "success";
        }else {
            return "failure";
        }
    }
}
