
package com.example.tourbackend.repository;

import com.example.tourbackend.entity.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {
    List<TourPackage> findByLocationContainingIgnoreCase(String location);

}
