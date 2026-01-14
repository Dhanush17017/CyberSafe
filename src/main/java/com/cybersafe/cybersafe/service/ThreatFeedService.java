package com.cybersafe.cybersafe.service;



import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ThreatFeedService {


    private final List<Map<String, String>> incidents = new ArrayList<>();

    public ThreatFeedService() {

        incidents.add(createIncident("Phishing scam targets bank users", "2025-08-23", "Use 2FA on bank accounts"));
        incidents.add(createIncident("Ransomware hits small businesses", "2025-08-22", "Backup your data regularly"));
    }

    private Map<String, String> createIncident(String title, String date, String tip) {
        Map<String, String> incident = new HashMap<>();
        incident.put("title", title);
        incident.put("date", date);
        incident.put("tip", tip);
        return incident;
    }

    public List<Map<String, String>> getLatestIncidents() {
        return incidents;
    }


    public void addIncident(String title, String tip) {
        incidents.add(0, createIncident(title, java.time.LocalDate.now().toString(), tip));
    }
}

