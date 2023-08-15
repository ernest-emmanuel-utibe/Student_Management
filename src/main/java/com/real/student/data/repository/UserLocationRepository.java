package com.real.student.data.repository;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

import com.real.student.data.model.User;
import com.real.student.data.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);
}
