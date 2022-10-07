package com.vodafone.iot.utils;

import com.vodafone.iot.data.Devices;
import com.vodafone.iot.data.DevicesRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final DevicesRepository devicesRepository;

    public AppStartupEvent(DevicesRepository devicesRepository) {
        this.devicesRepository = devicesRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Devices> devices = devicesRepository.findAll();
        devices.forEach(System.out::println);
    }
}
