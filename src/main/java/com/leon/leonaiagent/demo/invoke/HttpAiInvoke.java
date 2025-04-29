package com.leon.leonaiagent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * HTTP方式 AI调用
 */
public class HttpAiInvoke {
    public static void main(String[] args) {
        // 替换为你的API Key
        String apiKey = TestApiKey.API_KEY;

        // 构建请求URL
        String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

        // 构建消息数组
        JSONArray messages = JSONUtil.createArray();
        messages.add(JSONUtil.createObj()
                .set("role", "system")
                .set("content", "You are a helpful assistant."));
        messages.add(JSONUtil.createObj()
                .set("role", "user")
                .set("content", "你是谁？"));

        // 构建请求体JSON
        JSONObject requestBody = JSONUtil.createObj()
                .set("model", "qwen-plus")
                .set("input", JSONUtil.createObj()
                        .set("messages", messages))
                .set("parameters", JSONUtil.createObj()
                        .set("result_format", "message"));

        // 发送POST请求
        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .execute();

        // 输出响应结果
        System.out.println(response.body());
    }
}