/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс бота, обрабатывает сообщения от пользователя, хранит состояние и список сообщений
 */
package bot;

import TextResourses.Emodji;
import States.*;
import States.Setting.*;
import org.apache.log4j.Logger;
import settings.Settings;

import java.util.*;

public class Bot {
    private final String id;
    private State state;
    private final List<String> messageList;
    private final Settings settings;

    private static final Logger logger = Logger.getLogger(Bot.class);

    public State getState() {
        return state;
    }

    public String getId() {
        return id;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public Settings getSettings() {
        return settings;
    }


    public void setState(State state) {
        this.state = state;
    }


    public Bot(String id) {
        this.id = id;
        messageList = new ArrayList<>();
        settings = new Settings(0, 21, 9, 30);
        this.state = new Start(this);
    }

    public void setCommand(String command) {
        switch (command) {
            case State.START -> state = new Start(this);
            case State.ADD_NODE -> state = new AddNode(this);
            case State.DELETE_WORD -> state = new Delete(this);
            case State.CLEAR -> state = new Clear(this);
            case State.SHOW -> state = new Show(this);
            case State.EDIT -> state = new Edit(this);
            case State.EXIT -> state = new Wait(this);
            case State.SET_SETTING -> state = new Setting(this);
            case State.ABOUT -> state = new About(this);
            //Если сообщение не сожержит основные команды - действуем согласно установленоого состояния
            default -> state.actionMode(command);
        }
    }

    public void getPrintInformationAboutThisBot() {

        String about = Emodji.ROBOT + " Привет! Я бот, который поможет тебе в запоминании чего-либо. " + Emodji.BRAIN + "\n" +
                "\n" +
                Emodji.ROBOT + " Как я устроен:\n" +
                " Ты мне пишешь то, что хочешь запомнить. \n " +
                "Это может быть перевод слов: \n" +
                Emodji.BOOK + " Hello - привет.\n" +
                "\n" +
                "Может быть историческая дата: \n" +
                Emodji.MAC + " 1984 год - выпущен первый персональный компьютер Apple Macintosh.\n" +
                "\n" +
                "Может быть какое-то утверждение:\n" +
                Emodji.RUSSIA_FLAG + " Москва - столица Российской Федерации.\n" +
                "\n" +
                "Ну или еще что-нибудь, что захочешь." + Emodji.SMILE + "\n" +
                "\n" +
                Emodji.SETTING + " C помощью настроек ты задаешь мне переодичность - " +
                "как часто я могу присылать тебе сообщения, " +
                "время, в которое присылать, и часовой пояс, где ты находишься, что бы я корректно слал сообщения.\n" +
                "\n" +
                "По установленным настройкам я поочередно буду присылать тебе все то, что ты мне написал " +
                "с заданным интервалом. (По умолчанию это 30 мин). " + Emodji.STOP_WATCH + "\n\n" +
                Emodji.MAIL + " Получая уведомление от меня, ты будешь его прочитывать," +
                " и вскоре запомнишь то, что хотел. \n" +
                "\n" +
                "Что бы мной пользоваться - нужно использовать команды. Не переживай, я буду тебе их присылать :)";
        UserInteraction.sendMessage(about, this.getId());
    }
}
