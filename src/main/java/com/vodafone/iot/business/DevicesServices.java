package com.vodafone.iot.business;

import com.vodafone.iot.data.Devices;
import com.vodafone.iot.data.DevicesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DevicesServices {
    private final DevicesRepository devicesRepository;

    public DevicesServices(DevicesRepository devicesRepository) {
        this.devicesRepository = devicesRepository;
    }


    public  Iterable<Devices> getDevicesbyStatus(String Status){
        Iterable<Devices> devices = this.devicesRepository.findDevicesBySTATUS(Status);
        List<Devices> list = new ArrayList<>();
        devices.forEach(list::add);
        list.sort(Comparator.comparing(o -> o.getID().longValue()));
        devices = list;
        return devices;
    }

    public  Iterable<Devices> getAllDevices(){
        Iterable<Devices> devices = this.devicesRepository.findAll();
        return devices;
    }

    public
    ResponseEntity
            <org.springframework.http.HttpStatus> UpdateStatus(String Status,Long Id){
        Optional<Devices> devices = this.devicesRepository.findById(Id);
        devices.get().setSTATUS(Status);
        this.devicesRepository.save(devices.get());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public
    ResponseEntity
            <org.springframework.http.HttpStatus> removeDevice(Long ID){
        System.out.println(ID);
        this.devicesRepository.deleteById(ID);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
