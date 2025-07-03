package com.rw.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Column(nullable = false)
    private boolean isEstonianResident;

    @Column(unique = true)
    @Min(value = 10000000000L, message = "Personal ID must be 11 digits")
    @Max(value = 99999999999L, message = "Personal ID must be 11 digits")
    private Long personalID;

    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @Column(nullable = false, length = 20, name = "phone_number")
    @NotBlank(message = "Phone number is required")
//    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phoneNumber;

    @Column(unique = true, nullable = false, length = 100)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = false, length = 200, name = "living_address")
    @NotBlank(message = "Living address is required")
    @Size(min = 10, max = 200, message = "Living address must be between 10 and 200 characters")
    private String livingAddress;

    @Column(unique = true, nullable = false, length = 50, name = "drivers_license_number")
    @NotBlank(message = "Driver's license number is required")
    @Pattern(regexp = "^[A-Z]{2}\\d{6}$", message = "Driver's license must follow Estonian format (e.g., E<E/V/T>123456)")
    private String driversLicenseNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_vehicle_id")
    private Vehicle currentVehicle;

    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "last_edited_at")
    private LocalDateTime lastEditedAt;

    public Driver() {

    }

    public Driver(String firstName, String lastName, boolean isEstonianResident, Long personalID, LocalDate dateOfBirth, String phoneNumber, String email, String livingAddress, String driversLicenseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isEstonianResident = isEstonianResident;
        this.personalID = personalID;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.livingAddress = livingAddress;
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEstonianResident() {
        return isEstonianResident;
    }

    public void setEstonianResident(boolean estonianResident) {
        isEstonianResident = estonianResident;
    }

    public Long getPersonalID() {
        return personalID;
    }

    public void setPersonalID(Long personalID) {
        this.personalID = personalID;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(String livingAddress) {
        this.livingAddress = livingAddress;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }

    public void setLastEditedAt(LocalDateTime lastEditedAt) {
        this.lastEditedAt = lastEditedAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        lastEditedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastEditedAt = LocalDateTime.now();
    }

    // Add utility method for full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Add age calculation method
    public Integer getAge() {
        if (dateOfBirth == null) {
            return null;
        }
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) &&
               Objects.equals(personalID, driver.personalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personalID);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isEstonianResident=" + isEstonianResident +
                ", personalID=" + personalID +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", livingAddress='" + livingAddress + '\'' +
                ", driversLicenseNumber='" + driversLicenseNumber + '\'' +
                '}';
    }
}
