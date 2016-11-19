package iotgateway.progprak.tkm.com.iotgateway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar frequency;
    private TextView frequencyText;
    private Button connectButton;
    boolean started = false;
    private Button selectSensorButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       initializeObjects();

        frequencyText.setText(frequency.getProgress() + "ms");
        frequency.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                frequencyText.setText(progress*10 + "ms");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
           // frequencyText.setText(progress*10 + "ms");
            }
        });



        connectButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(!started) {
                    connectButton.setText(R.string.stop_button);
                    connectButton.setBackgroundColor(0xa2ff0000);


                    started = true;
                }else{
                    connectButton.setText(R.string.start_button);
                    connectButton.setBackgroundResource(android.R.drawable.btn_default);
                    started = false;

                }


            }
        });

        selectSensorButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent selSensIntent = new Intent(getApplicationContext(), SensorActivity.class);
                startActivity(selSensIntent);

            }
        });


    }

    public void initializeObjects(){

        frequencyText = (TextView) findViewById(R.id.frequencyTextViewId);
        frequency = (SeekBar) findViewById(R.id.frequencyBarId);
        connectButton = (Button) findViewById(R.id.connect_buttonId);
        selectSensorButton = (Button) findViewById(R.id.sel_sensorButtonId);

    }
}
