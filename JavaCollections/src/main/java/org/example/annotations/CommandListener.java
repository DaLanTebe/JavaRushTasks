package org.example.annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandListener {

    @Command(name = "привет",
            args = "",
            desc = "Будь культурным, поздоровайся",
            showInHelp = false,
            aliases = {"здаров"})
    public void hello(){
    }
}
