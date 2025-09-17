package com.javarush.kalichinskaia.quest;

import lombok.Getter;

@Getter
public enum Step {
    STEP1("Ты потерял память. Принять вызов НЛО?", "Принять вызов", "Отклонить вызов", "Ты отклонил вызов. Поражение"),
    STEP2("Ты принял вызов. Поднимешься на мостик к капитану?", "Подняться на мостик", "Отказаться подниматься на мостик", "Ты не пошел на переговоры. Поражение"),
    STEP3("Ты поднялся на мостик. Ты кто?", "Рассказать правду о себе", "Солгать о себе", "Твою ложь разоблачили. Поражение");

    private final String question;
    private final String answer1;
    private final String answer2;
    private final String endMessage;

    Step(String question, String answer1, String answer2, String endMessage) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.endMessage = endMessage;
    }
}
