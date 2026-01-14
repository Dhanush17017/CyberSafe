package com.cybersafe.cybersafe.controller;

import com.cybersafe.cybersafe.service.ThreatFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Map;

@Controller
public class ThreatFeedController {

    @Autowired
    private ThreatFeedService threatFeedService;


    @GetMapping("/threat-feed")
    public String threatFeed(Model model) {
        model.addAttribute("incidents", threatFeedService.getLatestIncidents());
        return "threat-feed"; // templates/threat-feed.html
    }


    @GetMapping(value = "/threat-feed-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String, String>> streamThreatFeed() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(i -> threatFeedService.getLatestIncidents().get(0)); // latest incident
    }
}
