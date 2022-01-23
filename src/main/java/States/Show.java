/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Режим показа списка сообщений
 */
package States;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import bot.Bot;
import bot.UserInteraction;

import java.util.List;

public class Show extends State {

    List<String> dictionary;
    private static final String IS_SHOW_MODE_MESSAGE = Emodji.WARNING + " Запущен режим просмотра списка";

    public Show(Bot bot) {
        super(bot);
        this.dictionary = bot.getMessageList();

        UserInteraction.sendMessage(IS_SHOW_MODE_MESSAGE, this.bot.getId());
        showDictionary();
    }


    public void showDictionary() {
        if (dictionary.isEmpty()) {
            UserInteraction.sendMessage(SystemMessages.DICTIONARY_IS_EMPTY_MESSAGE, bot.getId());
            this.bot.setState(new Edit(this.bot));
        } else {
            String str = "";
            for (int i = 0; i < dictionary.size(); i++) {
                str += Emodji.ARROW + " " + (i + 1) + ". " + dictionary.get(i) + "\n";
            }
            UserInteraction.sendMessageWithCommands(str, bot.getId(),
                    Emodji.MAIL + " Запустить работу", START,
                    Emodji.SETTING + " Настройки", SET_SETTING,
                    Emodji.MEMO + " Посмотреть список", SHOW,
                    Emodji.MEMO + "Редактировать список", EDIT
            );
        }
    }
}
