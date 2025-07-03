package com.rw.repository;

import com.rw.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByPersonalID(Long personalID);

    Optional<Driver> findByEmail(String email);
    Optional<Driver> findByPhoneNumber(String phoneNumber);

    List<Driver> findByFirstNameContainingIgnoreCase(String firstName);
    List<Driver> findByLastNameContainingIgnoreCase(String lastName);

    Optional<Driver> findByDriversLicenseNumber(String driversLicenseNumber);
    List<Driver> findByLivingAddressContainingIgnoreCase(String address);

    List<Driver> findByCurrentVehicleIsNotNull();
    List<Driver> findByCurrentVehicleIsNull();

    boolean existsByPersonalID(Long personalID);
    boolean existsByEmail(String email);
    boolean existsByDriversLicenseNumber(String driversLicenseNumber);

    @Query("SELECT d FROM Driver d WHERE LOWER(CONCAT(d.firstName, ' ', d.lastName)) LIKE LOWER(CONCAT('%', :fullName, '%'))")
    List<Driver> findByFullNameContaining(@Param("fullName") String fullName);

    @Query("SELECT d FROM Driver d WHERE LOWER(d.livingAddress) LIKE LOWER(CONCAT('%', :location, '%'))")
    List<Driver> findByLocation(@Param("location") String location);
}


