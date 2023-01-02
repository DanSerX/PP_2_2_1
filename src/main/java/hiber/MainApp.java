package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Ann", "Angel", "anangel@gmail.com");
      user1.setCar(new Car("BMW", 630)).setUser(user1);
      userService.add(user1);

      User user2 = new User("Ben", "Bender", "kissmyshining@gmail.com");
      user2.setCar(new Car("TAZ", 2101)).setUser(user2);
      userService.add(user2);

      User user3 = new User("Clare", "Clarison", "cleverity@gmail.com");
      user3.setCar(new Car("Tesla", 3)).setUser(user3);
      userService.add(user3);

      User user4 = new User("Donny", "Donniger", "dodolife@gmail.com");
      user4.setCar(new Car("GAZ", 66)).setUser(user4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println("Владелец BMW 630 - " + userService.getUserByCar("BMW", 630));

      context.close();
   }
}