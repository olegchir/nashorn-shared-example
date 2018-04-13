package com.olegchir.conferences.example.springbootsharedjs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.script.*;
import java.io.File;
import java.nio.file.Files;

public class JSExecutor {
    private static final Logger logger = LoggerFactory.getLogger(JSExecutor.class);

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    Invocable invoker = (Invocable) engine;

    public JSExecutor() {
        try {
            File bootstrapFile = new ClassPathResource("validator.js").getFile();
            String bootstrapString = new String(Files.readAllBytes(bootstrapFile.toPath()));
            engine.eval(bootstrapString);
        } catch (Exception e) {
            logger.error("Can't load bootstrap JS!", e);
        }
    }

    public Object execute(String code) {
        Object result = null;
        try {
            result = engine.eval(code);
        } catch (Exception e) {
            logger.error("Can't run JS!", e);
        }
        return result;
    }

    public Object executeFunction(String name, Object... args) {
        Object result = null;
        try {
            result = invoker.invokeFunction(name, args);
        } catch (Exception e) {
            logger.error("Can't run JS!", e);
        }
        return result;
    }
}
