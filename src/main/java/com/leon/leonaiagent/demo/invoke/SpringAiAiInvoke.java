package com.leon.leonaiagent.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;

/**
 * Spring AI框架调用 AI 大模型
 */
//@Component
public class SpringAiAiInvoke implements CommandLineRunner {
    @Resource
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
        String text = dashscopeChatModel.call(new Prompt("你好，我是leon"))
                .getResult()
                .getOutput()
                .getText();
        System.out.println("text = " + text);
    }
}
