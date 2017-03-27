package com.vnurture.vnurture.gmaillayout;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    String[] emailId;
    String[] mailId;

    ActionBar actionBar;

    Button buttonFrom;
    Button buttonTo;

    ImageView imageAttachment;

    LinearLayout toLinearLayout;

    EditText textSubject;

    Uri imageUri = null;

    Intent intent;

    private final static int PICK_FROM_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // imageAttachment = (ImageView) findViewById(R.id.image_view_attachment);


        buttonTo = (Button) findViewById(R.id.to_image_button);

        toLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_to);

        textSubject = (EditText) findViewById(R.id.text_subject);

        emailId = getResources().getStringArray(R.array.Your_Email);
        mailId = getResources().getStringArray(R.array.mail);

        /*final Spinner spinner = (Spinner) findViewById(R.id.your_email);
        Spinner spin = (Spinner) findViewById(R.id.mail);*/
        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Your EmailID is Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

        /*buttonSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.performClick();
            }
        });

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,emailId);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(aa);



        buttonSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.performClick();
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mailId);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(adapter);*/
        buttonTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLinearLayout.setVisibility(View.VISIBLE);
            }
        });

        textSubject.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                toLinearLayout.setVisibility(View.GONE);
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.attachment_icon:
            {
                // Single menu item is selected do something
                // Ex: launching new activity/screen or show alert message

//                Intent intent = new Intent();
//                intent.setType("Image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.putExtra("return-data",true);
//                startActivityForResult(Intent.createChooser(intent,"Hello"),PICK_FROM_REQUEST);
                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);

               // Toast.makeText(MainActivity.this, "Attachment is Selected", Toast.LENGTH_SHORT).show();
                return true;
            }

            case R.id.send_icon:
            {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.setAction(Intent.ACTION_SENDTO);
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Sending mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

               // Toast.makeText(MainActivity.this, "Send is Selected", Toast.LENGTH_SHORT).show();
                return true;
            }

            case R.id.draft_text:
            {


                Toast.makeText(MainActivity.this, "Draft is Selected", Toast.LENGTH_SHORT).show();
                return true;
            }

            case R.id.discard_text:
            {
                Toast.makeText(MainActivity.this, "Discard is Selected", Toast.LENGTH_SHORT).show();
                return true;
            }

            case R.id.settings_text:
            {
                Intent intentSettings = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivityForResult(intentSettings,0);

                Toast.makeText(MainActivity.this, "Settings is Selected", Toast.LENGTH_SHORT).show();
                return true;
            }

            case R.id.help_text:
            {
                Toast.makeText(MainActivity.this, "Help & feedback is Selected", Toast.LENGTH_SHORT).show();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            switch(requestCode){
                case 0:
                    imageUri = data.getData();
                    //textImagePath.setText(imageUri.toString());
//                   Toast.makeText(this, ""+imageUri.toString(), Toast.LENGTH_SHORT).show();

                    TableLayout ll = (TableLayout) findViewById(R.id.table_layout_image_view);




                    TableRow row= new TableRow(this);
                    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    row.setLayoutParams(lp);
                    imageAttachment = new ImageView(this);
                    Picasso.with(this).load(imageUri).resize(200,200).into(imageAttachment);
           //CheckBox checkBox = new CheckBox(this);
           // tv = new TextView(this);
//            addBtn = new ImageButton(this);
//            addBtn.setImageResource(R.drawable.add);
//            minusBtn = new ImageButton(this);
//            minusBtn.setImageResource(R.drawable.minus);
//            qty = new TextView(this);
          //  checkBox.setText("hello");
//            qty.setText("10");
           // row.addView(checkBox);
//            row.addView(minusBtn);
//            row.addView(qty);
//            row.addView(addBtn);
                    imageAttachment.setImageURI(imageUri);
                    row.addView(imageAttachment);
                    ll.addView(row);
                    break;
                case 1:

                    break;
            }

        }
    }
    
}
