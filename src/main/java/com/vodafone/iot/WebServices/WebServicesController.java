package com.vodafone.iot.WebServices;

import com.vodafone.iot.business.DevicesServices;
import com.vodafone.iot.data.Devices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class WebServicesController {
    private final DevicesServices devicesServices;

    public WebServicesController(DevicesServices devicesServices) {
        this.devicesServices = devicesServices;
    }

    @RequestMapping(path="/devices", method = RequestMethod.GET)
    public Iterable<Devices> getDevices(@RequestParam(value="status", required = false)String STATUS){
        if (STATUS != null && !STATUS.isEmpty()){
            return this.devicesServices.getDevicesbyStatus(STATUS);
        }else {
            return this.devicesServices.getAllDevices();
        }
    }

    @RequestMapping(path="/devices/delete", method = RequestMethod.DELETE)
    public ResponseEntity
            <HttpStatus> DeleteDevices(@RequestBody Devices  device){
       return this.devicesServices.removeDevice(device.getID());
    }

    @RequestMapping(path="/devices/update", method = RequestMethod.PUT)
    public
    ResponseEntity
            <org.springframework.http.HttpStatus> UpdateStatusDevices(@RequestBody Devices  device){
        return this.devicesServices.UpdateStatus(device.getSTATUS(),device.getID());
    }
}
