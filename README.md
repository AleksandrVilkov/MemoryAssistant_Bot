# MemoryAssistant_Bot

Бот, который призван помочь пользователю в запоминании различных вещей, например перевод слов, даты, утверждения, тезисы.

Схема работы: 

Пользователь создает список и наполняет информацией, которую бот в дальнейшем будет ему присылать. 
Если настройки по умолчанию пользователю не подходят - он может изменить их в меню настроек, изменив периодичность отправки сообщений, часовой пояс, и рабочее время бота. 
Также этот список можно редактировать: удалять запись, добавлять записи в уже существующий список, полностью очищать список. 

Реализация:

Был использован Telegram Bot API. В качестве сборщика проекта - Maven.
При реализации проекта был использован паттерн проектирования Состояние.
Паттерн состояние был применен для отслеживания, в каком состоянии находится бот: рассылки, настройки, ожидании, редактировании и т.д.
В качестве контекста выступает класс Bot, который хранит ссылку на объект состояния state и делегирует ему часть работы, зависящей от состояний. Bot иметь метод для присваивания ему нового объекта-состояния setState.
Состояние описано абстрактным классом State. 
Пакет States содержит в себе реализацию каждого конкретного состояния. 
Для хранения информации о всех пользователях, которые есть у бота используется HashMap, для хранения списка - ArrayList.
Рассылка сообщений реализована в отдельном потоке что позволяет менять состояние бота во время работы отправки сообщений.
