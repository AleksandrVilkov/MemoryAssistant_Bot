/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Режим удаления соообщения из списка рассылки
 */
package States;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import bot.Bot;
import bot.UserInteraction;

import java.util.List;

public class Delete extends State {

    private static final String IS_DELETE_MODE_MESSAGE = Emodji.WARNING + " Запущен режим удаления записи. \n" +
            "Ответным собщением пришли мне позицию, и я ее удалю. \n" +
            Emodji.EXCLAMATION_POINT + "Закончить - " + EXIT;
    List<String> dictionary;

    public Delete(Bot bot) {
        super(bot);
        this.dictionary = bot.getMessageList();
        UserInteraction.sendMessage(IS_DELETE_MODE_MESSAGE, this.bot.getId());
        showDictionary();
    }


    public void showDictionary() {
        if (dictionary.isEmpty()) {
            UserInteraction.sendMessage(SystemMessages.DICTIONARY_IS_EMPTY_MESSAGE, bot.getId());
        } else {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < dictionary.size(); i++) {
                str.append(Emodji.ARROW + " ").append(i + 1).append(". ").append(dictionary.get(i)).append("\n");
            }
            UserInteraction.sendMessage(str.toString(), bot.getId());
        }
    }

    @Override
    public void actionMode(String message) {
        if (message.equals(EXIT)) {
            this.bot.setState(new Wait(this.bot));
        } else {
            int index;
            try {
                index = Integer.parseInt(message) - 1; //Приводим значения полтзователя к значению индекса
                this.bot.getMessageList().remove(index);
            } catch (Exception e) {
                UserInteraction.sendMessage(Emodji.EXCLAMATION_POINT + "Ты ввел не верное значение!",
                        this.bot.getId());
                this.bot.setState(new Delete(this.bot));
                return;
            }
            UserInteraction.sendMessage(SystemMessages.SUCCESSFULLY_DELETED, this.bot.getId());
            this.bot.setState(new Delete(this.bot));
        }
    }
}
