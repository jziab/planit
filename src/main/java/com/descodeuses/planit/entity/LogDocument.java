package com.descodeuses.planit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Document(collection = "LogDocument")
public class LogDocument {

    @Id
    private String id;

    private String text;
    private LocalDateTime timestamp; // ⏱️
    private Map<String, Object> extras = new HashMap<>(); // 🔧

  public LogDocument(String text) {
        this.id = UUID.randomUUID().toString(); // ID personnalisé
        this.text = text;
        this.timestamp = LocalDateTime.now(); 
        this.extras=new HashMap<>(); 
    }

    public LogDocument() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Map<String, Object> getExtras() { return extras; }
    public void setExtras(Map<String, Object> extras) { this.extras = extras; }

    public void addExtra(String key, Object value) {
        this.extras.put(key, value);
    }
}

