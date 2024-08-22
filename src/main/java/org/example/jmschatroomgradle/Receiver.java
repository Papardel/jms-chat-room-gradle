package org.example.jmschatroomgradle;

import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Map;

enum Status {
    SUCCESS;
}

@Component
public class Receiver {
    @JmsListener(destination = "pub-sub-announcements")
    void processAnnouncement(Map<String, String> announcementMap) {
        var announcement = new Announcement(announcementMap.get("name"), announcementMap.get("message"));
        System.out.println("Received <%s>".formatted(announcement));
    }

    @JmsListener(destination = "pub-sub-announcements")
    @SendTo("status")
    Status prettyAnnouncement(Map<String, String> announcementMap) {
        var announcement = new Announcement(announcementMap.get("name"), announcementMap.get("message"));
        LoggerFactory.getLogger("pretty").info(announcement.toString());
        return Status.SUCCESS;
    }
}
