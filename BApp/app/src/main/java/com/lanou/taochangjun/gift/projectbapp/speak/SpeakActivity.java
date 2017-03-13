package com.lanou.taochangjun.gift.projectbapp.speak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




/**
 * 张德鹏, 语音功能,,
 */
public class SpeakActivity extends AppCompatActivity {

//    private EditText editText;
//    private Button button;

//    private RecognizerDialog iatDialog;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_speak);
//
//         editText = (EditText) findViewById(R.id.activity_speak_edittext);
//         button = (Button) findViewById(R.id.activity_speak_button);
//
//        SpeechUtility.createUtility(SpeakActivity.this, SpeechConstant.APPID + "=58c10702");
//
//        iatDialog = new RecognizerDialog(SpeakActivity.this, mInitListener);
//
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                iatDialog.setListener(new RecognizerDialogListener() {
//                    String resultJson = "[";
//                    @Override
//                    public void onResult(RecognizerResult recognizerResult, boolean b) {
//                        if (!b) {
//                            resultJson += recognizerResult.getResultString() + ",";
//                        } else {
//                            resultJson += recognizerResult.getResultString() + "]";
//                        }
//
//                        if (b) {
//                            //解析语音识别后返回的json格式的结果
//                            Gson gson = new Gson();
//                            List< DictationResult> resultList = gson.fromJson(resultJson,
//                                    new TypeToken<List<DictationResult>>() {
//                                    }.getType());
//                            String result = "";
//                            for (int i = 0; i < resultList.size() - 1; i++) {
//                                result += resultList.get(i).toString();
//                            }
//                            editText.setText(result);
//                            //获取焦点
//                            editText.requestFocus();
//                            //将光标定位到文字最后，以便修改
//                            editText.setSelection(result.length());
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onError(SpeechError speechError) {
//                        speechError.getPlainDescription(true);
//                    }
//                });
//                iatDialog.show();
//            }
//        });
//
//
//
//    }
//
//    public static final String TAG = "MainActivity";
//    private InitListener mInitListener = new InitListener() {
//        @Override
//        public void onInit(int code) {
////            Log.d(TAG, "SpeechRecognizer init() code = " + code);
//            if (code !=  ErrorCode.SUCCESS) {
////                Toast.makeText(MainActivity.this, "初始化失败，错误码：" + code, Toast.LENGTH_SHORT).show();
//                Toast.makeText(SpeakActivity.this, "初始化错误", Toast.LENGTH_SHORT).show();
//            }
//        }
//    };

}
