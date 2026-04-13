package org;

import org.domain.system.SystemController;
import org.domain.wiseSaying.WiseSayingController;
import org.domain.wiseSaying.WiseSayingRepository;
import org.domain.wiseSaying.WiseSayingService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppContext {
    public static final Scanner scanner = new Scanner(System.in);
    public static final DateTimeFormatter formatDateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd:HH:mm:ss");
    public static final SystemController systemController = new SystemController();
    public static final WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public static final WiseSayingService wiseSayingService = new WiseSayingService();
    public static final WiseSayingController wiseSayingController = new WiseSayingController();
}
