package ru.kpfu.itis.dmitry_ivanov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.dmitry_ivanov.model.Schedule;

/**
 * Created by Dmitry on 04.05.2017.
 */
public interface ScheduleDao extends JpaRepository<Schedule, Long> {

    Schedule findByDayAndTime(int day, int time);
}
