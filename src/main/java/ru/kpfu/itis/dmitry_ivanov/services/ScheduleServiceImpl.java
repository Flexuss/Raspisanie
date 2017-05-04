package ru.kpfu.itis.dmitry_ivanov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dmitry_ivanov.dao.ScheduleDao;
import ru.kpfu.itis.dmitry_ivanov.model.Schedule;

/**
 * Created by Dmitry on 04.05.2017.
 */

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;


    @Override
    public void addSchedule(Schedule schedule) {
        Schedule schedule1 = scheduleDao.findByDayAndTime(schedule.getDay(), schedule.getTime());
        if(schedule1!=null) {
           scheduleDao.delete(schedule1);
        }
        scheduleDao.save(schedule);
    }
}
