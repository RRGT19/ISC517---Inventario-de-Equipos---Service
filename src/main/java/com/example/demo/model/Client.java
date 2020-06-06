package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "client_id"))
})
public class Client extends BaseEntity {

  @Size(min = 11, max = 11, message = "La identificación debe tener 11 dígitos")
  @Column(unique = true, nullable = false, length = 11)
  private String identification;

  @NotBlank(message = "El nombre no puede estar en blanco")
  @Column(nullable = false)
  private String name;

  @Size(min = 10, max = 10, message = "El teléfono debe tener 10 dígitos")
  @Column(unique = true, nullable = false, length = 10)
  private String phone;

  @Lob // Specifies that the database should store the property as Large Object.
  @Column(columnDefinition = "BLOB") // Defines the column type for the property.
  private byte[] photo;

  public Client() {
  }

  public Client(String identification, String name, String phone, byte[] photo) {
    this.identification = identification;
    this.name = name;
    this.phone = phone;
    this.photo = photo;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }

}
