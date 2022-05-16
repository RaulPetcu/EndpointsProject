package com.example.demo.controller;

import com.example.demo.Complaint;
import com.example.demo.DatasetService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class DatasetController {

    private DatasetService datasetService = new DatasetService("C:\\Users\\Raul\\Documents\\Facultate\\JavaRaul\\RetinaProject\\src" +
            "\\main\\NYPD_Complaint_Data_Historic.csv");

    @GetMapping(path = "/dataset/stats/total")
    private Map<String, Integer> getTotalStats() {
        return datasetService.getComplaintsNumberJson();
    }

    @GetMapping(path = "/dataset/stats/offenses")
    private Map<String, Long> getKy_CdStats() {
        return datasetService.getStatsGroupByKy_Cd();
    }

    @DeleteMapping(path = "/dataset/{id}")
    private Boolean deleteComplaintWithId(@PathVariable String id) throws IOException {
        return datasetService.deleteById(id);
    }

    @PostMapping(path = "/dataset")
    public String addComplaint(@RequestBody Complaint complaint) {
        return datasetService.addComplaint(complaint);
    }

    @GetMapping(path = "/dataset/map")
    private Map<String, Complaint> showMap() {
        return datasetService.showMap();
    }

}
