package org.domain.wiseSaying;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WiseSaying {
    private int id;
    private String content;
    private String author;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd:HH:mm:ss");

    public WiseSaying(String content, String author) {
        LocalDateTime now = LocalDateTime.now();
        this.content = content;
        this.author = author;
        this.createDate = now;
        this.modifiedDate = now;
    }

    public boolean isNew() {
        return getId() == 0;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreateDate() {
        return createDate.format(formatter);
    }

    public String getModifiedDate() {
        return modifiedDate.format(formatter);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
