package ru.hwru.softmanage.service;

import org.springframework.stereotype.Service;
import ru.hwru.softmanage.entity.TimeEntry;
import ru.hwru.softmanage.repository.TimeEntryRepository;

import java.math.BigDecimal;
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

    public long count() {
        return timeEntryRepository.count();
    }

    public BigDecimal getTotalHours() {
        return timeEntryRepository.findAll()
                .stream()
                .map(TimeEntry::getHours)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
