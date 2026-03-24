package ru.hwru.softmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.entity.TimeEntry;

import java.util.List;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    List<TimeEntry> findByTask(Task task);

}
