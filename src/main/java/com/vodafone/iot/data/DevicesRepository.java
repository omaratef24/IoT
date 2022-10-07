package com.vodafone.iot.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesRepository extends JpaRepository<Devices,Long> {
    Iterable<Devices> findDevicesBySTATUS(String STATUS);
}
