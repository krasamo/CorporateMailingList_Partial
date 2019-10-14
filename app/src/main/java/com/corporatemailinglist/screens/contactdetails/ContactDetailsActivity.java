package com.corporatemailinglist.screens.contactdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.corporatemailinglist.R;
import com.corporatemailinglist.repository.firestore.ContactsFirestoreDbContract;
import com.corporatemailinglist.repository.firestore.ContactsFirestoreManager;

public class ContactDetailsActivity extends AppCompatActivity {

    /* Constants to define the database operation type */
    public static final String OPERATION = "OPERATION";
    public static final String CREATING = "CREATING";
    public static final String EDITING = "EDITING";

    private String operationTypeString;

    /* Repository reference */
    private ContactsFirestoreManager contactsFirestoreManager;

    /* Document ID of this particular Contact item */
    private String documentId;

    /* Widgets */
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;

    private Button deleteButton;
    private Button okButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_form_activity);

        // Get a reference of contactsFirestoreManager
        // TODO: 4.1 Creating a Contact

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);

        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new DeleteButtonOnClickListener());

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new OKButtonOnClickListener());

        // Get the extras from the Intent
        Bundle bundle = getIntent().getExtras();

        operationTypeString = bundle.getString(OPERATION);
        if (operationTypeString.equals(CREATING)) {
            okButton.setText("CREATE");
            deleteButton.setVisibility(View.GONE);

        } else if (operationTypeString.equals(EDITING)) {
            okButton.setText("UPDATE");
            deleteButton.setVisibility(View.VISIBLE);

            // TODO: 4.2 Updating a Contact
        }
    }

    private class OKButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            String firstNameString = firstNameEditText.getText().toString();
            String lastNameString = lastNameEditText.getText().toString();
            String emailString = emailEditText.getText().toString();

            // Contact contact = new Contact(documentId, firstNameString, lastNameString, emailString);

            if (operationTypeString.equals(CREATING)) {
                // TODO: 4.1 Creating a Contact

            } else if (operationTypeString.equals(EDITING)) {
                // TODO: 4.2 Updating a Contact
            }

            finish();
        }
    }

    private class DeleteButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // TODO: 4.3 Deleting a Contact

            finish();
        }
    }
}
