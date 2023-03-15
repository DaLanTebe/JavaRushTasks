package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {
    private volatile boolean clientConnected = false;
    protected Connection connection;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("При отправе сообщения произошла ошибка");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента");
            return;
        }
        if (clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено." +
                    "Для выхода наберите команду 'exit'.");
            while (clientConnected){
                String text = ConsoleHelper.readString();
                if (text.equals("exit")){
                    break;
                }
                if (shouldSendTextFromConsole()){
                    sendTextMessage(text);
                }
            }
        }else ConsoleHelper.writeMessage("Произошла ошибка работы клиента.");
    }

    public class SocketThread extends Thread {
    }

    public static void main(String[] args) {
        new Client().run();
    }
}
