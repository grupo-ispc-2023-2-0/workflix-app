package tec.ispc.workflix.views.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

import tec.ispc.workflix.R;
import tec.ispc.workflix.databinding.ActivityLoginBinding;
import tec.ispc.workflix.views.ui.catalogo.CatalogoActivity;
import tec.ispc.workflix.views.ui.register.RegisterActivity;
import tec.ispc.workflix.views.ui.restablecer.RestablecerActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    Button sign_in_btn;
    EditText et_email, et_password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hook Edit text fields
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        // Hook Button

        sign_in_btn = findViewById(R.id.sign_in_btn);

        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticateUser();
            }
        });
    /*    loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;*/

      /*  loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }*/
    }

    private void authenticateUser() {
        // Chequear por error
        if (!validateEmail() || !validatePassword()){
            return;
        }
        // Fin check por errores
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        // The Url Posting to

        String url = "http://192.168.0.125:8080/api/v1/user/login";

        // Set paramaters
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", et_email.getText().toString());
        params.put("password", et_password.getText().toString());


    }

    private boolean validatePassword() {
        return true;
    }

    private boolean validateEmail() {
    return true;
    }

    public void irRegistro(View view) {
        Intent registroIntent = new Intent(this, RegisterActivity.class);
        startActivity(registroIntent);
    }
    public void irRestablecer(View view) {
        Intent restablecerIntent = new Intent(this, RestablecerActivity.class);
        startActivity(restablecerIntent);
    }
    public void irCatalogo(View view) {
        Intent catalogoIntent = new Intent(this, CatalogoActivity.class);
        startActivity(catalogoIntent);
    }

}