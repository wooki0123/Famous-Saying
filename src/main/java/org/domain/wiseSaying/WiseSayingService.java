package org.domain.wiseSaying;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying write (String author, String content) {
        return this.wiseSayingRepository.write(author, content);
    }
    public void delete(WiseSaying wiseSaying) {
        this.wiseSayingRepository.delete(wiseSaying);
    }
    public void modify(WiseSaying wiseSaying, String content, String author) {
        this.wiseSayingRepository.modify(wiseSaying, content, author);
    }
    public List<WiseSaying> getWiseSayings() {
        return this.wiseSayingRepository.getWiseSayings();
    }
    public WiseSaying findById(int id) {
        return this.wiseSayingRepository.findById(id);
    }
}
