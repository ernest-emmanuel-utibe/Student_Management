package com.real.student.data.repository;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

import com.real.student.data.model.NewLocationToken;
import com.real.student.data.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {
    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(UserLocation userLocation);
}
