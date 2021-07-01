package com.DefaultCompany.UnityBridgeSample;

import com.google.gson.Gson;

/**
 * Create by Wang.Jiahui
 * description:
 * on 2021/6/1
 */
public class AndroidMethod {

    public static String fromObject2Json(Object object){
        return (addEscapes(new Gson().toJson(object)));
    }

    public static String addEscapes(String strjson)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strjson.length(); i++)
        {
            char c = strjson.toCharArray()[i]; //转换为字节数组
            switch (c)
            {
                case '\"': sb.append("\\\""); break;

                case '\\': sb.append("\\\\"); break;

                case '/': sb.append("\\/"); break;

                case '\b': sb.append("\\b"); break;

                case '\f': sb.append("\\f"); break;

                case '\n': sb.append("\\n"); break;

                case '\r': sb.append("\\r"); break;

                case '\t': sb.append("\\t"); break;

                default: sb.append(c); break;
            }
        }
        return sb.toString();
    }
}
