package web.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column
   @NotEmpty(message = "Name should not be empty")
   @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
   private String name;

   @Column
   @NotEmpty(message = "Name should not be empty")
   @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
   private String surname;

   @Column
   @Min(value = 0, message = "min age = 0")
   @Max(value = 120, message = "max age = 120")
   private int age;

   public User() {
   }

   public User(String name, String surname, int age) {
      this.name = name;
      this.surname = surname;
      this.age = age;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(surname, user.surname);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name, surname, age);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", surname='" + surname + '\'' +
              ", age=" + age +
              '}';
   }
}