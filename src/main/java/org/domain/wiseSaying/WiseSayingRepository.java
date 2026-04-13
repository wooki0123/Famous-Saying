package org.domain.wiseSaying;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayingList = new ArrayList<>();

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayingList;
    }

//    public WiseSaying write (String author, String content) {
//        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author );
//
//        wiseSayingList.add(wiseSaying);
//
//        return wiseSaying;
//    }
//
//    public void modify(WiseSaying wiseSaying, String content, String author) {
//        wiseSaying.setContent(content);
//        wiseSaying.setAuthor(author);
//        wiseSaying.setModifiedDate(LocalDateTime.now());
//    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayingList.add(wiseSaying);
        } else {
            wiseSaying.setModifiedDate(LocalDateTime.now());
        }

        return wiseSaying;
    }

    public WiseSaying findById(int id) {
        return wiseSayingList.stream()
                .filter(ws -> ws.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
