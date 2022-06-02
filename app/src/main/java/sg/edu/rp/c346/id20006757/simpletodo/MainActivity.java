package sg.edu.rp.c346.id20006757.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText TextTasks;
    EditText TaskNo;
    Button btnAdd;
    Button btnDelete;
    Button btnClear;
    ListView lvTasks;
    Spinner TaskSpinner;
    TextView E1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextTasks = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnClear = findViewById(R.id.btnClear);
        lvTasks = findViewById(R.id.listviewTask);
        TaskNo = findViewById(R.id.editTextTaskNo);
        TaskSpinner = findViewById(R.id.spinner);
        E1 = findViewById(R.id.Enhancement1);


        ArrayList<String> ToDoTask;
        ArrayAdapter<String> Tasks;

        ToDoTask = new ArrayList<>();
        ToDoTask.add("Watch movie with Cheryl");
        ToDoTask.add("Attend IG on Friday with Cheryl");
        ToDoTask.add("Eat dinner with Cheryl");
        ToDoTask.add("Video call  with Cheryl");
        Tasks = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, ToDoTask);

        lvTasks.setAdapter(Tasks);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TaskUser = TextTasks.getText().toString();
                ToDoTask.add(TaskUser);
                Tasks.notifyDataSetChanged();
                TextTasks.setText(null);


            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoTask.clear();
                Tasks.notifyDataSetChanged();



            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(TaskNo.getText().toString());
                ToDoTask.remove(pos);
                Tasks.notifyDataSetChanged();




            }
        });

        TaskSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        E1.setText("Add a new task");

                        break;

                    case 1:
                        E1.setText("Remove a task");
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent){

            }
        });




    }
}