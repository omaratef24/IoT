package com.vodafone.iot.WebServices;

import com.vodafone.iot.business.DevicesServices;
import com.vodafone.iot.data.Devices;
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
    public boolean DeleteDevices(@RequestParam(value="ID", required = true)Long ID){
       return this.devicesServices.removeDevice(ID);
    }

    @RequestMapping(path="/devices/update", method = RequestMethod.PUT)
    public boolean UpdateStatusDevices(@RequestParam(value="ID", required = true)Long ID,@RequestParam(value="status", required = true)String Status){
        return this.devicesServices.UpdateStatus(Status,ID);
    }
}
