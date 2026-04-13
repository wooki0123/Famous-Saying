package org.domain.wiseSaying;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying write (String author, String content) {
        WiseSaying wiseSaying = new WiseSaying(content, author);
        return this.wiseSayingRepository.save(wiseSaying);
    }
    public void delete(WiseSaying wiseSaying) {
        this.wiseSayingRepository.delete(wiseSaying);
    }
    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
        this.wiseSayingRepository.save(wiseSaying);
    }
    public List<WiseSaying> getWiseSayings() {
        return this.wiseSayingRepository.getWiseSayingList();
    }
    public WiseSaying findById(int id) {
        return this.wiseSayingRepository.findById(id);
    }
}
