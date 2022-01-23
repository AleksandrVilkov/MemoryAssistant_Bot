/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Режим очистки списка рассылки сообщений
 */
package States;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import bot.Bot;
import bot.UserInteraction;

public class Clear extends State {

    public Clear(Bot bot) {
        super(bot);
        System.out.println("Выбран режим очистки");
        String IS_CLEAR_MODE_MESSAGE = Emodji.WARNING + " Запущен режим очистки списка. " +
                "При подтверждении действия я удалю ВСЕ записи. \n" +
                "Мне точно это сделать?";
        UserInteraction.sendMessageWithCommands(IS_CLEAR_MODE_MESSAGE, this.bot.getId(),
                Emodji.CHECK_MARK + " Да, очистить", YES,
                Emodji.EXCLAMATION_POINT + " Нет, оставить", NO);
    }

    @Override
    public void actionMode(String message) {

        switch (message) {
            case YES -> {
                if (bot.getMessageList().isEmpty()) {
                    UserInteraction.sendMessage(SystemMessages.DICTIONARY_IS_EMPTY_MESSAGE, bot.getId());
                } else {
                    bot.getMessageList().clear();
                    UserInteraction.sendMessage(SystemMessages.CANCEL_MESSAGE, bot.getId());
                }
                this.bot.setState(new Wait(this.bot));
                return;
            }
            case NO -> UserInteraction.sendMessage(SystemMessages.NOT_CANCEL_MESSAGE, bot.getId());

            default -> UserInteraction.sendMessage(SystemMessages.ERROR_MESSAGE, bot.getId());
        }
        this.bot.setState(new Wait(this.bot));

    }

}
