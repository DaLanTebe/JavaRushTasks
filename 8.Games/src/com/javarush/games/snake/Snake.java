package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN ="\uD83D\uDC7E";
    private static final String BODY_SIGN ="\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        GameObject obj1 = new GameObject(x, y);
        GameObject obj2 = new GameObject(x + 1, y);
        GameObject obj3 = new GameObject(x + 2, y);
        snakeParts.add(obj1);
        snakeParts.add(obj2);
        snakeParts.add(obj3);
    }

    public void draw(Game game){
        for (int i = 0; i < snakeParts.size(); i++) {
            String sign = i == 0 ? HEAD_SIGN : BODY_SIGN;
                game.setCellValue(snakeParts.get(i).x,snakeParts.get(i).y, sign);
        }
    }
}
