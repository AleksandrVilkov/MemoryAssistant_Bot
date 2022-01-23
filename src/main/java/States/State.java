/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Абстрактный класс - состояние.
 */
package States;

import bot.Bot;
import bot.UserInteraction;

public abstract class State {

    public static final String START = "/start";
    public static final String EDIT = "/edit";
    public static final String ABOUT = "/about";
    public static final String ADD_NODE = "/add_note";
    public static final String DELETE_WORD = "/delete";
    public static final String EXIT = "/exit";
    public static final String SHOW = "/show";
    public static final String SET_SETTING = "/set_setting";
    public static final String CLEAR = "/clear";
    public static final String YES = "/yes";
    public static final String NO = "/no";


    Bot bot;

    public State(Bot bot) {
        this.bot = bot;
    }

    public Bot getBot() {
        return bot;
    }

    public void actionMode(String message) {
        UserInteraction.sendMessageWithCommands("Ты написал \"" + message + "\", но к сожалению, " +
                        "я не знаю что это такое", this.bot.getId(),
                "Помощь", EDIT);
    }
}
