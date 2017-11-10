package com.example.lenovo.myapplication; /**
 * Created by lenovo on 2017/11/7.
 */

import android.content.res.AssetManager;
import android.os.Trace;
import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

public class MyTSF {
    private static final String MODEL_FILE = "./assets/model.pb";
    private static final int HEIGHT = 1;
    private static final int WIDTH = 2;
    private static final String inputName="input";
    private float[] inputs = new float[HEIGHT * WIDTH];
    private static final String outputName = "output";
    private float[] outputs = new float[HEIGHT * WIDTH];
    TensorFlowInferenceInterface inferenceInterface;

    static {
        System.loadLibrary("tensorflow_inference");
    }

    MyTSF(AssetManager assetManager) {
        inferenceInterface = new TensorFlowInferenceInterface(assetManager, MODEL_FILE);
    }

    public float[] getAddResult() {
        inputs[0]=1;
        inputs[1]=3;
        Trace.beginSection("feed");
        inferenceInterface.feed(inputName,inputs,WIDTH,HEIGHT);
        Trace.endSection();

        Trace.beginSection(("run");
        String[] outputNames=new String[]{outputName};
        inferenceInterface.run(outputNames);
        Trace.endSection();

        Trace.beginSection("fetch");
        inferenceInterface.fetch(outputName,outputs);
        Trace.endSection();

        return outputs;
    }
}
