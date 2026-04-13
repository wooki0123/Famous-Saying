package org.domain.wiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayingList = new ArrayList<>();

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayingList;
    }

    public WiseSaying write (String author, String content) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, author, content );

        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    public List<WiseSaying> getWiseSayings() {
        return wiseSayingList;
    }

    public WiseSaying findById(int id) {
        return wiseSayingList.stream()
                .filter(ws -> ws.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
