using System;
using System.Collections.Generic;
using UnityEngine;

public class CallBridge
{
    private static AndroidJavaObject bridge = new AndroidJavaClass("com.rokid.unitycallbridge.UnityCallBridge");
    public static List<string> cmdlist = new List<string>();

    public static AndroidJavaObject callAndroid(Request request)
    {
        return bridge.CallStatic<AndroidJavaObject>("onUnityCall", createBaseRequest(request));
    }

    public static bool covertBool(AndroidJavaObject obj)
    {
        return bridge.CallStatic<bool>("ConvertBoolean", obj);
    }

    public static int covertInt(AndroidJavaObject obj)
    {
        return bridge.CallStatic<int>("ConvertInt", obj);
    }

    public static string covertString(AndroidJavaObject obj)
    {
        return bridge.CallStatic<string>("ConvertString", obj);
    }

    public static string fromObject2Json(AndroidJavaObject obj)
    {
        return bridge.CallStatic<string>("fromObject2Json", obj);
    }

    public static Request.Callback createCallback(string name, string method)
    {
        return createCallback(name, method, null);
    }

    public static Request.Callback createCallback(string name, string method, string param)
    {
        Request.Callback joinCallback = new Request.Callback();
        joinCallback.name = name;
        joinCallback.method = method;
        joinCallback.param = param;
        return joinCallback;
    }

    private static string createBaseRequest(Request request)
    {
        Debug.Log("request = " + JsonUtility.ToJson(request));
        return JsonUtility.ToJson(request);
    }
}