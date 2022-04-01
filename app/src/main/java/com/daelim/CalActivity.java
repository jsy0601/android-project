package com.daelim;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    String rule = ""; //사칙연산기호
    int value1; //값1
    int value2; //값2
    boolean check = false; //기호 연속입력방지 (기호 입력시 true로)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        textView = findViewById(R.id.tv_text1);
        editText = findViewById(R.id.et_text2);
        editText.setInputType(0); //타자기가 안뜸
    }


    public void num(View vw) {
        int id = vw.getId();
        String strtmp = editText.getText().toString();

        if (rule.equals("=") || rule.equals("error")) { //전에 입력한 기호가 등호였거나 에러인 경우 초기화
            initialize();
        }
        if (check) {
            editText.setText("");
            check = false;
        }
        if (strtmp.startsWith("0")) {
            editText.setText("");
        }


        switch (vw.getId()) {
            case R.id.bt_0:
                editText.append("0");
                break;
            case R.id.bt_1:
                editText.append("1");
                break;
            case R.id.bt_2:
                editText.append("2");
                break;
            case R.id.bt_3:
                editText.append("3");
                break;
            case R.id.bt_4:
                editText.append("4");
                break;
            case R.id.bt_5:
                editText.append("5");
                break;
            case R.id.bt_6:
                editText.append("6");
                break;
            case R.id.bt_7:
                editText.append("7");
                break;
            case R.id.bt_8:
                editText.append("8");
                break;
            case R.id.bt_9:
                editText.append("9");
                break;
        }
    }


    public void symbol(View v) {
        String strtmp = editText.getText().toString(); //입력부분을 문자열로 전환한다
        if (rule.equals("=") || rule.equals("error")) { //전에 입력한 기호가 등호이거나 에러인 경우
            initialize();
        }
        if (!strtmp.equals("")) { //입력 부분이 빈칸이 아닌경우
            if (!check) {
                int numtmp = Integer.parseInt(strtmp);
                if (value1 == 0) {
                    value1 = numtmp;
                    editText.setText(setNum(value1));
                } else {
                    value2 = numtmp;
                    calculate();
                }
                textView.append(setNum(numtmp));
            }

            switch (v.getId()) {
                //기호 입력
                case R.id.bt_divide:
                    if ((Integer.parseInt(strtmp) == 0 && rule.equals("/"))) { //입력부분의 숫자가 0이고 지금 누른 기호가 나누기인 경우
                        textView.setText("");
                        editText.setText("0을 나눌수는 없습니다.");
                        rule = "error";
                        break;
                    }
                    rule = "/";
                    break;
                case R.id.bt_multiple:
                    rule = "*";
                    break;
                case R.id.bt_minus:
                    rule = "-";
                    break;
                case R.id.bt_plus:
                    rule = "+";
                    break;
                case R.id.bt_remain:
                    rule = "%";
                    break;
            }
        } else { //빈칸인 경우 메시지 출력
            Toast.makeText(this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        if (check) {
            String tvtmp = textView.getText().toString(); //뷰에 있는 문자열을 받아옴
            tvtmp = tvtmp.substring(0, tvtmp.length() - 1);
            textView.setText(tvtmp + rule); //두번째 누른 기호 입력
        } else {
            textView.append(rule);
        }
        check = true; //기호입력체크
    }

    public void equal(View v) {
        String strtmp = editText.getText().toString();
        if (!rule.equals("") && !check) { //입력부분이 빈칸이 아니면서 직전에 기호를 입력하지 않은 경우 check=false
            int numtmp = Integer.parseInt(strtmp); //입력 부분 숫자로 전환
            if (!rule.equals("")) {
                if (rule.equals("/") && numtmp == 0) { //직전 기호가 나누기이고 입력 부분이 0인 경우 오류
                    editText.setText("오류");
                    textView.setText("");
                    rule = "error";
                    return;
                }
                value2 = numtmp; //두번째 값에 숫자를 넣음
                textView.append(setNum(numtmp) + "=");//뷰 부분에 추가
                calculate(); //계산
                value1 = 0; //초기화
                rule = "="; //등호 입력 표시
                check = true; //기호 입력 표시
            }
        }
    }

    private void initialize() {
        rule = "";
        textView.setText("");
        editText.setText("");
        value1 = 0;
        value2 = 0;
        check = false;
    }

    public void calculate() {
        switch (rule) {
            case "/":
                value1 = value1 / value2;
                break;
            case "*":
                value1 = value1 * value2;
                break;
            case "-":
                value1 = value1 - value2;
                break;
            case "+":
                value1 = value1 + value2;
                break;
            case "%":
                value1 = value1 % value2;
                break;
        }
        editText.setText(setNum(value1));
        value2 = 0;
    }

    public String setNum(int num) {
        String print;
        print = String.valueOf(num);
        return print; //문자열리턴
    }
}