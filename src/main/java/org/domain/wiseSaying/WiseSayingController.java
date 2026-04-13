package org.domain.wiseSaying;

import org.Rq;
import org.WiseSaying;

import java.util.List;
import java.util.Scanner;


public class WiseSayingController {
    private final Scanner scanner;
    private WiseSayingService wiseSayingService;

    public WiseSayingController (Scanner scanner) {
        this.scanner = scanner;
        this.wiseSayingService = new WiseSayingService();
    }

    public void actionWrite() {
        System.out.print("명언: ");
        String content = scanner.nextLine().trim();

        System.out.print("작가: ");
        String author = scanner.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingService.write(author, content);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList() {
        List<WiseSaying> wiseSayingList =  wiseSayingService.getWiseSayings();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

//        for (int i = wiseSayingList.size() - 1; i >=0; i--) {
//            WiseSaying wiseSaying = wiseSayingList.get(i);
//            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
//        } 스트림 X


        wiseSayingList.reversed()
                .stream()
                .map(wiseSaying -> "%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()))
                .forEach(System.out::println);
    }

    public void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        if (id == -1) {
            return;
        }
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            return;
        }

        wiseSayingService.delete(wiseSaying);

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    public void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if (id < -1) {
            return;
        }
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            return;
        }

        System.out.printf("명언(기존) : %s\n",  wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.printf("작가(기존) : %s\n",  wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        wiseSayingService.modify(wiseSaying, content, author);

        System.out.println("%d번 명언이 수정 되었습니다.".formatted(id));
    }

}
