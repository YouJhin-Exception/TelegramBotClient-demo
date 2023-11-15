package com.example.demobot.system.entyS;


import lombok.Data;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetThumb;
import org.telegram.telegrambots.meta.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;

/*
На самом деле, всё можно сделать и без этого класса, если вы собираетесь отвечать пользователю
только сообщениями или коллбэками. Потому что в будущем этот класс ещё и увеличит немного кода.
Я лишь стараюсь увеличить расширяемость, чтобы внедрение новой фичи делалось быстро и легко.
 */
@Data
public class Answer {
    private SendDocument sendDocument;
    private SendPhoto sendPhoto;
    private SendVideo sendVideo;
    private SendVideoNote sendVideoNote;
    private SendSticker sendSticker;
    private SendAudio sendAudio;
    private SendVoice sendVoice;
    private SendMediaGroup sendMediaGroup;
    private SetChatPhoto setChatPhoto;
    private AddStickerToSet addStickerToSet;
    private SetStickerSetThumb setStickerSetThumb;
    private CreateNewStickerSet createNewStickerSet;
    private UploadStickerFile uploadStickerFile;
    private EditMessageMedia editMessageMedia;
    private SendAnimation sendAnimation;
    private BotApiMethod<?> botApiMethod;
}
