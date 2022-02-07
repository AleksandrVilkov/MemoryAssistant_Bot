package bot;


import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello World");
//        logger.info("Start my app");
//        TelegramBotsApi botsApi;
//        try {
//            logger.info("Trying to register a bot");
//            botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            botsApi.registerBot(new UserInteraction());
//            logger.info("Bot successfully created!");
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//            logger.error("ERROR! Failed to create bot!");
//        }
    }


}
