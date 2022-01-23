/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс, опредлеяющий настройки бота. Хранит в себе параметры для отправки списка сообщений пользователю
 */

package settings;

import TextResourses.Emodji;

public class Settings {

    private int timer;
    private int timezone;
    private int nightHour;
    private int morningHour;

    public Settings(int timezone, int nightHour, int morningHour, int timer) {
        this.timezone = timezone;
        this.nightHour = nightHour;
        this.morningHour = morningHour;
        this.timer = timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }


    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public void setNightHour(int nightHour) {
        this.nightHour = nightHour;
    }

    public void setMorningHour(int morningHour) {
        this.morningHour = morningHour;
    }


    public int getTimezone() {
        return timezone;
    }

    public int getTimer() {
        return timer;
    }

    public int getNightHour() {
        return nightHour;
    }

    public int getMorningHour() {
        return morningHour;
    }

    @Override
    public String toString() {

        return Emodji.SETTING + "На текущий момент установлены следующие настройки: \n\n" +
                Emodji.ARROW + " Разница во времени с Московским часовым поясом " + timezone + " час(ов);\n" +
                Emodji.ARROW + " Время работы бота - с " + morningHour + " до " + nightHour + " часов; \n" +
                Emodji.ARROW + " Переодичность отправки сообщений составляет " + timer + " мин.";

    }
}
