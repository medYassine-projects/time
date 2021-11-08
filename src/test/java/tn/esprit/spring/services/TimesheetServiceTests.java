package tn.esprit.spring.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;


import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceTests {

    @Autowired
    TimesheetServiceImpl timesheetService;

    @Autowired
    MissionRepository missionRepository;

    @Autowired
    TimesheetRepository timesheetRepository;

    @Autowired
    DepartementRepository deptRepository;

    @Autowired
    EmployeRepository employeRepository;

    @Test
    public void ajouterMission() {
        Mission mission = new Mission("test mission", "test description");
        int id = timesheetService.ajouterMission(mission);
        assertTrue(missionRepository.findById(id).isPresent());
    }

    @Test
    public void affecterMissionADepartement() {
        int missionId = 7;
        int depId = 24;
        timesheetService.affecterMissionADepartement(missionId, depId);
        List<Integer> missionList = deptRepository.findById(depId).get().getMissions().stream().map(Mission::getId).collect(Collectors.toList());
        assertTrue(missionList.contains(missionId));

    }



    @Test
    public void findAllMissionByEmployeJPQL() {
        int employeId = 8;
        List<Integer> missionList = timesheetService.findAllMissionByEmployeJPQL(employeId).stream().map(Mission::getId).collect(Collectors.toList());
        assertEquals(missionList, timesheetService.findAllMissionByEmployeJPQL(employeId).stream().map(Mission::getId).collect(Collectors.toList()));
    }

    @Test
    public void getAllEmployeByMission() {
        int missionId = 7;
        List<Integer> employeList = timesheetService.getAllEmployeByMission(missionId).stream().map(Employe::getId).collect(Collectors.toList());
        assertEquals(employeList, timesheetRepository.getAllEmployeByMission(missionId).stream().map(Employe::getId).collect(Collectors.toList()));
    }
}