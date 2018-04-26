package com.sk7.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sk7.greendaodemo.entity.User;
import com.sk7.greendaodemo.gen.DaoMaster;
import com.sk7.greendaodemo.gen.DaoSession;
import com.sk7.greendaodemo.gen.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "lenve.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();

        userDao = daoSession.getUserDao();
    }

    public void insertData(View view) {
        //User user = new User(null, "zhangsan" + new Random().nextInt(9999), "张三");
        ///userDao.insert(user);
    }

    public void deleteData(View view) {
        /*List<User> userList = userDao.queryBuilder().where(UserDao.Properties.Id.le(10)).build().list();
        for (User user : userList) {
            userDao.delete(user);
        }*/

        /*User user = userDao.queryBuilder().where(UserDao.Properties.Id.eq(16)).build().unique();
        if (user == null) {
            Toast.makeText(MainActivity.this, "用户不存在", Toast.LENGTH_LONG).show();
        } else {
            userDao.deleteByKey(user.getId());
        }*/

        userDao.deleteAll();
    }

    public void updateData(View view) {
        User user = userDao.queryBuilder().where(UserDao.Properties.Id.ge(10), UserDao.Properties.Username.like("%90%")).build().unique();
        if (user == null) {
            Toast.makeText(MainActivity.this, "用户不存在", Toast.LENGTH_LONG).show();
        } else {
            user.setUsername("王五");
            userDao.update(user);
        }

    }

    public void queryData(View view) {
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Id.between(2, 50)).limit(5).build().list();
        for (User user : list) {
            Log.d("gggggggggggggg", "user = " + user);
        }
    }
}
