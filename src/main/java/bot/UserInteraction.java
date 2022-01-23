/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Следит за сообщениями пользователя. Отправляет пользователю сообщения от бота
 */
package bot;

import Parsers.JsonSimpleParser;
import TextResourses.Emodji;
import TextResourses.SystemMessages;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;

public class UserInteraction extends TelegramLongPollingBot {

    private static String TOKEN;
    private static String USERNAME;
    private final HashMap<String, Bot> bot = new HashMap<>();

    public UserInteraction() {
        JsonSimpleParser jsonSimpleParser = new JsonSimpleParser();
        BotAuthorization botAuthorization = jsonSimpleParser.parse();
        TOKEN = botAuthorization.getToken();
        USERNAME = botAuthorization.getUsername();
    }

    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        if (update.hasMessage() && update.getMessage().hasText()) {
            //Проверяем, есть ли у нас пользователь, и если нет - создаем ему свого бота
            if (!(bot.containsKey(chatId))) {
                sendMessage("Добро пожаловать! " + Emodji.MEMO, chatId);
                bot.put(chatId, new Bot(chatId));
                sendMessage(Emodji.SMILE, chatId);
                return;
            }
            String userMessage = update.getMessage().getText().trim();
            bot.get(chatId).setCommand(userMessage); // Получаем сообщение и показываем боту

        } else {
            sendMessage(SystemMessages.ERROR_MESSAGE, chatId);
        }
        System.out.println(bot.get(chatId).getState().getClass());
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    public static void sendMessage(String text, String chat_id) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1;
//
//        //Сама клавиатура
//        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
//        //Кнопка
//        InlineKeyboardButton button1 = new InlineKeyboardButton();
//        button1.setText(nameCom1);
//        button1.setCallbackData(com1);
//        //Добавляем в ряд
//        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
//        keyboardButtonsRow1.add(button1);
//        //Список рядов
//        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
//        //Добавляем в ряд
//        rowList.add(keyboardButtonsRow1);
//        //добаяем в клавиатуру
//        keyboardMarkup.setKeyboard(rowList);
        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        //      message.setReplyMarkup(keyboardMarkup);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1, String nameCom2, String com2) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n";

        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1,
                                               String nameCom2, String com2,
                                               String nameCom3, String com3) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n" +
                nameCom3 + " - " + com3 + "\n";
        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1,
                                               String nameCom2, String com2,
                                               String nameCom3, String com3,
                                               String nameCom4, String com4) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n" +
                nameCom3 + " - " + com3 + "\n" +
                nameCom4 + " - " + com4 + "\n";
        SendMessage message = new SendMessage();

        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1,
                                               String nameCom2, String com2,
                                               String nameCom3, String com3,
                                               String nameCom4, String com4,
                                               String nameCom5, String com5) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n" +
                nameCom3 + " - " + com3 + "\n" +
                nameCom4 + " - " + com4 + "\n" +
                nameCom5 + " - " + com5 + "\n";
        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1,
                                               String nameCom2, String com2,
                                               String nameCom3, String com3,
                                               String nameCom4, String com4,
                                               String nameCom5, String com5,
                                               String nameCom6, String com6) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n" +
                nameCom3 + " - " + com3 + "\n" +
                nameCom4 + " - " + com4 + "\n" +
                nameCom5 + " - " + com5 + "\n" +
                nameCom6 + " - " + com6 + "\n";
        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1,
                                               String nameCom2, String com2,
                                               String nameCom3, String com3,
                                               String nameCom4, String com4,
                                               String nameCom5, String com5,
                                               String nameCom6, String com6,
                                               String nameCom7, String com7,
                                               String nameCom8, String com8) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n" +
                nameCom3 + " - " + com3 + "\n" +
                nameCom4 + " - " + com4 + "\n" +
                nameCom5 + " - " + com5 + "\n" +
                nameCom6 + " - " + com6 + "\n" +
                nameCom7 + " - " + com7 + "\n" +
                nameCom8 + " - " + com8 + "\n";
        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1,
                                               String nameCom2, String com2,
                                               String nameCom3, String com3,
                                               String nameCom4, String com4,
                                               String nameCom5, String com5,
                                               String nameCom6, String com6,
                                               String nameCom7, String com7,
                                               String nameCom8, String com8,
                                               String nameCom9, String com9,
                                               String nameCom10, String com10) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n" +
                nameCom3 + " - " + com3 + "\n" +
                nameCom4 + " - " + com4 + "\n" +
                nameCom5 + " - " + com5 + "\n" +
                nameCom6 + " - " + com6 + "\n" +
                nameCom7 + " - " + com7 + "\n" +
                nameCom8 + " - " + com8 + "\n" +
                nameCom9 + " - " + com9 + "\n" +
                nameCom10 + " - " + com10 + "\n";
        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1,
                                               String nameCom2, String com2,
                                               String nameCom3, String com3,
                                               String nameCom4, String com4,
                                               String nameCom5, String com5,
                                               String nameCom6, String com6,
                                               String nameCom7, String com7,
                                               String nameCom8, String com8,
                                               String nameCom9, String com9) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n" +
                nameCom3 + " - " + com3 + "\n" +
                nameCom4 + " - " + com4 + "\n" +
                nameCom5 + " - " + com5 + "\n" +
                nameCom6 + " - " + com6 + "\n" +
                nameCom7 + " - " + com7 + "\n" +
                nameCom8 + " - " + com8 + "\n" +
                nameCom9 + " - " + com9 + "\n";
        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithCommands(String textMessage, String chat_id, String nameCom1, String com1,
                                               String nameCom2, String com2,
                                               String nameCom3, String com3,
                                               String nameCom4, String com4,
                                               String nameCom5, String com5,
                                               String nameCom6, String com6,
                                               String nameCom7, String com7,
                                               String nameCom8, String com8,
                                               String nameCom9, String com9,
                                               String nameCom10, String com10,
                                               String nameCom11, String com11
    ) {
        String massage = textMessage + "\n" +
                nameCom1 + " - " + com1 + "\n" +
                nameCom2 + " - " + com2 + "\n" +
                nameCom3 + " - " + com3 + "\n" +
                nameCom4 + " - " + com4 + "\n" +
                nameCom5 + " - " + com5 + "\n" +
                nameCom6 + " - " + com6 + "\n" +
                nameCom7 + " - " + com7 + "\n" +
                nameCom8 + " - " + com8 + "\n" +
                nameCom9 + " - " + com9 + "\n" +
                nameCom10 + " - " + com10 + "\n" +
                nameCom11 + " - " + com11 + "\n";
        SendMessage message = new SendMessage();
        message.setText(massage);
        message.setChatId(chat_id);
        try {
            new UserInteraction().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
