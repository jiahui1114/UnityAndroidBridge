using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;

public class CallAndroid : MonoBehaviour
{

    // Start is called before the first frame update
    void Start()
    {
        Invoke("showToast", 5f);

        Invoke("showToastWithCallback", 10f);

        Invoke("showToastWithAndroidParam", 15f);
    }

    private void showToast()
    {
        CallBridge.callAndroid(Request.Build()
            .Name("Toast.show")
            .Param("text", "Show toast call from Unity"));
    }

    public void showToastWithCallback()
    {
        CallBridge.callAndroid(Request.Build()
            .Name("Toast.showWithCallback")
            .Param("text", "Show toast with Callback call from Unity ")
            .AndroidCallback(CallBridge.createCallback("CallBridgeSample", "showToastCallback")));
    }

    public void showToastWithAndroidParam()
    {
        CallBridge.callAndroid(Request.Build()
            .Name("Toast.showWithAndroidParam")
            .Param("text", "Show toast with Android param call from Unity")
            .Param("context", "Toast.getActivity"));
    }

    public void showToastCallback(string msg)
    {
        CallBridge.callAndroid(Request.Build()
            .Name("Toast.show")
            .Param("text", "callback message: " + msg + " received!"));
    }
}