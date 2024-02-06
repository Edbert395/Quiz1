package edu.uph.duasatusi.latihankelas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveButton = (Button) findViewById(R.id.buttonSave);
        EditText editNameText = (EditText) findViewById(R.id.editNameText);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        CheckBox olahragaCheckBox = (CheckBox) findViewById(R.id.checkBoxOlahraga);
        CheckBox jalanJalanCheckBox = (CheckBox) findViewById(R.id.checkBoxJalanJalan);
        CheckBox makanCheckBox = (CheckBox) findViewById(R.id.checkBoxMakan);
        CheckBox belajarCheckBox = (CheckBox) findViewById(R.id.checkBoxBelajar);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String kegiatan = "";
                if (olahragaCheckBox.isChecked()) {
                    kegiatan += "- Olahraga";
                }
                if (jalanJalanCheckBox.isChecked()) {
                    if (kegiatan != "") kegiatan += "\n";
                    kegiatan += "- Jalan-jalan";
                }
                if (makanCheckBox.isChecked()) {
                    if (kegiatan != "") kegiatan += "\n";
                    kegiatan += "- Makan";
                }
                if (belajarCheckBox.isChecked()) {
                    if (kegiatan != "") kegiatan += "\n";
                    kegiatan += "- Belajar";
                }
                if (editNameText.getText().toString() == "" || checkedRadioButton == null || kegiatan == "") {
                    Toast.makeText(getApplication().getBaseContext(), "Harap lengkapi input terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                } else {
                    TextView simpanTV = (TextView) findViewById(R.id.hasilSimpanTV);
                    simpanTV.setVisibility(View.VISIBLE);
                    simpanTV.setText("Berhasil Disimpan\nNama Kegiatan: " +
                        editNameText.getText() + "\nTempat Kegiatan: " +
                            checkedRadioButton.getText() + "\nJenis Kegiatan: \n" +
                            kegiatan
                    );
                }
            }
        });
    }
}