package com.hirewheelsproject.services.serviceImpl;

import com.hirewheelsproject.daos.*;
import com.hirewheelsproject.entities.*;
import com.hirewheelsproject.exceptions.*;
import com.hirewheelsproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service("initServiceImpl")
public class InitServiceImpl implements InitService {

    @Autowired @Qualifier("roleDAO")
    private RoleDAO roleDAO;
    @Autowired @Qualifier("usersDAO")
    private UsersDAO usersDAO;
    @Autowired @Qualifier("vehicleCategoryDAO")
    private VehicleCategoryDAO vehicleCategoryDAO;
    @Autowired @Qualifier("vehicleSubCategoryDAO")
    private VehicleSubCategoryDAO vehicleSubCategoryDAO;
    @Autowired @Qualifier("fuelTypeDAO")
    private FuelTypeDAO fuelTypeDAO;
    @Autowired @Qualifier("cityDAO")
    private CityDAO cityDAO;
    @Autowired @Qualifier("locationDAO")
    private LocationDAO locationDAO;
    @Autowired @Qualifier("userServiceImpl")
    private UserService userService;
    @Autowired @Qualifier("adminServiceImpl")
    private AdminService adminService;
    @Autowired @Qualifier("vehicleDAO")
    private VehicleDAO vehicleDAO;
    @Autowired @Qualifier("bookingServiceImpl")
    private BookingService bookingService;
    @Autowired @Qualifier("vehicleServiceImpl")
    private VehicleService vehicleService;
    @Autowired @Qualifier("bookingDAO")
    private BookingDAO bookingDAO;

    @Override
    public void init() {
        insertIntoRole();
        createAdmin();
        insertVehicleCategory();
        insertVehicleSubCategory();
        insertFuelType();
        insertCity();
        insertLocation();
        /*testUserService();
        testCreateUsers();
        testAdminServiceRegisterVehicle();
        testBookingServiceAddBooking();
        testVehicleService();*/
        System.out.println("executed init");
    }

    public void insertIntoRole() {
        Role userRole = new Role("User");
        Role adminRole = new Role("Admin");
        roleDAO.save(userRole);
        roleDAO.save(adminRole);
        System.out.println("hello");
    }

   public void createAdmin() {
        Users admin = new Users("Admin","Admin","admin@123","upgrad@gmail.com",
                "9999999999", roleDAO.findByName("Admin"),10000.00);
        usersDAO.save(admin);
    }

    public void insertVehicleCategory() {
        VehicleCategory car = new VehicleCategory("Car");
        VehicleCategory bike = new VehicleCategory("Bike");
        vehicleCategoryDAO.save(car);
        vehicleCategoryDAO.save(bike);
    }

    public void insertVehicleSubCategory() {
        VehicleSubCategory suv = new VehicleSubCategory("Suv",300.00,
                vehicleCategoryDAO.findByName("Car"));
        vehicleSubCategoryDAO.save(suv);
        VehicleSubCategory sedan = new VehicleSubCategory("Sedan",350.00,
                vehicleCategoryDAO.findByName("Car"));
        vehicleSubCategoryDAO.save(sedan);
        VehicleSubCategory hatchBack = new VehicleSubCategory("HatchBack",250.00,
                vehicleCategoryDAO.findByName("Car"));
        vehicleSubCategoryDAO.save(hatchBack);
        VehicleSubCategory cruiser = new VehicleSubCategory("Cruiser",200.00,
                vehicleCategoryDAO.findByName("Bike"));
        vehicleSubCategoryDAO.save(cruiser);
        VehicleSubCategory dirtBike = new VehicleSubCategory("DirtBike",200.00,
                vehicleCategoryDAO.findByName("Bike"));
        vehicleSubCategoryDAO.save(dirtBike);
        VehicleSubCategory sportsBike = new VehicleSubCategory("SportsBike",150.00,
                vehicleCategoryDAO.findByName("Bike"));
        vehicleSubCategoryDAO.save(sportsBike);
    }

    public void insertFuelType() {
        FuelType petrol = new FuelType("Petrol");
        fuelTypeDAO.save(petrol);
        FuelType diesel = new FuelType("Diesel");
        fuelTypeDAO.save(diesel);
    }

    public void insertCity() {
        City city = new City("Mumbai");
        cityDAO.save(city);
    }

    public void insertLocation() {
        Location location1 = new Location("Worli", "Dr E Moses Rd, Worli Naka, Upper Worli",
                "400018",cityDAO.findByName("Mumbai"));
        locationDAO.save(location1);
        Location location2 = new Location("Chembur", "Optic Complex",
                "400019",cityDAO.findByName("Mumbai"));
        locationDAO.save(location2);
        Location location3 = new Location("Powai", "Hiranandani Towers",
                "400020",cityDAO.findByName("Mumbai"));
        locationDAO.save(location3);
    }

    public void testUserService() {
        try {
            Users users = userService.getUser("upgrad@gmail.com", "adm@123");
            System.out.println(users.getFirstName());
        }
        catch(UserIsNotRegisteredException ex) {
            System.out.println(ex.getMessage());
        } catch (UnauthorizedUserException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testCreateUsers() {
        Users users = new Users("User","User","user@123","user@gmail.com",
                "9999999998", roleDAO.findByName("User"),10000.00);
        try {
            System.out.println(userService.createUsers(users).getFirstName());
            System.out.println(userService.createUsers(users).getFirstName());
        }
        catch (UserAlreadyExistsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testAdminServiceRegisterVehicle() {
        Vehicle vehicle = new Vehicle("honda","AB1234",vehicleSubCategoryDAO.findById(7)
                ,"Blue",locationDAO.findById(15),fuelTypeDAO.findById(13),0,"www.imageAB1234.com");
        try {
            Vehicle vehicle1 = adminService.registerVehicle(vehicle);
            vehicle1 = adminService.changeAvailability(vehicle1);
            adminService.changeAvailability(vehicle1);
            System.out.println(vehicle1.getAvailabilityStatus());
            adminService.registerVehicle(vehicle);
        }
        catch (VehicleAlreadyRegisteredException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testBookingServiceAddBooking() {
        Booking booking = new Booking(new Date(2020,9,11),new Date(2020,9,22),
                new Date(2020,9,23),locationDAO.findById(15),vehicleDAO.findById(19),
                usersDAO.findById(18),300.00);
        try {
            Booking booking1 = bookingService.addBooking(booking);
            System.out.println(booking1.getId());
        }
        catch (InsufficientBalanceException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testVehicleService() {
        try {
            System.out.println(vehicleService.getAllVehicles().size());
        }
        catch (NoVehicleRegisteredException a) {
            System.out.println(a.getMessage());
        }
        try {
            System.out.println(vehicleService.getVehicleByUserId(18));
        }
        catch (NoVehicleRegisteredByUser b) {
            System.out.println(b.getMessage());
        }
        Booking booking = bookingDAO.findById(20);
    }

}