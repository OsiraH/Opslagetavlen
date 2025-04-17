package com.example.webapp;
import java.time.LocalDateTime;

public record Post(String author, String content, LocalDateTime creationDate) {}
