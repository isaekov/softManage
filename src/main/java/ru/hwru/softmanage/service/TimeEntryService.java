package ru.hwru.softmanage.service;

import org.springframework.stereotype.Service;
import ru.hwru.softmanage.entity.TimeEntry;
import ru.hwru.softmanage.repository.TimeEntryRepository;

import java.util.List;

@Service
public class TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryService(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public List<TimeEntry> findAll() {
        return timeEntryRepository.findAll();
    }

    public void save(TimeEntry timeEntry) {
        timeEntryRepository.save(timeEntry);
    }
}
