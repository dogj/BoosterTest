package com.example.administrator.boostertest.results;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;
import com.example.administrator.boostertest.Data;
import com.example.administrator.boostertest.MainActivity;
import com.example.administrator.boostertest.R;

/***
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 * <p/>
 * Created by PangHaHa12138 on 2017/6/6.
 */
public class EmailFragment extends Fragment {

    EditText name;
    EditText phone;
    EditText email;
    Button submit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_email,container,false);
        name = view.findViewById(R.id.name_edit_text);
        phone = view.findViewById(R.id.edit_phone);
        email = view.findViewById(R.id.edit_email);
        submit = view.findViewById(R.id.email_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detail = "name: " +name.getText()+" phone: "+ phone.getText()+ " email: "+email.getText() +"\n";
                String text = detail + "Test score is "+ Data.count()+" and the investor type is ";
                            if(Data.count()<=12){
                                text = text+"defensive";
                                FragmentManager fm = getFragmentManager();
                                FragmentTransaction transaction = fm.beginTransaction();
                                AnswerDefensiveFragment answerDefensiveFragment = new AnswerDefensiveFragment();
                                transaction.replace(R.id.content, answerDefensiveFragment);
                                transaction.commit();
                            }else if(Data.count()<=20){
                                text = text+"conservative";
                                FragmentManager fm = getFragmentManager();
                                FragmentTransaction transaction = fm.beginTransaction();
                                AnswerConservativeFragment answerConservativeFragment = new AnswerConservativeFragment();
                                transaction.replace(R.id.content, answerConservativeFragment);
                                transaction.commit();

                            }else if(Data.count()<=29){
                                text = text+"balanced";
                                FragmentManager fm = getFragmentManager();
                                FragmentTransaction transaction = fm.beginTransaction();
                                AnswerBalancedFragment answerBalancedFragment = new AnswerBalancedFragment();
                                transaction.replace(R.id.content, answerBalancedFragment);
                                transaction.commit();

                            }else if(Data.count()<=37){
                                text = text+"balanced growth";
                                FragmentManager fm = getFragmentManager();
                                FragmentTransaction transaction = fm.beginTransaction();
                                AnswerBalancedGrowthFragment answerBalancedGrowthFragmentFragment = new AnswerBalancedGrowthFragment();
                                transaction.replace(R.id.content, answerBalancedGrowthFragmentFragment);
                                transaction.commit();

                            }else if(Data.count()<=44){
                                text = text+"growth";
                                FragmentManager fm = getFragmentManager();
                                FragmentTransaction transaction = fm.beginTransaction();
                                AnswerGrowthFragment answerGrowthFragment = new AnswerGrowthFragment();
                                transaction.replace(R.id.content, answerGrowthFragment);
                                transaction.commit();

                            }else if(Data.count()<=50){
                                text = text+"aggressive growth";
                                FragmentManager fm = getFragmentManager();
                                FragmentTransaction transaction = fm.beginTransaction();
                                AnswerAggressiveGrowthFragment answerAggressiveGrowthFragment = new AnswerAggressiveGrowthFragment();
                                transaction.replace(R.id.content, answerAggressiveGrowthFragment);
                                transaction.commit();
                            }else{
                                Toast.makeText(getActivity(),"something unexpected happened",Toast.LENGTH_SHORT).show();
                            }

                            BackgroundMail.newBuilder(getActivity())
                                    .withUsername("edongxxaq@gmail.com")
                                    .withPassword("021edongidc")
                                    .withMailto("jiangx04@gmail.com")
                                    .withType(BackgroundMail.TYPE_PLAIN)
                                    .withSubject("Questionnaire result ")
                                    .withBody(text)
                                    .withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
                                        @Override
                                        public void onSuccess() {
                                            //do some magic
                                        }
                                    })
                                    .withOnFailCallback(new BackgroundMail.OnFailCallback() {
                                        @Override
                                        public void onFail() {
                                            //do some magic
                                        }
                                    })
                                    .send();
            }
        });
        return view;
    }


}
